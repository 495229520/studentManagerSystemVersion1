package com.io;

import com.file.DB;
import com.item.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 包名:com.io
 *
 * @author hwf
 * 日期2022-11-2022/11/10   18:45
 */
public class IOStreamTeacher {
	public static File file = new File("../tea.txt");

	public static void writeToFile() {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(DB.arrTea);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.flush();
				objectOutputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Write Teacher to File" + " " + file);
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public static ArrayList<Teacher> readFromFile(){
		ArrayList<Teacher> arrayList = null;
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		try{
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			arrayList = (ArrayList<Teacher>) objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return arrayList;
	}
	
}

