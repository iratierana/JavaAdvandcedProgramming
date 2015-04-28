package intGraphicContactDiary;

public class Colleague extends Person{
	String surname;
	String department;
	
	public String toString(){
		return super.toString() + " " + surname + " " + department;
	}
	
}
