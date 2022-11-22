package com.io;

import com.file.DB;
import com.item.Manage;

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
 * 日期2022-11-2022/11/10   17:33
 */
public class IOStreamManage {
	public static File file = new File("../manage.txt");

	public static void writeToFile() {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(DB.arrMan);
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
		System.out.println("Write Manage to File" + " " + file);
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public static ArrayList<Manage> readFromFile(){
		ArrayList<Manage> arrayList = null;
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		try{
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);
			arrayList = (ArrayList<Manage>) objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return arrayList;
	}
	
}
