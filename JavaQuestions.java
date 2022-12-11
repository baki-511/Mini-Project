package com.test.project1;

import java.sql.Connection;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;

public class JavaQuestions {
	 
	//method to get student answers
	public void getStudentAns(String name) {
		System.out.println("\n\t\t\t\t++++++++++++++++++++++++++++++ JAVA MCQ ++++++++++++++++++++++++++++++++++++++");
		int marks = 0;
		Scanner sc = new Scanner(System.in);
//		HashSet<Integer> hs = new HashSet<Integer>();
//		hs.add(1);
//		hs.add(2);
//		hs.add(3);
//		hs.add(4);
//		hs.add(5);
		
		ConnectProject cp = new ConnectProject();
		
		
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement ps =con.prepareStatement("select questions,choice1,choice2,choice3,choice4,main_ans from student_data "
					+ "order by rand()");
			
			ResultSet rs = ps.executeQuery();//ps.executeUpdate();
			int count = 1;
//			System.out.println(q1);
			while(rs.next()) {
				
//				String q1 = rs.getString(1);
				System.out.println("\n\t\t\t\t"+count+") "+rs.getString(1));
				System.out.println("\t\t\t\t\t1."+rs.getString(2));
				System.out.println("\t\t\t\t\t2."+rs.getString(3));
				System.out.println("\t\t\t\t\t3."+rs.getString(4));
				System.out.println("\t\t\t\t\t4."+rs.getString(5));
				count++;
				
//				System.out.println("Enter your question no :- ");
//				int num = sc.nextInt();
//				
//				PreparedStatement ps2 =con.prepareStatement("select questions,choice1,choice2,choice3,choice4 from student_data where question_id = ? ");
//				ps2.setInt(1, num);
//				ps2.executeQuery();
				
				System.out.print("\n\t\t\t\tEnter your choice : ");
				int choice = sc.nextInt();
				if(rs.getInt(6)==choice) {
					marks++;
				}
				
//				System.out.println(q1);
				System.out.println();
			}
			if(marks>=5) {
				System.out.println("\n\t\t\t\tYou are Passed");
			}
			else {
				System.out.println("\n\t\t\t\tSorry....You are Failed");
			}
			System.out.println("\n\t\t\t\tYour marks = "+marks);
			System.out.println("\t\t\t\t\tSuccessfully executed...");
			con.close();
			ps.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement pps =con.prepareStatement("insert into AllStudentDetails(student_name,student_marks) values(?,?)");
			pps.setString(1, name);
			pps.setInt(2, marks);
			pps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		setStudentsGrade();
	}
	//Method to display students ranks from Top.
	public void getStudentsRank() {
		System.out.println("\t\t\t\t\t\t********* All Students Rank  ***********");
		System.out.println("\t\t\t\t======================================================================");
		System.out.print("\t\t\t\t  Name");
		System.out.print("\t\t\t\tMarks");
		System.out.print("\t\t\tGrades\n");
		System.out.println("\t\t\t\t======================================================================");
//		System.out.println();
		ConnectProject cp = new ConnectProject();
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement psp=con.prepareStatement("select student_name, student_marks, student_grade from AllStudentDetails"
					+ " order by student_marks desc");
			ResultSet rst = psp.executeQuery();
			int no=1;
			while(rst.next()) {
				System.out.print("\n\t\t\t\t| "+no+". "+rst.getString(1));
				System.out.print("\t\t\t "+rst.getInt(2));
				System.out.print("\t\t\t"+rst.getString(3));
				System.out.println();
				System.out.println("\t\t\t\t----------------------------------------------------------------------");
				no++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Method to set students grades
	public void setStudentsGrade() {
		int j=0;//1 2 
		ConnectProject cp = new ConnectProject();
		try {
			Connection con = cp.getConnectionDetails();
			PreparedStatement psp=con.prepareStatement("select student_id,student_marks,student_name,student_grade from AllStudentDetails");
			ResultSet rst = psp.executeQuery();
			
			while(rst.next()) {
//				System.out.println(rst.getString(3)+"\t"+rst.getInt(1)+"\t"+rst.getString(4));
				PreparedStatement pp=con.prepareStatement("update AllStudentDetails set student_grade = ? where student_id = ?");
//				System.out.println(rst.getInt(2));
				if(rst.getInt(2)>= 8 && rst.getInt(2)<=10) {
					pp.setString(1, "A");
				}
				else if(rst.getInt(2)==7 || rst.getInt(2)==6) {
					pp.setString(1, "B");
				}
				else if(rst.getInt(2)== 5) {
					pp.setString(1, "C");
				}
				else if(rst.getInt(2)<5) {
					pp.setString(1, "Fail");
				}
				j++;// 2 3
				pp.setInt(2, j);
				pp.executeUpdate();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Executed Grades");
	}
	//Main method
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		JavaQuestions jq = new JavaQuestions();
//		System.out.print("Enter your name :- ");
//		String name = scan.next();
//		jq.getStudentAns(name);
//		jq.getStudentsRank();
//		jq.setStudentsGrade();
//	}

}
