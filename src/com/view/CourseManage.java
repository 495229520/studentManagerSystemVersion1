package com.view;

import com.file.DB;
import com.io.IOStreamStudent;
import com.io.IOStreamTeacher;
import com.item.Course;
import com.item.Student;
import com.item.Teacher;

import java.awt.GridLayout;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CourseManage {
	static JFrame jf ;
	static JPanel jp ;
	static JLabel jl ;
	static JButton jb ;
	static JTextField jt_name,jt_id,jt_pass;

	//ͳ������ѧ�Ƶĳɼ��ܺ�
	public static void calculateTheOverallGrade(Student student){
		int courseNum = student.getArr_course().size();
		int totalCourseMark = 0;
		int [] courseMark = new int[courseNum];
		for (int i = 0; i < courseNum; i++) {
			courseMark[i] = Integer.parseInt(student.arr_course.get(i).getCourseMark());
			totalCourseMark += courseMark[i];
		}
		student.setTotalCourseMark(totalCourseMark+"");
	}

	//ͳ��һ��ѧ���ĸ��Ƴɼ�����
	public static void allSubjectRank(Student student){
		ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
		Iterator<Student> iterator = arrayList.iterator();
		Student newStu = new Student();

		int courseNum = student.arr_course.size();
		int studentNum = arrayList.size();

		String [] courseName = new String[courseNum];
		//�����������еĿ�Ŀ����
		for (int i = 0; i < courseName.length; i++) {
			courseName[i] = student.arr_course.get(i).getCourseName();
		}

		//¼������ѧ�����ܳɼ�
		Student [] stuArray = new Student[arrayList.size()];
		int i = 0;
		while (iterator.hasNext()) {
			stuArray[i] = iterator.next();
			i++;
		}

		//����ѧ�Ʊ���
		for (int i1 = 0; i1 < courseName.length; i1++) {
			//һ��ѧ���д���һ�����飬�����ڴ�ŵ���ĳһ����Ŀ�����гɼ�
			int[] course = new int[studentNum];
			//�������е�ͬѧ��������ͬѧ�ĵ�һѧ�ƴ�Ž�course��
			for (int i2 = 0; i2 < stuArray.length; i2++) {
				//һ��ͬѧ�����ĸ��Ƴɼ�����������
				for (int i3 = 0; i3 < courseNum; i3++) {
					//����������courseName��ͬ�Ŀ�Ŀʱ���ͰѸÿ�Ŀ�ķ����Ž�course������
					if (stuArray[i2].arr_course.get(i3).getCourseName().equals(courseName[i1])) {
						course[i2] = Integer.parseInt(stuArray[i2].arr_course.get(i3).getCourseMark());
						break;
					}
				}
			}

			//��ʱ����ͬѧ�ĵ�һ��Ŀ���Ѿ�������course�����У���ʱ�Ϳ��Խ�������
			int temp;
			for (int j = 0; j < course.length - 1; j++) {
				for (int k = 0; k < course.length - 1 - j; k++) {
					if (course[k] < course[k + 1]) {
						temp = course[k];
						course[k] = course[k + 1];
						course[k + 1] = temp;
					}
				}
			}

			//�������е�ͬѧ��������course���±긳����ͬѧ�ĸÿ�Ŀ
			for (int i2 = 0; i2 < stuArray.length; i2++) {
				//һ��ͬѧ�����ĸ��Ƴɼ�����������
				for (int i3 = 0; i3 < courseNum; i3++) {
					//����������courseName��ͬ�Ŀ�Ŀʱ���Ͳ鿴��ͬѧ�ĸÿƳɼ���֮ǰ����course���Ƿ�ƥ��
					if (stuArray[i2].arr_course.get(i3).getCourseName().equals(courseName[i1])) {
						//ѭ��course�鿴�Ƿ�ƥ��
						for (int i4 = 0; i4 < course.length; i4++) {
							if (stuArray[i2].arr_course.get(i3).getCourseMark().equals(course[i4]+"")) {
								stuArray[i2].arr_course.get(i3).setRank(i4+1+"");
								break;
							}
						}
					}
				}
			}
		}

		for (int i2 = 0; i2 < stuArray.length; i2++) {
			for (int i3 = 0; i3 < stuArray[i2].arr_course.size(); i3++) {
				System.out.println(stuArray[i2].getName()+"ͬѧ"+stuArray[i2].arr_course.get(i3).courseName+"��Ŀ�ķ���Ϊ��"+
						stuArray[i2].arr_course.get(i3).getCourseMark()+"�ÿ�Ŀ��������"+stuArray[i2].arr_course.get(i3).getRank());
			}
		}

		for (int i1 = 0; i1 < stuArray.length; i1++) {
			if (student.getId().equals(stuArray[i1].getId())){
				for (int i2 = 0; i2 < student.arr_course.size(); i2++) {
					student.arr_course.get(i2).setRank(stuArray[i1].arr_course.get(i2).getRank());
				}
				break;
			}
		}

		for (int i1 = 0; i1 < student.arr_course.size(); i1++) {
			System.out.println(student.arr_course.get(i1).getRank()+"==="+student.getName());
		}

	}


	//�����ܳɼ�������
	public static void overallGradeRank(Student student){
		ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
		Iterator<Student> iterator = arrayList.iterator();
		Student newStu = new Student();

		//¼������ѧ�����ܳɼ�
		while (iterator.hasNext()) {
			newStu = iterator.next();
			calculateTheOverallGrade(newStu);
		}

		int studentNum = arrayList.size();
		int [] array = new int[studentNum];
		int temp;

		//��ȡ����ѧ�����ܳɼ�
		for (int i = 0; i < studentNum; i++) {
			array[i] = Integer.parseInt(arrayList.get(i).getTotalCourseMark());
		}

		//�Ը���ѧ�����ܳɼ���������
		for (int i = 0; i < studentNum - 1; i++) {
			for(int j = 0; j < studentNum - 1 - i; j++){
				if (array[j] < array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (student.getTotalCourseMark().equals(array[i]+"")) {
				student.setRank(i+1+"");
				break;
			}
		}
	}

	//��ʦ��������ѧ�����Ƴɼ�findAllStudentCourseMark
	public static void allStudentOneCourse_mark(Teacher tea) {
		ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
		Iterator<Student> iterator = arrayList.iterator();
		String courseMark = null;// ���ҵĿγ�
		String rank = null;

		while (iterator.hasNext()) {
			Student stu = iterator.next();
			String id = stu.getId();
			String name = stu.getName();
			//������ʦ����ѧ�ƣ��鿴ѧ���ĸ�ѧ�Ƴɼ�
			for(int i = 0;i<stu.arr_course.size();i++){
				if (tea.getTeaching_course().getCourseName()
						.equals(stu.arr_course.get(i).getCourseName())) {
					courseMark = stu.arr_course.get(i).getCourseMark();
					rank = stu.arr_course.get(i).getRank();
					break;
				}
			}		
			TeacherLogin.model.addRow(new Object[] { id, name, courseMark, rank});
			TeacherLogin.table.setModel(TeacherLogin.model);
		}
	}

	//��ʦ�޸�ѧ�����Ƴɼ�reviseCourseMark
	public static void teacherReviseCourse_mark(Teacher tea) {
		if (tea.getTeaching_course().courseName == null
				|| tea.getTeaching_course().courseName.equals("null")) {
			JOptionPane.showMessageDialog(null, "�����ý�����ԱΪ�������Ŀ", "",
					JOptionPane.WARNING_MESSAGE);
		} else {
			int index = 0;
			String student_course_mark = null;
			Course newcourse = null;
			index = TeacherLogin.table.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĳɼ���ѧ��", "",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String id = (String) TeacherLogin.table.getValueAt(index, 0);
				DB.arrStu.clear();
				DB.arrStu = IOStreamStudent.readFromFile();
				student_course_mark = JOptionPane.showInputDialog("�ɼ�=", 0);
				//ѧ��������
				for (int i = 0; i < DB.arrStu.size(); i++) {

					//ȷ�����Ǹ�ѧ�����в���
					if (id.equals(DB.arrStu.get(i).getId())) {

						if (DB.arrStu.get(i).arr_course.size() == 0) { 		 //�ɼ�����Ϊ�գ���ӵ�һ������
							newcourse = new Course(tea.getTeaching_course()
									.getCourseId(), tea.getTeaching_course()
									.getCourseName(), student_course_mark);
							DB.arrStu.get(i).arr_course.add(newcourse);
						} else {

//							DB.arrStu.get(i).arr_course.size()
							boolean change = false;
							for (int j = 0; j < DB.arrStu.get(i).arr_course.size(); j++) { 			//������ϲ�Ϊ��������޸�
								//ǰ����������γ̵�ʱ�����ѭ����student�Ŀγ����ֺ�tea���̵Ŀγ���ͬʱ������
								//����ǰ����������γ̣����û������γ���ô���޷���������ֱ�Ӽ���else��ô���ܻᵼ�·���������Ҫ�ټ�һ���ж�
								if (DB.arrStu.get(i).arr_course.get(j).getCourseName()
										.equals(tea.getTeaching_course().getCourseName())) {
									newcourse = new Course(
											tea.getTeaching_course()
													.getCourseId(), tea
													.getTeaching_course()
													.getCourseName(),
											student_course_mark);
									DB.arrStu.get(i).arr_course.set(j,newcourse);
									change = true;
									break;
								}
							}

							if (change == false) {
								newcourse = new Course(
										tea.getTeaching_course()
												.getCourseId(), tea
										.getTeaching_course()
										.getCourseName(),
										student_course_mark);
								DB.arrStu.get(i).arr_course.add(DB.arrStu.get(i).arr_course.size(),newcourse);
							}

						}


						IOStreamStudent.writeToFile();

						TeacherLogin.model.removeRow(TeacherLogin.table.getSelectedRow());
						TeacherLogin.model.insertRow(index,new Object[] { DB.arrStu.get(i).getId(),DB.arrStu.get(i).getName(),student_course_mark });
						TeacherLogin.table.setModel(TeacherLogin.model);
						break;
					}
				}
			}
		}
	}
	
	
	//һ��ѧ�������гɼ�
	public static void findOneStudentAllCourseMark(Student stu) {
		System.out.println(stu.getName());
		allSubjectRank(stu);

		ArrayList<Student> arrStu = IOStreamStudent.readFromFile();
		Iterator<Student> it = arrStu.iterator();	
		String teacher_name  = null;
		if(stu.arr_course == null) {
			JOptionPane.showMessageDialog(null, "�޳ɼ�����ȴ���ʦ����", "",JOptionPane.WARNING_MESSAGE);
		} else {
			ArrayList<Teacher> arrTea = IOStreamTeacher.readFromFile();
			while(it.hasNext()) {
			Student newstu = it.next();
			if(newstu.getId().equals(stu.getId())) {
				for(int i = 0;i<newstu.arr_course.size();i++) {	
					String course_id = newstu.arr_course.get(i).getCourseId();
					String course_name = newstu.arr_course.get(i).getCourseName();
					String course_mark = newstu.arr_course.get(i).getCourseMark();
					String course_rank = stu.arr_course.get(i).getRank();
					for(int j = 0;j<arrTea.size();j++) {
						if(course_name.equals(arrTea.get(j).getTeaching_course().getCourseName())) {
							teacher_name = arrTea.get(j).getName();
							StudentLogin.model.addRow(new Object[] {course_id,course_name,course_mark,course_rank,teacher_name});
							StudentLogin.table.setModel(StudentLogin.model); 
						}
					}					
				}				
				break;
			}			
			}		
		}
		
	} 
	
	//�鿴����ѧ����Ϣ
	public static void findAllStudentMessage(){
		ArrayList<Student> arr = IOStreamStudent.readFromFile();
		Iterator<Student> it = arr.iterator();//next()����������ѭ����ʹ��2��
		while(it.hasNext()){	
			
			Student stu = it.next();
			String id = stu.getId();
			String name = stu.getName();
			String sex = stu.getSex();
			String age = stu.getAge();	
			ManageLogin.model.addRow(new Object[] {id,name,sex,age});
			ManageLogin.table.setModel(ManageLogin.model); 
		}	
		
	}
	//�޸�ѧ����Ϣ
	public static void jmb1reviseStudentMessage(){
		jf = new JFrame("�޸�ѧ����Ϣ");
		jf.setLocation(1000, 200);
		jf.setSize(400, 300);
		jf.setLayout(new GridLayout(4, 1));
		jp = new JPanel();
		jl = new JLabel("����Ҫ�޸ĵ��û�����");
		jt_id = new JTextField(15);
		jp.add(jl);
		jp.add(jt_id);
		jf.add(jp);
		jl = new JLabel("�û����룺");
		jt_pass = new JTextField(15);
		jp = new JPanel();
		jp.add(jl);
		jp.add(jt_pass);
		jf.add(jp);
		jb = new JButton("ȷ���޸�");
		jp = new JPanel();
		jp.add(jb);
		jf.add(jp);
		jf.setVisible(true);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();	
				DB.arrStu.clear();
				DB.arrStu = IOStreamStudent.readFromFile();
				for(int i = 0;i<DB.arrStu.size();i++){
					if(DB.arrStu.get(i).getId().equals(jt_id.getText())){
						DB.arrStu.get(i).setId(jt_id.getText());
						DB.arrStu.get(i).setPassword(jt_pass.getText());						
						IOStreamStudent.writeToFile();					
					}
				}
			}
		});
	} 
	//ɾ��ѧ���˻�
	public static void deleteStudent(){
		String id = JOptionPane.showInputDialog("Ҫɾ�����û���", 0);
		DB.arrStu.clear();
		DB.arrStu = IOStreamStudent.readFromFile();
		for(int i = 0;i<DB.arrStu.size();i++){
			if(DB.arrStu.get(i).getId().equals(id)){
				DB.arrStu.remove(i);
				IOStreamStudent.writeToFile();					
			}
		}
	}
	//ɾ����ʦ�˻�
		public static void deleteTeacher(){
			String id = JOptionPane.showInputDialog("Ҫɾ�����û���", 0);
			DB.arrTea.clear();
			DB.arrTea = IOStreamTeacher.readFromFile();
			for(int i = 0;i<DB.arrTea.size();i++){
				if(DB.arrTea.get(i).getId().equals(id)){
					DB.arrTea.remove(i);				
					IOStreamTeacher.writeToFile();					
				}
			}
		}

	//�鿴������ʦ��Ϣ
	@SuppressWarnings("unused")
	public static void findAllTeacherMessage() {
		if (IOStreamTeacher.file.length() == 0) {
			ManageLogin.model.addRow(new Object[] { "��" });
			ManageLogin.table.setModel(ManageLogin.model);
		} else {
			ArrayList<Teacher> arr = IOStreamTeacher.readFromFile();
			Iterator<Teacher> it = arr.iterator();

			while (it.hasNext()) {

				Teacher tea = it.next();
				String id = tea.getId();
				String name = tea.getName();
				String sex = tea.getSex();
				String age = tea.getAge();
				if (tea.getTeaching_course() == null) {
					ManageLogin.model.addRow(new Object[] { id, name, sex, age,
							"��","��" });
					ManageLogin.table.setModel(ManageLogin.model);
				} else {
					String teaching_course_id = tea.getTeaching_course()
							.getCourseId();
					String teaching_course_name = tea.getTeaching_course().getCourseName();
					ManageLogin.model.addRow(new Object[] { id, name, sex, age,
							teaching_course_id, teaching_course_name });
					ManageLogin.table.setModel(ManageLogin.model);
				}
			}
		}

	}
	
	//�����޸���ʦ��Ϣ
	//��1�������޸���ʦ��Ϣ�ж�����
	public static void teacherReviseJudge() {
		int index = 0;
		index = ManageLogin.table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ���ʦ", "",
					JOptionPane.WARNING_MESSAGE);
		} else {
			CourseManage.teacherReviseFrame(index);
		}
	}
	//��2�������޸���ʦ��Ϣ���
	public static void teacherReviseFrame(final int index) {
		jf = new JFrame("�޸���ʦ��Ϣ");
		jf.setLocation(1000, 200);
		jf.setSize(300, 400);
		jf.setLayout(new GridLayout(4, 1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		jl = new JLabel("�޸��û����룺");
		jt_pass = new JTextField(15);
		jp1.add(jl);
		jp1.add(jt_pass);
		jf.add(jp1);
		jl = new JLabel("���ſγ̱��");
		jt_id = new JTextField(15);
		jp2.add(jl);
		jp2.add(jt_id);
		jf.add(jp2);
		jl = new JLabel("�γ�����");
		jt_name = new JTextField(15);
		jp3.add(jl);
		jp3.add(jt_name);
		jf.add(jp3);
		jb = new JButton("ȷ���޸�");
		jp4.add(jb);
		jf.add(jp4);
		jf.setVisible(true);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				CourseManage.teacherRevise(index);
			}
		});
	}
	//��3�������޸���ʦ��Ϣ
	public static void teacherRevise(int index) {
		String teacher_course_id = null;
		String teacher_course_name = null;
		
		String id = (String) ManageLogin.table.getValueAt(index, 0);
		DB.arrTea.clear();
		DB.arrTea = IOStreamTeacher.readFromFile();
		teacher_course_id = jt_id.getText();
		teacher_course_name = jt_name.getText();
		for (int i = 0; i < DB.arrTea.size(); i++) {
			if (id.equals(DB.arrTea.get(i).getId())) {
				if(!(jt_pass.getText().equals(""))){
					DB.arrTea.get(i).setPassword(jt_pass.getText());
				}			
				DB.arrTea.get(i).getTeaching_course()
						.setCourseName(teacher_course_name);
				DB.arrTea.get(i).getTeaching_course()
						.setCourseId(teacher_course_id);
				IOStreamTeacher.writeToFile();
				ManageLogin.model.removeRow(index);
				ManageLogin.model.insertRow(index, new Object[] {
						DB.arrTea.get(i).getId(), DB.arrTea.get(i).getName(),
						DB.arrTea.get(i).getAge(), DB.arrTea.get(i).getSex(),
						teacher_course_id, teacher_course_name });
				ManageLogin.table.setModel(ManageLogin.model);
				break;
			}
		}
	}
	
		
}