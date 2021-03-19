package jpa.mainrunner;

import java.util.List;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class SMSRunner {

	static StudentService studentService = new StudentService();
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome");
		int operation = 1;
		switch(operation) {
			case 1:
				getAllStudents();
				break;
			case 2:
				
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

	private static void getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		if(studentList != null) {
			System.out.println(studentList);
		}else {System.out.println("No Students");}
		
	}//private static void getAllStudents()

}//public class SMSRunner 
