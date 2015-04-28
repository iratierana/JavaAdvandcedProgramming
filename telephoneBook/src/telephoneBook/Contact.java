package telephoneBook;

public class Contact {
	long number;
	String name;
	
	public Contact(long number, String name){
		this.number = number;
		this.name = name;
	}
	
	public boolean findContact(String name){
		 if(this.name.equals(name)){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
	
}
