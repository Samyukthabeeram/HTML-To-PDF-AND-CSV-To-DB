package com.firstAssignment.Assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.html2pdf.HtmlConverter;

public class HtmlTableToPdf {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the source Path");
		String sourcePath = scanner.nextLine();
		System.out.println("Enter the destination path");
		String destinationPath = scanner.nextLine();
		scanner.close();
		if (sourcePath == null || sourcePath.trim().isEmpty()) {
			System.out.println("Source path cannot be null or empty");
			return;
		}
		if (destinationPath == null || destinationPath.trim().isEmpty()) {
			System.out.println("Destination path cannot be null or empty");
			return;
		}
		File sourceFile = new File(sourcePath);
		if (!sourceFile.exists()) {
			System.out.println("Invalid Source path entered.");
			return;
		}
		File destinationFile = new File(destinationPath);
		if (!destinationFile.exists()) {
			System.out.println("Invalid destination path entered.");
			return;
		}
		if (!sourceFile.canRead()) {
			System.out.println("User does not have read permission on the provided source path");
			return;
		}

		if (!destinationFile.canWrite()) {
			System.out.println("User does not have write permission on the provided destination path");
			return;
		}
		HtmlConverter.convertToPdf(sourceFile, destinationFile);

	}
}
