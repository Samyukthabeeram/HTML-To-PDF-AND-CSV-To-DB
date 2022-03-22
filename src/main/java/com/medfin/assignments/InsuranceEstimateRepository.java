package com.medfin.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsuranceEstimateRepository {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		InputStream inputStream = InsuranceEstimateRepository.class.getClassLoader().getResourceAsStream("./insurance_estimate.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		connection.setAutoCommit(false);
		
		PreparedStatement statement = connection.prepareStatement("insert into medfin.insurance_estimate (corporate_name, patient_name, patient_mobile) values (?, ?, ?)");
		
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			
			String[] insuranceEstimateDetail = line.split(",");
			statement.setString(1, insuranceEstimateDetail[0]);
			statement.setString(2, insuranceEstimateDetail[1]);
			statement.setString(3, insuranceEstimateDetail[2]);
			statement.execute();
		}
		connection.commit();
		connection.close();
	}
}
