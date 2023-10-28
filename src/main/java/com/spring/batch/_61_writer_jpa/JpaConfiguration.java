package com.spring.batch._61_writer_jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class JpaConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public Job jpaJob() throws Exception {
        return jobBuilderFactory.get("jpaJob")
                .incrementer(new RunIdIncrementer())
                .start(jpaStep1())
                .build();
    }

    @Bean
    public Step jpaStep1() throws Exception {
        return stepBuilderFactory.get("jpaStep1")
                .<CustomerForm, CustomerEntity>chunk(10)
                .reader(jpaCustomItemReader())
                .processor(jpaCustomItemProcess()) // Writer 에는 Entity 객체를 넘겨줘야한다.
                .writer(jpaCustomItemWriter())
                .build();
    }

    @Bean
    public JpaItemWriter<CustomerEntity> jpaCustomItemWriter() {
        /*
            JpaItemWriter > write() 에서 entityManager 로 doWriter() 호출
            - entityManager.persis() 또는 merge()
         */
        return new JpaItemWriterBuilder<CustomerEntity>()
                .entityManagerFactory(entityManagerFactory)
                .usePersist(true) // true : persist(), false : merge()
                .build();
    }

    @Bean
    public ItemProcessor<? super CustomerForm, ? extends CustomerEntity> jpaCustomItemProcess() {
        return new CustomItemProcess();
    }

    @Bean
    public JdbcPagingItemReader<CustomerForm> jpaCustomItemReader() {

        JdbcPagingItemReader<CustomerForm> reader = new JdbcPagingItemReader<>();

        reader.setDataSource(this.dataSource);
        reader.setFetchSize(10);
        reader.setRowMapper(new CustomerRowMapper());

        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
        queryProvider.setSelectClause("id, firstName, lastName, birthdate");
        queryProvider.setFromClause("from customer");
        queryProvider.setWhereClause("where firstname like :firstname");

        Map<String, Order> sortKeys = new HashMap<>(1);

        sortKeys.put("id", Order.ASCENDING);
        queryProvider.setSortKeys(sortKeys);
        reader.setQueryProvider(queryProvider);

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("firstname", "C%");

        reader.setParameterValues(parameters);

        return reader;
    }

}
