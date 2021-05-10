package com.covidstats.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
		
	public static void closeResorses(Connection connection)
	{
			if(connection!=null)
			{
				try
				{
					connection.close();
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
	}

	public static void closeResorses(PreparedStatement insertStmt) {
		// TODO Auto-generated method stub
		if(insertStmt!=null)
		{
			try
			{
				insertStmt.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	
	}

	public static void closeResorses(ResultSet resultSet) {
		// TODO Auto-generated method stub
		if(resultSet!=null)
		{
			try
			{
				resultSet.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public static void closeResorses(Statement statement) {
		// TODO Auto-generated method stub
		if(statement!=null)
		{
			try
			{
				statement.close();
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
