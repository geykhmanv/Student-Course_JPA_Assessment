package jpa.entitymodels;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student_Course {
	
	@Id
	private String Student_SEMAIL;
	private int sCourses_CID;
	
	//constructors
	public Student_Course() {
		super();
	}
	public Student_Course(String student_SEMAIL, int sCourses_CID) {
		super();
		this.Student_SEMAIL = student_SEMAIL;
		this.sCourses_CID = sCourses_CID;
	}
	
	//getters and setters
	public String getStudent_SEMAIL() {
		return Student_SEMAIL;
	}
	public void setStudent_SEMAIL(String student_SEMAIL) {
		Student_SEMAIL = student_SEMAIL;
	}
	public int getsCourses_CID() {
		return sCourses_CID;
	}
	public void setsCourses_CID(int sCourses_CID) {
		this.sCourses_CID = sCourses_CID;
	}
	
	
	
	
	
	
	

}//public class Student_Course 
