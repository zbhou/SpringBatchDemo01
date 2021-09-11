package com.batch.springbatchdemo.demo01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbhou  on  2021/9/11 9:31
 */

@Configuration
@EnableBatchProcessing  //加入注解
public class batchDemo {

    //最核心的两个组件 jboBuildFactory,stepBuilderFactory
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jboDemo(){

        return jobBuilderFactory.get("jboDemo")
                .start(step01()).build();

    }

    @Bean
    public Step step01(){
        return stepBuilderFactory.get("step01").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("step01");
                return null;
            }
        }).build();
    }
}
