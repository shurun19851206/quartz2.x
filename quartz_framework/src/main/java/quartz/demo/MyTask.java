package quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTask implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("==============");
	}
}
