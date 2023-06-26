package com.shaw.projectexercise.Quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

  private String name;

  public void setName(String name) {
//    通过jobDetail 的 usingJobData可以直接设置值
    this.name = name;
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    JobDataMap detailMap = jobExecutionContext.getJobDetail().getJobDataMap();
    JobDataMap triggerMap = jobExecutionContext.getTrigger().getJobDataMap();
//    合并map 如果键重复，detailMap会被覆盖
    JobDataMap mergeMap = jobExecutionContext.getMergedJobDataMap();
    System.out.println(detailMap.get("job"));
    System.out.println(triggerMap.get("trigger"));
  }
}
