package TDA;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>{
	
	//∗∗ Compares two strings according to their lengths. ∗/
	public int compare(String a, String b) {
		if (a.length( ) < b.length( )) return -1;
		else if (a.length( ) == b.length( )) return 0;
		else return 1;
	}

}
