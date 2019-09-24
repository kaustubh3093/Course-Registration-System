# Course-Registration-System

## Name: Kaustubh Singh 

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

1)Navigate to the src folder in the linux or remote.cs
-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run: Change the file path below and also in Driver.java class

####Command: ant -buildfile build.xml run -Darg0="/home/kaustubh/Documents/Fall19/Kaustubh_Singh_assign1/coursesRegistration/src/courseInfo.txt" -Darg1="/home/kaustubh/Documents/Fall19/Kaustubh_Singh_assign1/coursesRegistration/src/student_coursePrefs.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
1) In Driver class we make the object of scheduler class and pass the files path in schedule_course method of the scheduler class
2) In Scheduler class I make an object of Result class and calls coursedata, studentdata, putOutput method of the result class
3) In Result class in coursedata and studentdata created object of FileProcessor class and calls courseinfo and student_coursePrefs of FileProcessor respectively to populate courseinfo and studentpref array. Also, I sorted the studentpref array based on the first year, second year and third year in decending order so that third year student will get allocated first then second year then first year.
4) In Result class in putObject method created mapvacancy and maptiming to track number of students left in the course and timing so that courses should not overlap in timing for a particluar student. Calculated satisfaction and overall average satisfaction and printed all these in output file.

