package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	
	public int registerStudentToCourse(Student student);
	public Student getStudentByEmail(String sEmail);
	public List<Student> getAllStudents();
	public boolean validateStudent(String sPass);
	public List<Course> getStudentCourses();
	
	
}//public interface StudentDAO 
