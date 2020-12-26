package com.san.workout;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple Java application using Spring batch
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        String springConfig = "context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        Job job = (Job) context.getBean("myfirstBatchJob");

        Map<String, JobParameter> parameterMap = new HashMap<String, JobParameter>();
        parameterMap.put("key", new JobParameter("sampleKey"));
        parameterMap.put("type", new JobParameter("sampleType"));
        parameterMap.put("mode", new JobParameter("standalone"));
        JobExecution execution = jobLauncher.run(job, new JobParameters(parameterMap));

        System.out.println("Exit Status : " + execution.getStatus());

        context.close();

    }
}
