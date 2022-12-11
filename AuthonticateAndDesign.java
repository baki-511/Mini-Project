package com.test.project1;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AuthonticateAndDesign {
	public void checkExaminar(String name) {//Pravin
		JavaQuestions jq = new JavaQuestions();
		ConnectProject cp = new ConnectProject();
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement pss = con.prepareStatement("select student_name, student_marks from AllStudentDetails");
			ResultSet rs=pss.executeQuery();
			while(rs.next()) {
				 String checkName = name.toLowerCase();//pravin 
				 String s = rs.getString(1).toLowerCase();
//				 System.out.println(s + "   "+name);
				if(s.equals(checkName)) {
					System.out.println("\t\t\t\tSorry... You are not Eligible");
					return;
				}
			}
			jq.getStudentAns(name);//Pravin
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void particularStudentScore() {
		System.out.println("\t\t\t----------------------------- Particular Student Details -------------------------------");
		Scanner sc = new Scanner(System.in);
		ConnectProject cp = new ConnectProject();
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement pss = con.prepareStatement("select student_name, student_marks, student_grade from AllStudentDetails "
					+ "where student_name = ?");
			System.out.print("\n\t\t\t\t\tEnter student name :- ");
			String studentName = sc.next();
			pss.setString(1, studentName);
			ResultSet rs=pss.executeQuery();
			while(rs.next()) {
				System.out.println("\n\t\t\t\tName Of Student   = "+rs.getString(1));
				System.out.println("\t\t\t\tMarks Obtained    = "+rs.getInt(2));
				System.out.println("\t\t\t\t\tGrade     = "+rs.getString(3));
				System.out.println("\n\t\t\t-------------------------------------- End ----------------------------------------");
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		AuthonticateAndDesign ch = new AuthonticateAndDesign();
//		ch.particularStudentScore();
//	}
}
