package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	static StudentService studentService = new StudentService();
	static CourseService courseService = new CourseService();
	static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) throws Exception {
		
		//student credentials validation
		System.out.println("Welcome \n");
		System.out.println("Are you a: \n 1. Student \n 2. Quit");
		int choice = scan.nextInt();
		scan.nextLine();
		if(choice == 1) {
			//student validation
			System.out.println("Please enter your email: ");
			String sEmail = scan.nextLine();
			System.out.println("Please enter your password: ");
			String sPass = scan.nextLine();
			
			boolean isStudentValid = studentService.validateStudent(sEmail, sPass);
			if(isStudentValid) {
				System.out.println("Student Valid \n");
				System.out.println("My Classes: ");
				
				//get the student's courses
				List<Course> courseList = studentService.getStudentCourses(sEmail);
				if(!courseList.isEmpty()) {
					System.out.printf("%-10s %-20s %-20s%n", "COURSE ID", "COURSE INSTRUCTOR", "COURSE NAME");
					for(Course course : courseList) {
						System.out.format("%-10d %-20s %-20s%n", course.getCid(), course.getcName(), course.getcInstructorName() );
					}
				}else System.out.println("You have no courses");
				
				showMenu();
				
			}else System.out.println("Student Not Valid");
			
			
		}else {
			System.out.println("Goodbye");
			System.exit(0);
		}
		
	}//public static void main(String[] args) 

	private static void showMenu() throws Exception {
		System.out.println("Please choose an option: ");
		System.out.println("1. Get All Students");
		System.out.println("2. Get A Student By Email");
		System.out.println("3. Register for a Course");
		System.out.println("4. Get All Courses");
		System.out.println("5. Log Out");
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
				registerStudentToCourse();
				break;
			case 4:
				getAllCourses();
				break;
			case 5:
				System.out.println("Logging Out...");
				System.exit(0);
				break;
			default:
				break;
		}//switch
		
	}//private static void showMenu() 

	private static void getAllCourses() {
		List<Course> courseList = courseService.getAllCourses();
		System.out.println("All of the Courses: \n");
		if(!courseList.isEmpty()) {
			System.out.printf("%-10s %-20s %-20s%n", "COURSE ID", "COURSE INSTRUCTOR", "COURSE NAME");
			for(Course course : courseList) {
				System.out.format("%-10d %-20s %-20s%n%n", course.getCid(), course.getcName(), course.getcInstructorName() );
				System.out.println("");
			}
		}else {
			System.out.println("No Courses \n");
			System.out.println("");
		}
		
		
	}//private static void getAllCourses()

	private static void registerStudentToCourse() throws Exception {
		System.out.println("Please enter student email: ");
		String sEmail = scan.nextLine();
		System.out.println("Please enter course ID for which you'd like to register: ");
		int cid = scan.nextInt();
		scan.nextLine();
		
		studentService.registerStudentToCourse(sEmail, cid);
		
	}//private static void registerStudentToCourse() 

	private static void getStudentByEmail() {
		System.out.println("Please enter the student's email: ");
		String sEmail = scan.nextLine();
		Student student = studentService.getStudentByEmail(sEmail);
		if(student != null) {
			System.out.printf("%-50s %-20s%n", "STUDENT EMAIL", "STUDENT NAME");
			System.out.format("%-50s %-20s%n", student.getsEmail(), student.getsName());
		}else {
			System.out.println("Student Not found");
		}
	
	}//private static void getStudentByEmail()

	private static void getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		System.out.println("All of the Students: \n");
		if(!studentList.isEmpty()) {
			System.out.printf("%-50s %-20s%n", "STUDENT EMAIL", "STUDENT NAME");
			for(Student student : studentList) {
				System.out.format("%-50s %-20s%n", student.getsEmail(), student.getsName());
			}
		}else System.out.println("No Students");
		
	}//private static void getAllStudents()

}//public class SMSRunner 
