package com.item;

import com.io.IOStreamStudent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 包名:com.item
 *
 * @author hwf
 * 日期2022-11-2022/11/11   12:24
 */
public class tool {

    //判断文本输入框是否为男或女
    public static String judgeMaleOrFemale(String text){
        if (text.equals("男")){
            return "man";
        }else if (text.equals("女")) {
            return "women";
        }else {
            return "fales";
        }
    }

    //计算总成绩
//    public static void calculateTheOverallGrade(Student student){
//        int courseNum = student.getArr_course().size();
//        int totalCourseMark = 0;
//        int [] courseMark = new int[courseNum];
//        for (int i = 0; i < courseNum; i++) {
//            courseMark[i] = Integer.parseInt(student.getArr_course().get(i).getCourseMark());
//            totalCourseMark += courseMark[i];
//        }
//        student.setTotalCourseMark(totalCourseMark+"");
//        }

//    //计算总成绩的排名
//    public static void OverallGradeRank(Student student){
//        ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
//        Iterator<Student> iterator = arrayList.iterator();
//        Student newStu = new Student();
//
//        while (iterator.hasNext()){
//            newStu = iterator.next();
//            calculateTheOverallGrade(newStu);
//        }
//
//        int studentNum = arrayList.size();
//        int temp;
//        //array数组存储的
//        int [] array = new int[studentNum];
//
//        for (int i = 0; i < studentNum; i++) {
//            array[i] = Integer.parseInt(arrayList.get(i).getTotalCourseMark());
//        }
//
//        for (int i = 0; i < studentNum - 1; i++) {
//            for(int j = 0; j < studentNum - 1 - i; j++){
//                if (array[j] < array[j+1]){
//                    temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
//            }
//        }
//    }


        }
