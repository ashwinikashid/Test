package com.covidstats.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.covidstats.dao.CovidStatsDao;
import com.covidstats.model.CovidStats;

public class StatsService {

	public static void addCovidStats(ArrayList<CovidStats> covidStatsList) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		byte addmore = 1;
		do {
			System.out.println("Enter state:");
			String state = sc.nextLine();

			System.out.println("Enter city:");
			String city = sc.nextLine();

			System.out.println("Enter noOfTestingDone:");
			Integer noOfTestingDone = sc.nextInt();

			System.out.println("Enter noOfCovidInfectedPatients:");
			Integer noOfCovidInfectedPatients = sc.nextInt();

			System.out.println("Enter noOfPatientsRecovered:");
			Integer noOfPatientsRecovered = sc.nextInt();

			sc.nextLine();
			System.out.println("Enter date:");
			String date = sc.nextLine();

			CovidStats covidStats = new CovidStats(state, city, noOfTestingDone, noOfCovidInfectedPatients,
					noOfPatientsRecovered, date);
			covidStatsList.add(covidStats);

			System.out.println("Do you want to add more \n 1.Yes \n 2.No");
			addmore = sc.nextByte();
			sc.nextLine();

		} while (addmore != 2);
		CovidStatsDao.insertStats(covidStatsList);

	}

	public static void displayCovidStats() {
		// TODO Auto-generated method stub
		TreeSet<CovidStats> covidStatsList = CovidStatsDao.getCovidStats();
		System.out.println("*************COVID Stats*******************");
		for (CovidStats covidStats : covidStatsList) {
			System.out.println(covidStats);
			System.out.println("--------------------------------------------");

		}

	}

	public static void displayStateWiseReport() {
		// TODO Auto-generated method stub
		TreeSet<CovidStats> covidStatsList=CovidStatsDao.getStateWiseReport();
		System.out.println("*************COVID state wise Stats*******************");
		for (CovidStats covidStats : covidStatsList) {
			System.out.println("State                     : "+covidStats.getState());
			System.out.println("NoOfTestingDone           : "+covidStats.getNoOfTestingDone());
			System.out.println("NoOfCovidInfectedPatients : "+covidStats.getNoOfCovidInfectedPatients());
			System.out.println("NoOfPatientsRecovered     :"+covidStats.getNoOfPatientsRecovered());
			System.out.println("--------------------------------------------");

		}

	}

	public static void displayStatesForCity(String city) {
		// TODO Auto-generated method stub
		TreeSet<CovidStats> covidStatsList=CovidStatsDao.getStatsOfCity(city);
		System.out.println("*************COVID Stats Of "+city+" *******************");
		for (CovidStats covidStats : covidStatsList) {
			System.out.println("State                     : "+covidStats.getState());
			System.out.println("city                      : "+covidStats.getCity());
			System.out.println("NoOfTestingDone           : "+covidStats.getNoOfTestingDone());
			System.out.println("NoOfCovidInfectedPatients : "+covidStats.getNoOfCovidInfectedPatients());
			System.out.println("NoOfPatientsRecovered     : "+covidStats.getNoOfPatientsRecovered());
			System.out.println("--------------------------------------------");

		}
		
	}

}
