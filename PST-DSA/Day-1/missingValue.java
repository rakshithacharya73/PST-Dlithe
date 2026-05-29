//3
//leetcode-41

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class missingValue {
	public static void main(int[] invoices) {
		List<Integer> invoices1= Arrays.asList( 8,10,3,1,4,2,5);
		int mini=Collections.min(invoices1);
		while(true) {
			int current=mini+1;
			if(invoices1.contains(current)) {
				mini=current;
			}
			else {
				System.out.println("Missing minimum is"+current);
				return ;
			}
		
			
		}
	}
}