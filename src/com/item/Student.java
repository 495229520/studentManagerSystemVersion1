package com.item;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 包名:com.item
 *
 * @author hwf
 * 日期2022-11-2022/11/11   12:24
 */
public class Student implements Serializable {
	private String id = null;	
	private String password = null;
	private String name = null;
	private String age = null;
	private String sex = null;
	private String address = null;
	private String birthday = null;
	private String ethnic = null;
	private String nationality = null;
	private String degree = null;
	private String phone = null;
	private String familyPhone = null;
	private String schoolPhone = null;
	private String totalCourseMark = null;
	private String rank = null;
	private static final long serialVersionUID = 5591240309030087227L;

	public ArrayList<Course> arr_course = new ArrayList<Course>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTotalCourseMark() {
		return totalCourseMark;
	}

	public void setTotalCourseMark(String totalCourseMark) {
		this.totalCourseMark = totalCourseMark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Student() {
		super();
	}
	
	public Student(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Student(String id, String password, String name, String age,
			String sex) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public ArrayList<Course> getArr_course() {
		return arr_course;
	}

	public void setArr_course(ArrayList<Course> arr_course) {
		this.arr_course = arr_course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", password=" + password + ", name="
				+ name + ", age=" + age + ", sex=" + sex + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
