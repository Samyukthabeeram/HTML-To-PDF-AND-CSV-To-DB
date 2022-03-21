package sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CSV {
public static void main(String[] args) throws IOException {
	File file= new File("insurance_estimate.xls");
	FileInputStream fileIp= new FileInputStream(file);
	HSSFWorkbook workbook = new HSSFWorkbook(fileIp);
	HSSFSheet sheet= workbook.getSheetAt(0);
	System.out.println(sheet);
}
}

