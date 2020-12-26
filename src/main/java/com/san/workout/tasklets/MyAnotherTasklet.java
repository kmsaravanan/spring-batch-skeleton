package com.san.workout.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyAnotherTasklet implements Tasklet{

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println("Inside my another tasklet");
        System.out.println("Step Name: "+chunkContext.getStepContext().getStepName());
        System.out.println("Job Parameters "+ chunkContext.getStepContext().getJobParameters());
        return RepeatStatus.FINISHED;
        
    }

}
