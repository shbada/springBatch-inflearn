package com.spring.batch._52_reader_json;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@RequiredArgsConstructor
@Configuration
public class JsonConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jsonReaderJob() {
        return jobBuilderFactory.get("jsonReaderJob")
                .incrementer(new RunIdIncrementer())
                .start(jsonReaderStep1())
                .build();
    }

    @Bean
    public Step jsonReaderStep1() {
        return stepBuilderFactory.get("jsonReaderStep1")
                .<Customer, Customer>chunk(3)
                .reader(jsonReaderCustomItemReader())
                .writer(jsonReaderCustomItemWriter())
                .build();
    }

    @Bean
    public JsonItemReader<Customer> jsonReaderCustomItemReader(){
        return new JsonItemReaderBuilder<Customer>()
                .name("jsonItemReader")
                // JsonItemReader > doRead() > JacksonJsonObjectReader > read() 호출
                .jsonObjectReader(new JacksonJsonObjectReader<>(Customer.class))
                .resource(new ClassPathResource("customer.json"))
                .build();
    }

    @Bean
    public ItemWriter<Customer> jsonReaderCustomItemWriter() {
        return items -> {
            for (Customer item : items) {
                System.out.println(item.toString());
            }
        };
    }
}
