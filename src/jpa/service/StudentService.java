package jpa.service;
import java.util.List;

import jpa.dao.AbstractDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService extends AbstractDAO implements StudentDAO {

	@Override
	public int registerStudentToCourse(Student student) {
		return 0;
	}//public int registerStudentToCourse(Student student)

	@Override
	public Student getStudentByEmail(String sEmail) {
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = null;
		connectToDB();
		try {
			em.getTransaction().begin();
			students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
			em.getTransaction().commit();
		}catch(Exception e) {
			students = null;
			e.printStackTrace();
		}
		dispose();
		return students;
	}//public List<Student> getAllStudents()

	@Override
	public boolean validateStudent(String sPass) {
		return false;
	}

	@Override
	public List<Course> getStudentCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}//public class StudentService
