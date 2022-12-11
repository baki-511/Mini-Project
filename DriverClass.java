package com.test.project1;

import java.util.Scanner;

public class DriverClass {
	public void chooseOption() {
		design();
		AuthonticateAndDesign design = new AuthonticateAndDesign();
		JavaQuestions callRank = new JavaQuestions();
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\t\t\t\t\t\tPlease select : ");
		int choose = scan.nextInt();
		System.out.println("\n\t\t\t\t\t==================== Exam For All =====================\n");
		System.out.println();
		switch(choose) {
		case 0:
			return;
		case 1 :
			//For giving exam
			System.out.println("\n\t\t\t---------------------------------- Exam Authontication ------------------------------");
			System.out.print("\n\t\t\t\tEnter your name : ");
			String name = scan.next();
			design.checkExaminar(name);
			System.out.println("\n\t\t\t----------------------------------  Exam Finished   ------------------------------");
			break;
			
		case 2 :
			//All students ranks from top
			callRank.getStudentsRank();
			break;
			
		case 3 :
			//Get result of Particular student
			design.particularStudentScore();
			break;
			
		default:
			System.out.println("Invalid Input");
		}
		System.out.println("\t\t\t---------------------------------------------------------------------------------------------------");
	}
	public void design() {
		System.out.println("\n\n\n");
		System.out.println("\t\t\t************************************ Velocity JAVA Exam *************************************\n\n");
		System.out.println("\t\t\t\t\t==================== Exam For All =====================\n");
		System.out.println("\t\t\t\t\t\tSelect your Option\n");
	
		System.out.println("\t\t\t\t\t\t1) Start Java Mcq Exam");
		System.out.println("\t\t\t\t\t\t2) All Students Ranks");
		System.out.println("\t\t\t\t\t\t3) Particluar Student Details");
		System.out.println("\t\t\t\t\t\t0) For EXIT");
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DriverClass dc = new DriverClass();
		int choice = 1;
		while(choice != 0) {
			dc.chooseOption();
			System.out.print("\n\t\t\t\tFor continue press[Any Key] Exit[0] : ");
			choice = sc.nextInt();
		}
		System.out.println("\n\t\t\t***********************************   END   ****************************************");
		System.out.println("Successfully Exited");
		System.out.println();
	}
		
}
