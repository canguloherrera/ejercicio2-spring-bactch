package com.example.bacth.demobatch.config;

import com.example.bacth.demobatch.domain.CreditCard;
import com.example.bacth.demobatch.domain.CreditCardRisk;
import com.example.bacth.demobatch.job.CreditCardItemProcessor;
import com.example.bacth.demobatch.job.CreditCardItemReader;
import com.example.bacth.demobatch.job.CreditCardItemWriter;
import com.example.bacth.demobatch.listener.CreditCardIItemReaderListener;
import com.example.bacth.demobatch.listener.CreditCardIItemWriterListener;
import com.example.bacth.demobatch.listener.CreditCardItemProcessListener;

import com.example.bacth.demobatch.listener.CreditCardJobExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public CreditCardItemReader reader() {

        return new CreditCardItemReader();
    }

    @Bean
    public CreditCardItemProcessor processor() {

        return new CreditCardItemProcessor();
    }

    @Bean
    public CreditCardItemWriter writer() {

        return new CreditCardItemWriter();
    }



    @Bean
    public CreditCardIItemReaderListener readerListener() {

        return new CreditCardIItemReaderListener();
    }

    @Bean
    public CreditCardItemProcessListener creditCardItemProcessListener() {

        return new CreditCardItemProcessListener();
    }

    @Bean
    public CreditCardIItemWriterListener writerListener() {

        return new CreditCardIItemWriterListener();
    }

    @Bean
    public CreditCardJobExecutionListener jobExecutionListener() {

        return new CreditCardJobExecutionListener();
    }

    @Bean
    public Job job(Step step, CreditCardJobExecutionListener jobExecutionListener) {
        return jobBuilderFactory.get("job1")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(CreditCardItemReader reader,
                     CreditCardItemWriter writer,
                     CreditCardItemProcessor processor,
                     CreditCardIItemReaderListener readerListener,
                     CreditCardItemProcessListener creditCardItemProcessListener,
                     CreditCardIItemWriterListener writerListener) {

        return stepBuilderFactory.get("step1")
                .<CreditCard, CreditCardRisk>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(creditCardItemProcessListener)
                .listener(writerListener)
                .build();
    }

}
