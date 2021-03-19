package jpa.service;
import java.util.List;

import jpa.dao.AbstractDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends AbstractDAO implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = null;
		connectToDB();
		try {
//			em.getTransaction().begin();
			students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
//			em.getTransaction().commit();
		}catch(Exception e) {
			students = null;
			e.printStackTrace();
		}finally{
			dispose();
		}
		
		return students;
	}//public List<Student> getAllStudents()

	@Override
	public Student getStudentByEmail(String sEmail) {
		connectToDB();
		
		Student foundStudent = null;
		try {
//			em.getTransaction().begin();
			foundStudent = em.find(Student.class, sEmail);
//			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dispose();
		}
		
		return foundStudent;
	}//public Student getStudentByEmail(String sEmail)

	@Override
	public boolean validateStudent(String sEmail, String sPass) {
		
		connectToDB();
		
		try {
			Student foundStudent = em.find(Student.class, sEmail);
			if(foundStudent == null) return false;
			
			//If I'm here the student is found. Now check the password
			if(foundStudent.getsPass().equals(sPass)) return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dispose();
		}
		
		return false;
	}//public boolean validateStudent(String sEmail, String sPass)

	@Override
	public void registerStudentToCourse(String sEmail, int cid) throws Exception {
		
		connectToDB();
		
		try {
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			dispose();
		}
		
	}//public void registerStudentToCourse(String sEmail, int cid) 

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		
		return null;
	}//public List<Course> getStudentCourses(String sEmail)

	

	
}//public class StudentService
