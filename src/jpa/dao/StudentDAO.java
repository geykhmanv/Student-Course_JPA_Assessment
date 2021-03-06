package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
	
	public List<Student> getAllStudents();
	public Student getStudentByEmail(String sEmail);
	public boolean validateStudent(String sEmail, String sPass);
	public void registerStudentToCourse(String sEmail, int cid) throws Exception;
	public List<Course> getStudentCourses(String sEmail);
	
	
}//public interface StudentDAO 
