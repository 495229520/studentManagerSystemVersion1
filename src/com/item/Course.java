package com.item;

import java.io.Serializable;

/**
 * ����:com.item
 *
 * @author hwf
 * ����2022-11-2022/11/11   12:23
 */
public class Course implements Serializable{

	public String courseId = null;  //�γ̱��
	public String courseName = null;  //�γ���
	public String courseMark = "0";  //�γ̷���
	public String rank = null;
	private static final long serialVersionUID = -3427636581486352243L;

	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseMark() {
		return courseMark;
	}
	public void setCourseMark(String courseMark) {
		this.courseMark = courseMark;
	}
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Course(String courseId, String courseName, String courseMark) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseMark = courseMark;
	}
	
	public Course() {
		super();
	}
	
	public int searchCourse(){
		return 0;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName
				+ ", courseMark=" + courseMark + "]";
	}

}
