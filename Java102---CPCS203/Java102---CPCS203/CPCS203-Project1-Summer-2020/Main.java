package com.CodeWithShehab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    private static File inFile;
    private static File outFile;
    private static Scanner scanner;
    private static PrintWriter writer;
    private static String[] courses;
    private static String[][] studentsForCourses;
    private static String[] examTypes;
    private static int[][][] grades;
    private static String bestStudent;
    private static String highestCourseGrade;
    private static int bestGrade;

    public static void main(String[] args) throws FileNotFoundException {
        // initializing "inFile" object and scanner object so scanner object can read from the file
        inFile = new File("input.txt");
        scanner = new Scanner(inFile);
        // check if the file exists
        if (!inFile.exists()) {
            System.out.println("File Doesn't Exist!!!");
            return;
        }
        courses = new String[scanner.nextInt()];
        studentsForCourses = new String[courses.length][];
        for (int i = 0; i < courses.length; i++) {
            studentsForCourses[i] = new String[scanner.nextInt()];
        }
        // just to skip the line stored in the buffer
        scanner.nextLine();
        // initializing the output file and the object which will write to the project
        outFile = new File("output.txt");
        writer = new PrintWriter(outFile);
        // loop to go through all the lines till the input file end
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            // first expression because in some-cases the buffer will hold the nextline symbol in in it
            if (split[0].equals("") || split[0].equals("Quit"))
                continue;
            if (!split[0].equals("Add_Marks"))
                writer.print("COMMAND: ");
            // switch didn't contain default case because it's not needed
            switch (split[0]) {
                case "Add_Course":
                    writer.print(split[0] + "\n");
                    writer.println("***Course Record For Exam Grading System***\n");
                    for (int i = 0; i < courses.length; i++) {
                        writer.print(" - Course: " + split[i + 1]);
                        courses[i] = split[i + 1];
                    }
                    writer.println("");
                    break;
                case "Add_ExamType":
                    examTypes = new String[split.length - 1];
                    writer.print(split[0] + "\n");
                    writer.println("***Exam Type Record For Exam Grading System***\n");
                    for (int i = 0; i < examTypes.length; i++) {
                        writer.print(" - Exam Type: " + split[i + 1]);
                        examTypes[i] = split[i + 1];
                    }
                    writer.println();
                    break;
                case "Add_Student_For_Course":
                    writer.print(split[0] + "\n");
                    writer.println("***Student Record For Exam Grading System***\n");
                    int courseIndex = Integer.parseInt(split[1]);
                    for (int j = 0; j < studentsForCourses[courseIndex].length; j++) {
                        writer.print(" - Name: " + split[j + 2]);
                        studentsForCourses[courseIndex][j] = split[j + 2];
                    }
                    writer.println();
                    break;
                case "Add_Marks":
                    grades = new int[courses.length][][];
                    for (int i = 0; i < courses.length; i++) {
                        grades[i] = new int[studentsForCourses[i].length][examTypes.length];
                    }
                    for (int i = 0; i < courses.length; i++) {
                        for (int j = 0; j < studentsForCourses[i].length; j++) {
                            for (int k = 0; k < examTypes.length; k++) {
                                grades[i][j][k] = scanner.nextInt();
                            }
                        }
                    }
                    continue;
                case "Print_Result":
                    int topGrade = 0, totalGrades = 0;
                    String topStudent = "";
                    writer.print(split[0] + "\n");
                    writer.println("***Students Winner Record For Exam Grading System***\n");
                    writer.println("-- (Students Total Marks)  Result For Course " + split[1] + " --\n");
                    courseIndex = -1;
                    // this loop gets the index of the course
                    for (int i = 0; i < courses.length; i++) {
                        if (split[1].equals(courses[i])) {
                            courseIndex = i;
                            break;
                        }
                    }
                    for (int i = 0; i < studentsForCourses[courseIndex].length; i++) {
                        for (int j = 0; j < examTypes.length; j++) {
                            totalGrades = totalGrades + grades[courseIndex][i][j];
                        }
                        writer.print(studentsForCourses[courseIndex][i] + " " + totalGrades + ",\n");
                        if (totalGrades > topGrade) {
                            topGrade = totalGrades;
                            topStudent = studentsForCourses[courseIndex][i];
                            if (topGrade > bestGrade) {
                                bestGrade = topGrade;
                                bestStudent = topStudent;
                                highestCourseGrade = split[1];
                            }
                        }
                        totalGrades = 0;
                    }
                    writer.println("\nTopper in the course is  :  " + topStudent.toUpperCase() + "  with Marks " + topGrade + " / 100\n");
                    break;
                case "Print_Result_For_All":
                    writer.println("PRINT_RESULT_FOR_ALL");
                    writer.println("***High Marks gainer from all courses For Exam Grading System***\n");
                    writer.println(bestStudent + " is The Highest marks gainer in all Courses from  :  " + highestCourseGrade + "  with Marks " + bestGrade + " / 100 ");
                    break;
            }
            writer.println("-------------------------------------------------------------------------------------------------------\n");
        }
        writer.println("\nThank you for using Exam Grading System, Good Bye!");
        writer.close();
    }
}
