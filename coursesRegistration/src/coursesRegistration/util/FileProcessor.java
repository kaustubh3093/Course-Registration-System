package coursesRegistration.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileProcessor {
		String[][] courseinfo = new String[9][3];
		public String[][] student_coursePrefs(String args){
			ArrayList<String> student_coursePrefs = new ArrayList<>();
			try {
				Scanner scanner1 = new Scanner(new File(args));	
				scanner1.useDelimiter("\\n");
				while(scanner1.hasNext()){
					String str = scanner1.next();
					student_coursePrefs.add(str);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			String[][] student_coursePref = new String[student_coursePrefs.size()][11];
			int p = 0;
			int q = 1;
			for(int l = 0; l < student_coursePrefs.size() ; l++){
				String course = student_coursePrefs.get(l);
				course = course.trim();
				student_coursePref[p][0] = course.substring(0,3);
				course = course.substring(3);
				course = course.trim();
				course=course.replaceAll("::",",");
				String courseArr[]= course.split(",");
				for(int z = 0; z < courseArr.length ; z++){
					student_coursePref[p][q] = courseArr[z].trim();
					q++;
				}
				q = 1;
				p++;
			}
			return student_coursePref;
		}
		
		public String[][] courseinfo(String args){
			ArrayList<String> student_coursePrefs = new ArrayList<>();
			int k = 0;
			int m = 1;
			try {
				Scanner scanner = new Scanner(new File(args));	
				scanner.useDelimiter("\\n");
				while(scanner.hasNext()){
					String str = scanner.next();
					    courseinfo[k][0] = Character.toString(str.charAt(0));
					    int flag = 0;
					    String digit = "";
						for(int i = 1; i < str.length() ; i++){
							if (Character.isDigit(str.charAt(i))) {
				                digit += str.charAt(i);
				                flag++;
				                if(i == str.length() -1){
									courseinfo[k][m] = digit;
								}
				            }
							else if(Character.isDigit(str.charAt(i)) == false && flag > 0){
								courseinfo[k][m] = digit;
								digit = "";
								m++;
								flag = 0;
							}
							else{
								continue;
							}
						}
						k++;
						m=1;
					}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return courseinfo;
		}
		
		
}
