package com.covidstats.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionWithDatabase {

	static Connection connection;
	static Properties properties;

	public static Connection establishConnection() {

		try {
			Properties properties = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\EngineeringCamp\\CovidStatistics\\src\\main\\java\\com\\covidstats\\resources\\configuration.properties");
			properties.load(ip);
			String driverClass = properties.getProperty("driverClass");
			String connectionUrl = properties.getProperty("connectionUrl");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionUrl, userName, password);
			// connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;

	}

	public static Properties getSQLProperties() {
		try {

			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\EngineeringCamp\\CovidStatistics\\src\\main\\java\\com\\covidstats\\resources\\SqlQuery.properties");
			properties.load(ip);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return properties;
	}

}
