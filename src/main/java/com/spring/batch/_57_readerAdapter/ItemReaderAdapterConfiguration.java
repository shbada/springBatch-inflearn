package com.spring.batch._57_readerAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ItemReaderAdapterConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job adapterJob() throws Exception {
        return jobBuilderFactory.get("adapterJob")
                .incrementer(new RunIdIncrementer())
                .start(adapterStep1())
                .build();
    }

    @Bean
    public Step adapterStep1() throws Exception {
        return stepBuilderFactory.get("adapterStep1")
                .<String,String>chunk(10)
                .reader(adapterCustomItemReader())
                .writer(adapterCustomItemWriter())
                .build();
    }

    @Bean
    public ItemReaderAdapter adapterCustomItemReader() {
        /*
           SimpleChunkProvider - doRead()
           - itemReader 는 ItermReaderAdapter 이다.
           - read() 호출 - AbstractMethodInvokingDelegator.java -> invokeDelegateMethod() 실행
                          -> 여기서 자바 리플렉션에 의해 아래 설정된 메서드를 실행한다.
           - CustomService - joinCustomer() 실행
         */
        ItemReaderAdapter reader = new ItemReaderAdapter();
        reader.setTargetObject(adapterCustomService());
        reader.setTargetMethod("joinCustomer");

        return reader;
    }

    private CustomService<String> adapterCustomService() {
        return new CustomService<>();
    }

    @Bean
    public ItemWriter<String> adapterCustomItemWriter() {
        return items -> {
            System.out.println(items);
        };
    }
}

