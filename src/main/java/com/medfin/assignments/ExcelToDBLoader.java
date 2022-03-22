package com.medfin.assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelToDBLoader {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter path");
		String source = scanner.nextLine();
		scanner.close();
		if (source == null || source.trim().isEmpty()) {
			System.out.println("Source path cannot be null or empty");
			return;
		}
		File file = new File(source);
		if (!file.exists()) {
			System.out.println("invalid source path entered");
			return;
		}
		FileInputStream fileIp = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIp);
		HSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIt = row.cellIterator();
			while (cellIt.hasNext()) {
				Cell cell = cellIt.next();
				System.out.print(cell.toString());
			}
			System.out.println();
		}
		workbook.close();
		fileIp.close();
	}
}
