package com.covidstats.client;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.covidstats.model.CovidStats;
import com.covidstats.service.StatsService;

/**
 * Hello world!
 *Database:Use Layering, Exception Handling ,to store and retrieve covid related statistics into database.city 
We need to retrieve statistics city wise or state wise .you can use Menu driven console application . Below fields can be used 
a)No. Of Testing done 
b)No.of covid +be patients
c)City
d)State
e)No of them infected
f)date

You should be able to query for below data
a) All records (including sun)for a specific City
b) Display state wise report
 */
public class Main 
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<CovidStats> covidStatsList = new ArrayList<CovidStats>();

    public static void main( String[] args )
    {
		boolean exit = true;
		do {

			byte choice = dispalyMainMenu();
			switch (choice) {
			case 1:
				StatsService.addCovidStats(covidStatsList);
				break;
			case 2:
				StatsService.displayCovidStats();
				break;
			case 3:
				StatsService.displayStateWiseReport();
				break;
			case 4:
				System.out.println("Enter city:");
				String city=sc.next();
				StatsService.displayStatesForCity(city);
				break;
			case 5:
				System.out.println("THANK YOU");
				System.out.println("Exited sucessfully!!!!!!!!!!!!!!");
				exit = false;
				break;
			default:
				System.out.println("You have entered wrong choice:\n Please Try again!!!");
				break;

			}
		} while (exit);


    }

	private static byte dispalyMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("***************Main Menu*******************");
		System.out.println("    1.insert covid stats       ");
		System.out.println("    2.Show covid stats         ");
		System.out.println("    3.Display state wise report");
		System.out.println("    4.Display stats for pericular city ");
		System.out.println("    5.Exit                             ");
		System.out.println("********************************************");
		
		System.out.println("Enter your choice :");
		byte choice=sc.nextByte();
		return choice;
	}
}
