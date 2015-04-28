package foodShop;

import java.util.Scanner;

public class Date {
	
	int miliSecond = 0;
	int second = 0;
	int minute = 0;
	int hour = 0;
	int day = 0;
	int month = 0;
	int year = 0;
	
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date(){
		
	}
	
	public void arrangeDate(){
		while(miliSecond>=1000){
			miliSecond = miliSecond - 1000;
			second++;
		}
		
		while(second>=60){
			second = second - 60;
			minute++;
		}
		
		while(minute>=60){
			minute = minute - 60;
			hour++;
		}
		
		while(hour>=24){
			hour = hour - 24;
			day++;
		}
	}

	public int getMiliSecond() {
		return miliSecond;
	}

	public void setMiliSecond(int miliSecond) {
		this.miliSecond = miliSecond;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString(){
		return  "\nMili Second: " +miliSecond+
				"\nSecond: " +second+
				"\nMinute: " +minute+
				"\nHour: " +hour+
				"\nDay: " +day+
				"\nMonth: " +month+
				"\nYear: " +year;
	}

}

