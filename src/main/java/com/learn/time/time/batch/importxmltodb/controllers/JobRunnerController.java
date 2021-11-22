//package com.learn.time.time.batch.importxmltodb.controllers;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.ws.rs.core.Response;
//
//@RestController
//@RequestMapping("job")
//public class JobRunnerController {
//
//    private final JobLauncher jobLauncher;
//    private final Job importJob;
//    private final Job customerXmlJob;
//
//    @Autowired
//    public JobRunnerController(JobLauncher jobLauncher, @Qualifier("importUserJob") Job importJob,
//                               @Qualifier("customerReportJob") Job customerXmlJob) {
//        this.jobLauncher = jobLauncher;
//        this.importJob = importJob;
//        this.customerXmlJob = customerXmlJob;
//    }
//
//    @RequestMapping(value = "startDbJob")
//    public Response startXmlDb() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        jobLauncher.run(importJob, new JobParameters());
//        return Response.ok("All is ok - !").build();
//    }
//
//    @RequestMapping(value = "startXmlJob")
//    public Response startXmlTxt() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        jobLauncher.run(customerXmlJob, new JobParameters());
//        return Response.ok("All is ok - !").build();
//    }
//}
