package coursesRegistration.driver;

import java.io.IOException;

import coursesRegistration.scheduler.Scheduler;
import coursesRegistration.util.Results;


public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}
		
		
		String args1 =  args[0];
		String args2 =  args[1];
               
		String args3 = "/home/kaustubh/Documents/Fall19/Kaustubh_Singh_assign1/coursesRegistration/src/registration_results.txt";
		
		//Code starts from here
		Scheduler s = new Scheduler();
		s.schedule_course(args1,args2,args3);
	}
}
