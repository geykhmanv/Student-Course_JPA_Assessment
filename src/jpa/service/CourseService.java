package jpa.service;

import java.util.List;

import jpa.dao.AbstractDAO;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;


public class CourseService extends AbstractDAO implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = null;
		
		connectToDB();
		
		try {
			courses = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			dispose();
		}
		
		return courses;
	}//public List<Course> getAllCourses()

}//public class CourseService
