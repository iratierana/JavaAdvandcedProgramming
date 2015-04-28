package exercise2;

import java.util.Comparator;

public class AreaComparator implements Comparator<Figure>{

	@Override
	public int compare(Figure arg0, Figure arg1) {
		if(arg0.area < arg1.area){
			return -1;
		}
		if(arg0.area==arg1.area){
			return 0;
		}
		if(arg0.area > arg1.area){
			return 1;
		}
		
		return 0;
	}

}
