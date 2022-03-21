package com.firstAssignment.Assignments;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		HSSFWorkbook excelFile = new HSSFWorkbook(Test.class.getClassLoader().getResourceAsStream("insurance_estimate.xls"));
		HSSFSheet sheet = excelFile.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		excelFile.close();
	}
}
