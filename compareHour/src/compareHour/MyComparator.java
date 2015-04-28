package compareHour;

import java.util.Comparator;

public class MyComparator implements Comparator<Hour>{

	public int compare(Hour hour1, Hour hour2) {
		if(hour1.hour<hour2.hour){
			return -1;
		}
		if(hour1.hour==hour2.hour){
			if(hour1.minute<hour2.minute){
				return -1;
			}
			if(hour1.minute==hour2.minute){
				return 0;
			}
			if(hour1.minute>hour2.minute){
				return 1;
			}
		}
		return 1;
	}

}
