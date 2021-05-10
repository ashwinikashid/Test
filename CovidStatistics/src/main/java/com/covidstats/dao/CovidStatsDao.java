package com.covidstats.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

import com.covidstats.connection.ConnectionWithDatabase;
import com.covidstats.model.CovidStats;
import com.covidstats.util.ConnectionUtil;

public class CovidStatsDao {

	public static void insertStats(ArrayList<CovidStats> covidStatsList) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionWithDatabase.establishConnection();
		Properties properties = ConnectionWithDatabase.getSQLProperties();
		CallableStatement statement=null;
		try {
			Iterator<CovidStats> iterate = covidStatsList.iterator();
			while (iterate.hasNext()) {
				CovidStats covidStats = iterate.next();
				statement = connection.prepareCall("{call insert_covid_stats(?,?,?,?,?,?)}");
				statement.setString(1, covidStats.getState());
				statement.setString(2, covidStats.getCity());
				statement.setInt(3, covidStats.getNoOfTestingDone());
				statement.setInt(4, covidStats.getNoOfCovidInfectedPatients());
				statement.setInt(5, covidStats.getNoOfPatientsRecovered());
				statement.setString(6, covidStats.getDate());

				statement.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeResorses(statement);
			ConnectionUtil.closeResorses(connection);
		}

	}

	public static TreeSet<CovidStats> getStateWiseReport() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionWithDatabase.establishConnection();
		Statement selectStmt = null;
		ResultSet resultSet = null;
		Properties properties = ConnectionWithDatabase.getSQLProperties();
		TreeSet<CovidStats> covidStatsList = new TreeSet<CovidStats>();
		try {
			selectStmt = connection.createStatement();
			resultSet = selectStmt.executeQuery(properties.getProperty("selectQueryForGroupBy"));

			while (resultSet.next()) {
				String state = resultSet.getString(1);
				int noOfTestingDone = resultSet.getInt(2);
				int noOfCovidInfectedPatients = resultSet.getInt(3);
				int noOfPatientsRecovered = resultSet.getInt(4);
				CovidStats covidStats = new CovidStats(state, noOfTestingDone, noOfCovidInfectedPatients,
						noOfPatientsRecovered);
				covidStatsList.add(covidStats);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeResorses(resultSet);
			ConnectionUtil.closeResorses(connection);

		}

		return covidStatsList;
	}

	public static TreeSet<CovidStats> getCovidStats() {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionWithDatabase.establishConnection();
		Statement selectStmt = null;
		ResultSet resultSet = null;
		Properties properties = ConnectionWithDatabase.getSQLProperties();
		TreeSet<CovidStats> covidStatsList = new TreeSet<CovidStats>();
		try {
			selectStmt = connection.createStatement();
			resultSet = selectStmt.executeQuery(properties.getProperty("selectQuery"));

			while (resultSet.next()) {
				String state = resultSet.getString(1);
				String city = resultSet.getString(2);
				int noOfTestingDone = resultSet.getInt(3);
				int noOfCovidInfectedPatients = resultSet.getInt(4);
				int noOfPatientsRecovered = resultSet.getInt(5);
				String date = resultSet.getString(6);
				CovidStats covidStats = new CovidStats(state, city, noOfTestingDone, noOfCovidInfectedPatients,
						noOfPatientsRecovered, date);
				covidStatsList.add(covidStats);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeResorses(resultSet);
			ConnectionUtil.closeResorses(connection);

		}

		return covidStatsList;
	}

	public static TreeSet<CovidStats> getStatsOfCity(String city) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionWithDatabase.establishConnection();
		PreparedStatement selectStmt = null;
		ResultSet resultSet = null;
		Properties properties = ConnectionWithDatabase.getSQLProperties();
		TreeSet<CovidStats> covidStatsList = new TreeSet<CovidStats>();
		try {
			selectStmt = connection.prepareStatement(properties.getProperty("selectQueryForCity"));
			selectStmt.setString(1, city);
			resultSet = selectStmt.executeQuery();
			while (resultSet.next()) {
				String state = resultSet.getString(1);
				String city1 = resultSet.getString(2);
				int noOfTestingDone = resultSet.getInt(3);
				int noOfCovidInfectedPatients = resultSet.getInt(4);
				int noOfPatientsRecovered = resultSet.getInt(5);
				CovidStats covidStats = new CovidStats(state, noOfTestingDone, noOfCovidInfectedPatients,
						noOfPatientsRecovered);
				covidStats.setCity(city1);
				covidStatsList.add(covidStats);
			}

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.closeResorses(resultSet);
			ConnectionUtil.closeResorses(connection);

		}

		return covidStatsList;
	}

}
