package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSRunner {

	static StudentService studentService = new StudentService();
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome \n");
		System.out.println("Please enter an integer option: ");
		int operation = scan.nextInt();
		scan.nextLine();
		
		switch(operation) {
			case 1:
				getAllStudents();
				break;
			case 2:
				getStudentByEmail();
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				//exit
				break;
			default:
				break;
		}//switch
		

	}//public static void main(String[] args) 

	private static void getStudentByEmail() {
		System.out.println("Please enter the student's email: ");
		String sEmail = scan.nextLine();
		Student student = studentService.getStudentByEmail(sEmail);
		if(student != null) {
			System.out.println(student);
		}else {
			System.out.println("Student Not found");
		}
	
	}//private static void getStudentByEmail()

	private static void getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		System.out.println("All of the Students: \n");
		if(studentList != null) {
			for(Student student : studentList) {
				System.out.println(student + "\n");
			}
		}else {System.out.println("No Students");}
		
	}//private static void getAllStudents()

}//public class SMSRunner 
