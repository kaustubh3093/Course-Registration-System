package coursesRegistration.scheduler;

import java.io.IOException;

import coursesRegistration.util.Results;

public class Scheduler {
	
	public void schedule_course(String args1 , String args2 , String args3){
		Results r = new Results();
		r.coursedata(args1);
		r.studentdata(args2);
		r.putoutput(args3);
	}
}
