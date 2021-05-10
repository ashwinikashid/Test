package com.covidstats.model;

public class CovidStats implements Comparable<CovidStats>{


	private String state;
	private String city;
	private Integer noOfTestingDone;
	private Integer noOfCovidInfectedPatients;
	private Integer noOfPatientsRecovered;
	private String date;

	public CovidStats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CovidStats(String state, String city, Integer noOfTestingDone, Integer noOfCovidInfectedPatients,
			Integer noOfPatientsRecovered, String date) {
		super();
		this.state = state;
		this.city = city;
		this.noOfTestingDone = noOfTestingDone;
		this.noOfCovidInfectedPatients = noOfCovidInfectedPatients;
		this.noOfPatientsRecovered = noOfPatientsRecovered;
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNoOfTestingDone() {
		return noOfTestingDone;
	}

	public void setNoOfTestingDone(Integer noOfTestingDone) {
		this.noOfTestingDone = noOfTestingDone;
	}

	public Integer getNoOfCovidInfectedPatients() {
		return noOfCovidInfectedPatients;
	}

	public void setNoOfCovidInfectedPatients(Integer noOfCovidInfectedPatients) {
		this.noOfCovidInfectedPatients = noOfCovidInfectedPatients;
	}

	public Integer getNoOfPatientsRecovered() {
		return noOfPatientsRecovered;
	}

	public void setNoOfPatientsRecovered(Integer noOfPatientsRecovered) {
		this.noOfPatientsRecovered = noOfPatientsRecovered;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int compareTo(CovidStats covidStats) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (noOfCovidInfectedPatients> covidStats.noOfCovidInfectedPatients) {
			return -1;
		} else if (noOfCovidInfectedPatients < covidStats.noOfCovidInfectedPatients) {
			return 1;
		} else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "CovidStats [\n state=" + state + ", \n city=" + city + ", \n noOfTestingDone=" + noOfTestingDone
				+ ", \n noOfCovidInfectedPatients=" + noOfCovidInfectedPatients + ", \n noOfPatientsRecovered="
				+ noOfPatientsRecovered + ", \n date=" + date + "]";
	}

	public CovidStats(String state, Integer noOfTestingDone, Integer noOfCovidInfectedPatients,
			Integer noOfPatientsRecovered) {
		super();
		this.state = state;
		this.noOfTestingDone = noOfTestingDone;
		this.noOfCovidInfectedPatients = noOfCovidInfectedPatients;
		this.noOfPatientsRecovered = noOfPatientsRecovered;
	}

}
