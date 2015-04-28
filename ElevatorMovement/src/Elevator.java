
public class Elevator {
	int floor;
	String name;
	boolean doorOpened;
	
	public Elevator(int floor, String name, boolean doorOpened){
		this.floor = floor;
		this.name = name;
		this.doorOpened = doorOpened;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		if(this.doorOpened == true){
			System.out.println("Closing door");
			this.doorOpened = false;
		}
		
	
		while(floor!= this.floor){
			if(this.floor<floor){
				this.floor++;
			}
			else{
				this.floor--;
			}
			System.out.println(this.name+": floor "+this.floor);
			
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
		}
		
		if(this.doorOpened == false){
			System.out.println("Opening door");
			this.doorOpened = true;
		}
		
		
	}
	
	public int distance(int floor){
		int distance = 0;
		
		distance = floor - this.floor;
		
		if(distance<0){
			distance = distance * (-1);
		}
		
		return distance;
	}
}
