package com.view;

import com.io.IOStreamManage;
import com.io.IOStreamStudent;
import com.io.IOStreamTeacher;
import com.item.Manage;
import com.item.Student;
import com.item.Teacher;
import com.item.tool;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

	public class Login extends JFrame{
		static String administrationId = "111";
		static String administrationPassword = "111";
//		String zhiwu;
		JFrame jf;
		JLabel jl_id,jl_password,jl3;
		public static JTextField jt_id,jt_password;
		JPanel jp1,jp2,jp3,jp4,jp_group,jp_img;
		JButton jb_login;
		JRadioButton radioButton_student,radioButton_teacher,radioButton_manage,radioButton_administration;
		ButtonGroup group;
		ImageIcon img = null;
		public Login(){
			jf = new JFrame();
			//���ô��ڵĴ�С
			jf.setSize(500,700);
			//���ô��ڵ���λ��
			jf.setLocation(500,100);
			//�رմ��ں��˳�����
			jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//����GridLayout���֣�6��2��
			jf.setLayout(new GridLayout(6,2));
			
			Icon img = new ImageIcon("tu1.gif");
			jp_img = new JPanel();
			jp_img.add(new JLabel(img));			
			
			jl_id = new JLabel("�û���");
			jt_id = new JTextField(15);
			jp1  =new JPanel();
			jp1.add(jl_id);
			jp1.add(jt_id);
			jl_password = new JLabel("����");
			jt_password = new JTextField(15);
			jp2 = new JPanel();
			jp2.add(jl_password);
			jp2.add(jt_password);
			jl3 = new JLabel("ѧ������ϵͳ");
			jp3 = new JPanel();
			jp3.add(jl3);
			
			jp_group = new JPanel();
			radioButton_student = new JRadioButton("ѧ��");
			jp_group.add(radioButton_student);
			radioButton_teacher = new JRadioButton("��ʦ");
			jp_group.add(radioButton_teacher);
			radioButton_manage = new JRadioButton("����");
			jp_group.add(radioButton_manage);
			radioButton_administration = new JRadioButton("����Ա");
			jp_group.add(radioButton_administration);
			group = new ButtonGroup();
			group.add(radioButton_student);
			group.add(radioButton_teacher);
			group.add(radioButton_manage);
			group.add(radioButton_administration);
			
			jb_login = new JButton("��¼");
			jp4 = new JPanel();
			jp4.add(jb_login);
			
			jf.add(jp_img);
			jf.add(jp3);
			jf.add(jp1);
			jf.add(jp2);
			jf.add(jp_group);
			jf.add(jp4);
			//������ͼ
			jf.setVisible(true);

			//��¼��ť����
			jb_login.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				boolean flow = true;
				//����ѧ���ĵ�¼�˺ź�����
				if (radioButton_student.isSelected()) {
					if (IOStreamStudent.file.length() == 0) {
						JOptionPane.showMessageDialog(null, "�û���������", "��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					} else {
						ArrayList<Student> arrayList = IOStreamStudent.readFromFile();
						Iterator<Student> iterator = arrayList.iterator();
						while (iterator.hasNext()) {
							Student student = iterator.next();
							//�ȼ����ļ����Ƿ���userId
							if (student.getId().equals(jt_id.getText())) {
								//��userId�Ļ��ٿ�����Բ���
								if (student.getPassword().equals(jt_password.getText())) {
									CourseManage.calculateTheOverallGrade(student);
									CourseManage.overallGradeRank(student);
									new StudentLogin(student);
								} else {
									JOptionPane.showMessageDialog(null,"������û�������");									
								}
								flow = false;
							} 
						}if(flow){
							JOptionPane.showMessageDialog(null, "�û���������");
						}
					}
				}
				
				//������ʦ�ĵ�¼�˺ź�����
				if (radioButton_teacher.isSelected()) {
					if (IOStreamTeacher.file.length() == 0) {
						JOptionPane.showMessageDialog(null, "�û���������", "��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					} else {
						ArrayList<Teacher> arrayList = IOStreamTeacher.readFromFile();
						Iterator<Teacher> iterator = arrayList.iterator();
						while (iterator.hasNext()) {
							Teacher teacher = iterator.next();
							if (teacher.getId().equals(jt_id.getText())) {
								if (teacher.getPassword().equals(jt_password.getText())) {
									new TeacherLogin(teacher);
								} else {
									JOptionPane.showMessageDialog(null,"������û�������");
								}
								flow = false;
							}
						}
						if (flow) {
							JOptionPane.showMessageDialog(null, "�û���������");
						}
					}
				}

				//���������Ա�ĵ�¼�˺ŵ�����
				if (radioButton_manage.isSelected()) {
					if(IOStreamManage.file.length() == 0){
						JOptionPane.showMessageDialog(null, "�û���������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					}else{						
						ArrayList<Manage> arrayList = IOStreamManage.readFromFile();
						Iterator<Manage> iterator = arrayList.iterator();
						while (iterator.hasNext()) {
							Manage newman = iterator.next();
							if (newman.getId().equals(jt_id.getText())) {
								if (newman.getPassword().equals(jt_password.getText())) {
									new ManageLogin(newman);										
								} else {
									JOptionPane.showMessageDialog(null, "������û�������");
								}
								flow = false;
							}
						}if(flow){
							JOptionPane.showMessageDialog(null, "�û���������");
						}
					}
				}

				//���鳬������Ա�ĵ�¼�˺ŵ�����
				if (radioButton_administration.isSelected()) {
					if (administrationId.equals(jt_id.getText())) {
						if (administrationPassword.equals(jt_password.getText())) {
							new Register();
						} else {
							JOptionPane.showMessageDialog(null, "�������");
						}
					} else {
						JOptionPane.showMessageDialog(null, "�����µ�¼");
					}

				}
			}
		});
		}
		//ѧ����ѯ����Ԫ���±�
		public static int searchStudent(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamStudent.file.length() == 0){
				return index;
			}else{
				ArrayList<Student> arr  = IOStreamStudent.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
		//��ʦ��ѯ����Ԫ���±�
		public static int searchTeacher(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamTeacher.file.length() == 0){
				return index;
			}else{
				ArrayList<Teacher> arr  = IOStreamTeacher.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
		//����Ա��ѯ�����±�
		public static int searchManage(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamManage.file.length() == 0){
				return index;
			}else{
				ArrayList<Manage> arr  = IOStreamManage.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
}
