package com.spring.batch._70_retry.template;

import com.spring.batch._70_retry.RetryableException;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class RetryTemplateConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job retryTemplateJob() throws Exception {
        return jobBuilderFactory.get("retryTemplateJob")
                .incrementer(new RunIdIncrementer())
                .start(retryTemplateStep1())
                .build();
    }

    @Bean
    public Step retryTemplateStep1() throws Exception {
        return stepBuilderFactory.get("retryTemplateStep1")
                .<String, Customer>chunk(5)
                .reader(retryTemplateReader())
                .processor(retryTemplateProcessor())
                .writer(retryTemplateWriter())
                .faultTolerant()
//                .skip(RetryableException.class)
//                .skipLimit(2)
//                .retryPolicy(retryPolicy())
                .build();
    }

    @Bean
    public ListItemReader<String> retryTemplateReader() {

        List<String> items = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            items.add(String.valueOf(i));
        }

        return new ListItemReader<>(items);
    }

    @Bean
    public ItemProcessor retryTemplateProcessor() {
        RetryItemProcessor2 processor = new RetryItemProcessor2();
        return processor;
    }

    @Bean
    public ItemWriter retryTemplateWriter() {
        RetryItemWriter2 writer = new RetryItemWriter2();
        return writer;
    }

    @Bean
    public SimpleRetryPolicy retryTemplateRetryPolicy() {
        Map<Class<? extends Throwable>, Boolean> exceptionClass = new HashMap<>();
        exceptionClass.put(RetryableException.class, true);
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(2, exceptionClass);
        return simpleRetryPolicy;
    }

    @Bean
    public RetryTemplate retryTemplate() {

        Map<Class<? extends Throwable>, Boolean> exceptionClass = new HashMap<>();
        exceptionClass.put(RetryableException.class, true);

//        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
//        backOffPolicy.setBackOffPeriod(2000); //지정한 시간만큼 대기후 재시도 한다.

        // RetryTemplate 이 사용하는 SimpleRetryPolicy 도 설정
        // 최대 count : 2, exception class 지정
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(2, exceptionClass);
        RetryTemplate retryTemplate = new RetryTemplate();
//        retryTemplate.setBackOffPolicy(backOffPolicy);
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }
}