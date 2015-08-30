package quartz.demo1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping(value="/triggerController")
public class MyDemoAddController {
	
	@RequestMapping("/stopTrigger")
	public String stopTrigger (HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		StdScheduler quartzScheduler = (StdScheduler) wac.getBean("schedulerFactoryBean");
		try {
			quartzScheduler.pauseAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	@RequestMapping("/startTrigger")
	public String startTrigger (HttpServletRequest request, HttpServletResponse response) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		StdScheduler quartzScheduler = (StdScheduler) wac.getBean("schedulerFactoryBean");
		try {
			quartzScheduler.resumeAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return "list";
	}

}
