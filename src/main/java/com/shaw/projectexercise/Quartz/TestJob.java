package com.shaw.projectexercise.Quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestJob {

  public static void main(String[] args) {
    JobDetail jobDetail= JobBuilder.newJob(MyJob.class)
        .withIdentity("job1","group1")//必须设置  一个组里，job名不能一样
        .usingJobData("job","xy")
        .build();
    Trigger trigger= TriggerBuilder.newTrigger()
        .withIdentity("trigger1","triggers")
        .withSchedule(
            SimpleScheduleBuilder.
                simpleSchedule().withIntervalInSeconds(1).repeatForever())
        .build();

    try {
      Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
      scheduler.scheduleJob(jobDetail,trigger);
      scheduler.start();
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }
}
