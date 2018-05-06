package com.qiushui.joyotimes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class ConverFileMain {

	public static void main(String[] args) {
		String source="D:/joyotimes.zip";
		String target="D:/joyotimes.jpg";
		fileToImage(source, target);
		imageToFile(target,source);
	}
	public static void fileToImage(String source,String target) {
		try {
			FileInputStream fis=new FileInputStream(source);
			FileOutputStream fos=new FileOutputStream(target);
			int b=0;
			while((b=fis.read())>=0) {
				fos.write(b+1);
			}
			fis.close();
			fos.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void imageToFile(String source,String target) {
		try {
			FileInputStream fis=new FileInputStream(source);
			FileOutputStream fos=new FileOutputStream(target);
			int b=0;
			while((b=fis.read())>=0) {
				fos.write(b-1);
			}
			fis.close();
			fos.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
