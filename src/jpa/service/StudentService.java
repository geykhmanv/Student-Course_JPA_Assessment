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
			students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		}catch(Exception e) {
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
			foundStudent = em.find(Student.class, sEmail);
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
			List studentEmails = em.createNativeQuery("SELECT Student_SEMAIL"
					+ " FROM student_course sc"
					+ " WHERE sc.Student_SEMAIL = ? AND sc.sCourses_CID = ?")
			.setParameter(1, sEmail)
			.setParameter(2, cid)
			.getResultList();
			
			if(studentEmails.isEmpty()) {
				System.out.println("Student is not registered for Course #" + cid);
				System.out.println("Registering " + sEmail + " for Course #" + cid + "...");
				
				//register student for new course
				em.getTransaction().begin();
				int newRegister = em.createNativeQuery("INSERT INTO student_course VALUES (?, ?)")
						.setParameter(1, sEmail)
						.setParameter(2, cid)
						.executeUpdate();
				em.getTransaction().commit();
				
				if(newRegister == 1) {
					System.out.println("Student is now registered for Course #" + cid);
				}else System.out.println("Error");
				
			}else System.out.println("Student is already registered for Course #" + cid);
				
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			dispose();
		}
		
	}//public void registerStudentToCourse(String sEmail, int cid) 

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		connectToDB();
		
		List<Course> courseList = null;
		try {
			Student foundStudent = em.find(Student.class, sEmail);
			if(foundStudent != null) courseList = foundStudent.getsCourses();
			else System.out.println("Student not found");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dispose();
		}
		
		return courseList;
	}//public List<Course> getStudentCourses(String sEmail)

	

	
}//public class StudentService
