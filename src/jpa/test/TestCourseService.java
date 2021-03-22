package jpa.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jpa.entitymodels.Course;
import jpa.service.CourseService;

public class TestCourseService {
	
	CourseService courseService = new CourseService();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllCourses() {
		//fail("Not yet implemented");
		List<Course> expectedCourseList = new ArrayList<>();
		expectedCourseList.add(new Course(1, "Anderea Scamaden", "English"));
		expectedCourseList.add(new Course(2, "Eustace Niemetz", "Mathematics"));
		expectedCourseList.add(new Course(3, "Reynolds Pastor", "Anatomy"));
		expectedCourseList.add(new Course(4, "Odessa Belcher", "Organic Chemistry"));
		expectedCourseList.add(new Course(5, "Dani Swallow", "Physics"));
		expectedCourseList.add(new Course(6, "Glenden Reilingen", "Digital Logic"));
		expectedCourseList.add(new Course(7, "Giselle Ardy", "Object Oriented Programming"));
		expectedCourseList.add(new Course(8, "Carolan Stoller", "Data Structures"));
		expectedCourseList.add(new Course(9, "Carmita De Maine", "Politics"));
		expectedCourseList.add(new Course(10, "Kingsly Doxsey", "Art"));
		
		List<Course> actualCourseList = courseService.getAllCourses();
		assertEquals(expectedCourseList, actualCourseList);
		
	}//public void testGetAllCourses()

}//public class TestCourseService
