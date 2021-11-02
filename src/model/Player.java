package model;

public class Player implements Comparable<Player>{

	private String name;
	private int age;
	private String team;
	private double averageScore;
	private double averageAssists;
	private double averageBlocks;
	private double averageSteals;
	private double averageBounces;
	
	public Player(String name, int age, String team, double averageScore, double averageAssists, double averageBlocks,
			double averageSteals, double averageBounces) {
		this.name = name;
		this.age = age;
		this.team = team;
		this.averageScore = averageScore;
		this.averageAssists = averageAssists;
		this.averageBlocks = averageBlocks;
		this.averageSteals = averageSteals;
		this.averageBounces = averageBounces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public double getAverageAssists() {
		return averageAssists;
	}

	public void setAverageAssists(double averageAssists) {
		this.averageAssists = averageAssists;
	}

	public double getAverageBlocks() {
		return averageBlocks;
	}

	public void setAverageBlocks(double averageBlocks) {
		this.averageBlocks = averageBlocks;
	}

	public double getAverageSteals() {
		return averageSteals;
	}

	public void setAverageSteals(double averageSteals) {
		this.averageSteals = averageSteals;
	}

	public double getAverageBounces() {
		return averageBounces;
	}

	public void setAverageBounces(double averageBounces) {
		this.averageBounces = averageBounces;
	}

	@Override
	public int compareTo(Player o) {
		return this.getName().compareTo(o.getName());
	}
	
}
