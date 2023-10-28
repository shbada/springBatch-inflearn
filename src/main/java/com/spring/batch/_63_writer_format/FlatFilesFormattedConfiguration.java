package com.spring.batch._63_writer_format;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.*;

@RequiredArgsConstructor
@Configuration
public class FlatFilesFormattedConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job flatFilesFormattedJob() throws Exception {
        return jobBuilderFactory.get("flatFilesFormattedJob")
                .incrementer(new RunIdIncrementer())
                .start(flatFilesFormattedStep1())
                .build();
    }

    @Bean
    public Step flatFilesFormattedStep1() throws Exception {
        return stepBuilderFactory.get("flatFilesFormattedStep1")
                .<String,String>chunk(10)
                .reader(flatFilesFormattedCustomItemReader())
                .writer(flatFilesFormattedCustomItemWriter())
                .build();
    }

    @Bean
    public ListItemReader flatFilesFormattedCustomItemReader() {

        List<Customer> customers = Arrays.asList(new Customer(1, "hong gil dong1", 41),
                new Customer(2, "hong gil dong2", 42),
                new Customer(3, "hong gil dong3", 43));

        ListItemReader<Customer> reader = new ListItemReader<>(customers);
        return reader;
    }

    @Bean
    public FlatFileItemWriter<Customer> flatFilesFormattedCustomItemWriter() throws Exception {
        return new FlatFileItemWriterBuilder<Customer>()
                .name("customerWriter")
                .resource(new ClassPathResource("createWriter\\customer.csv"))
                .formatted()
                .format("%-2s%-15s%-2d") // 2글자 문자열, 14글자 문자열, 2글자 숫자
                .names(new String[] {"id", "name", "age"})
                .build();
    }
}
