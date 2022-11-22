package com.view;

import com.file.DB;
import com.io.IOStreamStudent;
import com.item.Student;
import com.item.tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class StudentLogin {
	
	JFrame jf;
	JLabel jl_name, jl_age, jl_sex, jl_address, jl_birthday,
			jl_ethnic, jl_nationality, jl_rank,
			jl_degree, jl_phone, jl_familyPhone, jl_allCourseMark,
			jl_schoolPhone, jl_ReviseOK,jl_old_password,
			jl_new_password1,jl_new_password2,jl_inpassword_err;
	JTextField jt_name, jt_age, jt_sex, jt_address, jt_birthday, jt_ethnic, jt_nationality,
			jt_degree, jt_phone, jt_familyPhone, jt_schoolPhone, jt_rank, jt_allCourseMark;
	JPasswordField jp_old_password,jpassword1,jpassword2;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10, jp11, jp12, jp13, jp_jb,jp_center;
	JButton jb,jb_revise_password;
	static JTable table;
	JScrollPane scrollPane;
	static DefaultTableModel model;
	 JMenuBar jmb;
	 JMenuItem jmb1find,jmb2find,jmb1revisePassword;
	
	public StudentLogin(final Student stu) {

		jf = new JFrame("欢迎 " + stu.getId() + " 同学，你好！");
		jf.setSize(1000, 700);
		jf.setLocation(800, 100);
		jf.setLayout(new BorderLayout(0,0));
		Icon img = new ImageIcon("tu2.jpg");
		jf.add(new JLabel(img),BorderLayout.NORTH);
		
		jmb = new JMenuBar();
		jf.setJMenuBar(jmb);	
		JMenu jmb1 = new JMenu("个人信息");
		jmb.add(jmb1);
		jmb1find = new JMenuItem("查看个人信息");
		jmb1.add(jmb1find);	
		jmb1revisePassword = new JMenuItem("修改账户密码");
		jmb1.add(jmb1revisePassword);	
		JMenu jmb2 = new JMenu("我的成绩");
		jmb.add(jmb2);
		jmb2find = new JMenuItem("查看所有");
		jmb2.add(jmb2find);
		
		jp_center = new JPanel();//中心的面板
		jf.setVisible(true);

		jmb1find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp_center.removeAll();
				jp_center.setLayout(new GridLayout(7,2));
				jf.add(jp_center,BorderLayout.CENTER);
				
				jl_name = new JLabel("姓名");
				jt_name = new JTextField(20);
				jt_name.setText(stu.getName());
				jp1 = new JPanel();
				jp1.add(jl_name);
				jp1.add(jt_name);

				jl_age = new JLabel("年龄");
				jt_age = new JTextField(20);
				jt_age.setText(stu.getAge());
				jp2 = new JPanel();
				jp2.add(jl_age);
				jp2.add(jt_age);

				jl_sex = new JLabel("性别");
				jt_sex = new JTextField(20);
				jt_sex.setText(stu.getSex());
				jp3 = new JPanel();
				jp3.add(jl_sex);
				jp3.add(jt_sex);

				jl_address = new JLabel("地址");
				jt_address = new JTextField(20);
				jt_address.setText(stu.getAddress());
				jp4 = new JPanel();
				jp4.add(jl_address);
				jp4.add(jt_address);

				jl_birthday = new JLabel("生日");
				jt_birthday = new JTextField(20);
				jt_birthday.setText(stu.getBirthday());
				jp5 = new JPanel();
				jp5.add(jl_birthday);
				jp5.add(jt_birthday);

				jl_ethnic = new JLabel("民族");
				jt_ethnic = new JTextField(20);
				jt_ethnic.setText(stu.getEthnic());
				jp6 = new JPanel();
				jp6.add(jl_ethnic);
				jp6.add(jt_ethnic);

				jl_nationality = new JLabel("国籍");
				jt_nationality = new JTextField(20);
				jt_nationality.setText(stu.getNationality());
				jp7 = new JPanel();
				jp7.add(jl_nationality);
				jp7.add(jt_nationality);

				jl_phone = new JLabel("电话");
				jt_phone = new JTextField(20);
				jt_phone.setText(stu.getPhone());
				jp8 = new JPanel();
				jp8.add(jl_phone);
				jp8.add(jt_phone);

				jl_familyPhone = new JLabel("家庭电话");
				jt_familyPhone = new JTextField(20);
				jt_familyPhone.setText(stu.getFamilyPhone());
				jp9 = new JPanel();
				jp9.add(jl_familyPhone);
				jp9.add(jt_familyPhone);

				jl_schoolPhone = new JLabel("学校电话");
				jt_schoolPhone = new JTextField(20);
				jt_schoolPhone.setText(stu.getSchoolPhone());
				jp10 = new JPanel();
				jp10.add(jl_schoolPhone);
				jp10.add(jt_schoolPhone);

				jl_ReviseOK = new JLabel("修改成功");
				jp11 = new JPanel();
				jb = new JButton("修改信息");
				jp_jb = new JPanel();
				jp_jb.add(jb);

				jp_center.add(jp1);
				jp_center.add(jp2);
				jp_center.add(jp3);
				jp_center.add(jp4);
				jp_center.add(jp5);
				jp_center.add(jp6);
				jp_center.add(jp7);
				jp_center.add(jp8);
				jp_center.add(jp9);
				jp_center.add(jp10);
				jp_center.add(jp11);
				jp_center.add(jp_jb);
				jf.setVisible(true);
				
				jb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						stu.setName(jt_name.getText());
						stu.setAge(jt_age.getText());
						stu.setSex(jt_sex.getText());
						stu.setAddress(jt_address.getText());
						stu.setBirthday(jt_birthday.getText());
						stu.setEthnic(jt_ethnic.getText());
						stu.setNationality(jt_nationality.getText());
						stu.setPhone(jt_phone.getText());
						stu.setFamilyPhone(jt_familyPhone.getText());
						stu.setSchoolPhone(jt_schoolPhone.getText());

						Student newstu = stu;
						DB.arrStu.clear();
						DB.arrStu = IOStreamStudent.readFromFile();
						DB.arrStu.set(Login.searchStudent(), newstu);
						IOStreamStudent.writeToFile();

						jp11.add(jl_ReviseOK);
						jf.setVisible(true);

					}
				});
			}
		});

		jmb1revisePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jp_center.removeAll();
				jp_center.setLayout(new GridLayout(6,2));
				jf.add(jp_center, BorderLayout.CENTER);
				jl_old_password = new JLabel("原密码");
				jp_old_password = new JPasswordField(20);
				jl_new_password1 = new JLabel("新密码");
				jpassword1 = new JPasswordField(20);
				jl_new_password2 = new JLabel("再次输入新密码");
				jpassword2 = new JPasswordField(20);
				jb_revise_password = new JButton("保存");
				jl_inpassword_err = new JLabel("密码输入错误，请重新输入");
				jl_inpassword_err.setForeground(Color.red);
				jl_inpassword_err.setFont(new Font("宋体",Font.ITALIC,16));
				JPanel jp1 = new JPanel();
				JPanel jp2 = new JPanel();
				JPanel jp3 = new JPanel();
				final JPanel jp4 = new JPanel();
				final JPanel jp5 = new JPanel();
				JPanel jp_jb = new JPanel();
				jp1.add(jl_old_password);
				jp1.add(jp_old_password);
				jp_center.add(jp1);
				jp2.add(jl_new_password1);
				jp2.add(jpassword1);
				jp_center.add(jp2);
				jp3.add(jl_new_password2);
				jp3.add(jpassword2);
				jp_center.add(jp3);
				jp_center.add(jp4);
				jp_jb.add(jb_revise_password);
				jp_center.add(jp_jb);
				jp_center.add(jp5);
				jf.setVisible(true);
				
					
				jb_revise_password.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (String.valueOf(jp_old_password.getPassword()).equals(stu.getPassword())
								&& (!(String.valueOf(jpassword2.getPassword())).equals(""))
								&& ((String.valueOf(jpassword1.getPassword())).equals(String.valueOf(jpassword2.getPassword())))) {
							stu.setPassword(String.valueOf(jpassword2.getPassword()));
							Student newstu = stu;
							DB.arrStu.clear();
							DB.arrStu = IOStreamStudent.readFromFile();
							DB.arrStu.set(Login.searchStudent(), newstu);
							IOStreamStudent.writeToFile();
							jp5.removeAll();
							jp5.add(new JLabel("修改密码成功"));
							jf.setVisible(true);
						} else {
							jp4.removeAll();
							jp4.add(jl_inpassword_err);
							jf.setVisible(true);
						}
					}
				});		
			}
		});
		
		jmb2find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManage.calculateTheOverallGrade(stu);
				CourseManage.overallGradeRank(stu);
				CourseManage.allSubjectRank(stu);

				System.out.println("查看所有成绩");
				jp_center.removeAll();
				jp_center.setLayout(new GridLayout());
				scrollPane = new JScrollPane();
				jp_center.add(scrollPane);
				jf.add(jp_center, BorderLayout.CENTER);

				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
				table.setRowHeight(30);
				JTableHeader header = table.getTableHeader(); // 获取 JTable 的头的对象
				header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				header.setPreferredSize(new Dimension(header.getWidth(), 35)); // 设置此组件的首选大小
				scrollPane.setViewportView(table);
				model = (DefaultTableModel) table.getModel();
				model.setColumnIdentifiers(new Object[] { "课程编号", "课程名", "成绩","排名","任课老师" });
				CourseManage.findOneStudentAllCourseMark(stu);

				jp12 = new JPanel();
				jp13 = new JPanel();

				jl_allCourseMark = new JLabel("成绩/排名");
				jl_allCourseMark.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				jt_allCourseMark = new JTextField(12);
				jt_allCourseMark.setText("总成绩:"+stu.getTotalCourseMark()+"/总排名:"+stu.getRank());
				jt_allCourseMark.setEditable(false);
				jt_allCourseMark.setFont(new Font("微软雅黑", Font.PLAIN, 15));
				jp12.add(jl_allCourseMark);
				jp12.add(jt_allCourseMark);

				jp_center.add(jp12);

				jf.setVisible(true);

			}
		});
	}

}
