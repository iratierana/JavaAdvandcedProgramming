package exercise1;

import java.util.ArrayList;

public class Person {
	String name;
	String secondName;
	String thirdName;
	
	ArrayList<Signature> signatureList;

	public Person(String[] split) {
		name = split[0];
		secondName = split[1];
		thirdName = split[2];
		signatureList = new ArrayList<Signature>();
	}

	public String toString(){
		return name + " " + secondName + " " + thirdName;
	}
}
