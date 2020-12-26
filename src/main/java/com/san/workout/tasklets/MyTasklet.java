package com.san.workout.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Welcome to Spring Batch World!!!");
        for (int i = 0; i < 5; i++) {
            System.out.println(arg1.getStepContext().getStepName() + " is running");
            Thread.sleep(1000);
        }
        return RepeatStatus.FINISHED;
    }

}
