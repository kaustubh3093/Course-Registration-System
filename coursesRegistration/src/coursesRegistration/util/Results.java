package coursesRegistration.util;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	String[][] courseinfo;
	String[][] studentpref;
	String console = "";
	
	@Override
	public void console_write(String str) {
		System.out.println(str);
	}
	
	@Override
	public void coursedata(String args) {
		FileProcessor fp = new FileProcessor();
		courseinfo = fp.courseinfo(args);
	}

	@Override
	public void studentdata(String args) {
		FileProcessor fp = new FileProcessor();
		studentpref = fp.student_coursePrefs(args);	
		Arrays.sort(studentpref , (a,b)-> b[10].compareTo(a[10]));
	}
	
    public void putoutput(String args){
    	try{
        PrintWriter printWriter = new PrintWriter(args);
    	HashMap<String, Integer> mapvacancy = new HashMap<>();
    	HashMap<String, Integer> maptiming = new HashMap<>();
    	for(int i = 0; i < courseinfo.length ; i++){
    		mapvacancy.put(courseinfo[i][0], Integer.parseInt(courseinfo[i][1]));
    		maptiming.put(courseinfo[i][0], Integer.parseInt(courseinfo[i][2]));
    	}
    	double totalSatisfaction = 0;
    	for(int i = 0; i < studentpref.length ; i++){
    		HashSet<Integer> hash = new HashSet<>();
    		int sub = 0;
    		double satisfaction = 0;
    		int idx = 1;
    		String str = "";
    		for(int j = 0; j < studentpref[0].length; j++){
    			if(sub == 3){
    				break;
    			}
    			if(mapvacancy.get(studentpref[i][idx]) > 0 && hash.contains(maptiming.get(studentpref[i][idx])) == false){
    				int val = mapvacancy.get(studentpref[i][idx]) - 1;
    				mapvacancy.put(studentpref[i][idx], val);
    				hash.add(maptiming.get(studentpref[i][idx]));
    				str += studentpref[i][idx] + ",";
    				satisfaction += 10 - idx;
    				idx++;
    				sub++;
    			}else{
    				idx++;
    			}
    		}
    		str = str.substring(0, str.length()-1);
    		console = studentpref[i][0] +" "+str+ "::SatisfactionRating= " +satisfaction/sub;
    		console_write(console);
			String textToAppend = studentpref[i][0]+"  " +str+ "::SatisfactionRating= " +satisfaction/3 ;
    		printWriter.println(textToAppend);
    		totalSatisfaction += satisfaction/3;
    		str = "";
    		sub = 0;
    		hash.clear();
    		satisfaction = 0;
    		idx = 1;
    	}
    	
    	totalSatisfaction = totalSatisfaction/studentpref.length;
    	String textToAppend = "AverageSatisfactionRating = " + totalSatisfaction;
    	printWriter.println(textToAppend);
    	printWriter.close();
    	}
    	catch(FileNotFoundException e){
    		System.out.println("Error in opening the file" + e.getMessage());
    	}
    }

}
