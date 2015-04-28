package exercise2;

import java.util.Comparator;

public class PositionComparator implements Comparator<Figure>{

	@Override
	public int compare(Figure arg0, Figure arg1) {
		if(arg0.posX < arg1.posX){
			return -1;
		}
		if(arg0.posX==arg1.posX){
			return 0;
		}
		if(arg0.posX > arg1.posX){
			return 1;
		}
		
		return 0;
		
	}

}
