package juegoBonoloto;

public class Main {
	
	Lottery players[];
	Lottery lotteryTicket;

	public static void main(String[] args) {
		Main exercise = new Main();
		exercise.program();
		
		
	}
	
	public void program(){
			
		players = new Lottery[10];
		
		
		for(int i=0; i<10; i++){
			players[i] = new Lottery();
			players[i].setNumbers();
		}
		
		lotteryTicket.setNumbers();
		
		for(int i = 0; i<10;i++){
			System.out.println("Player "+i+": "+players[i].checkNumbers(lotteryTicket)+" correct");
		}
		
	}
	

}
