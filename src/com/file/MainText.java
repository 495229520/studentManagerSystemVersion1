package com.file;

import com.io.IOStreamStudent;
import com.item.Student;
import com.item.tool;
import com.view.CourseManage;
import com.view.Login;
import org.testng.annotations.Test;

import java.util.ArrayList;


/*
 * 只有一个系统管理员，用来添加学生，教师和教务人员帐号，帐号id为111，密码为111
 */
public class MainText {
	public static void main(String[] args) {
		new Login();
	}

	@Test
	public static void testCalculateTheOverallGrade(){
		CourseManage.allSubjectRank(new Student());
	}

}
//		ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
//		Iterator<Student> iterator = arrayList.iterator();
//
////		student.arr_course.size()
//		int allStudentSubjectNum = arrayList.size()*3;
//		int [] courseMark = new int[allStudentSubjectNum];
//		int [] rank = new int[allStudentSubjectNum];
//
//		String [] courseName = new String[allStudentSubjectNum];
//		String [] studentName = new String[allStudentSubjectNum];
//
//		int i = 0;
//		int courseNum = 0;
//		Student newStu = new Student();
//
//		while (iterator.hasNext()) {
//			newStu = iterator.next();
//			courseNum = newStu.arr_course.size();
//
//			for (int i1 = 0; i1 < newStu.arr_course.size(); i1++) {
//				studentName[i] = newStu.getName();
//				courseMark[i] = Integer.parseInt(newStu.arr_course.get(i1).getCourseMark());
//				courseName[i] = newStu.arr_course.get(i1).getCourseName();
//				i++;
//			}
//		}
//
//		for (int i1 = 0; i1 < allStudentSubjectNum; i1++) {
//			System.out.println("Name:" + studentName[i1] + "  Course:" + courseName[i1] + "  Score:" + courseMark[i1] + " rank:" + rank[i1]);
//		}
//
//		System.out.println("================");
//
//		int studentNum = arrayList.size();
//		int [] tempCourseMark = new int[studentNum];
//		int temp;
//
//		System.out.println(studentNum);
//
//		//根据学科的数量进行排位
//		//student.getArr_course().size()
//		int k1;
//		for (int j = 0; j < courseNum; j++) {
//			k1 = j;
//
//			for (int i1 = 0; i1 < studentNum; i1++) {
//				tempCourseMark[i1] = courseMark[k1];
//				k1 += courseNum;
//			}
//
//			//tempCourseMark 为排序好的成绩
//			for (int k = 0; k < tempCourseMark.length - 1; k++) {
//				for (int l = 0; l < tempCourseMark.length - 1 - k; l++) {
//					if (tempCourseMark[l] < tempCourseMark[l+1]){
//						temp = tempCourseMark[l+1];
//						tempCourseMark[l+1] = tempCourseMark[l];
//						tempCourseMark[l] = temp;
//					}
//				}
//			}
//
//			//循环遍历courseMark，当tempCourseMark和courseMark相同时把 tempCourseMark的下标赋给rank
//			for (int i2 = 0; i2 < courseMark.length; i2++) {
//				for (int i3 = 0; i3 < tempCourseMark.length; i3++) {
//					if (tempCourseMark[i3] == courseMark[i2]) {
//						rank[i2] = i3+1;
//					}
//				}
//			}
//		}
//
//		for (int i1 = 0; i1 < studentName.length; i1++) {
//			System.out.println("Name:" + studentName[i1] + "  Course:" + courseName[i1] + "  Score:" + courseMark[i1] + " rank:" + rank[i1]);
//		}