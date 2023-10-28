package com.spring.batch._77_operation;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobOperationConfiguration {

    public final JobBuilderFactory jobBuilderFactory;
    public final StepBuilderFactory stepBuilderFactory;
    public final JobRegistry jobRegistry; // 스프링 배치가 초기화될 때 빈으로 등록

    @Bean
    public Step jobOperationStep1() throws Exception {
        return stepBuilderFactory.get("jobOperationStep1")
                .tasklet((contribution, chunkContext) ->
                        {
                            System.out.println("step1 was executed");
                            Thread.sleep(5000);
                            return RepeatStatus.FINISHED;
                        }
                )
                .build();
    }
    @Bean
    public Step jobOperationStep2() throws Exception {
        return stepBuilderFactory.get("jobOperationStep2")
                .tasklet((contribution, chunkContext) ->
                        {
                            System.out.println("step2 was executed");
                            Thread.sleep(5000);
                            return RepeatStatus.FINISHED;
                        }
                )
                .build();
    }
    @Bean
    public Job jobOperationJob() throws Exception {
        return jobBuilderFactory.get("jobOperationJob")
                .incrementer(new RunIdIncrementer())
                .start(jobOperationStep1())
                .next(jobOperationStep2())
                .build();
    }

    /**
     * JobRegistryBeanPostProcessor
     */
    @Bean
    public BeanPostProcessor jobRegistryBeanPostProcessor() throws Exception {
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry); // 빈 셋팅
        return postProcessor;
    }
}
