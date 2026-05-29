/*package swap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class swap {
	public static void sort(int[] tickets) {
		Queue<Integer> buffer=new PriorityQueue<>();
		Arrays.stream(tickets).forEach((t)->buffer.offer(t));
		int index=0;
		while(!buffer.isEmpty()) {
			tickets[index]=buffer.poll();
			index++;
			
		}
	}
	
	public static void main(String[] args) {
		sort(new int[] {2,0,0,1,0,1,2,0});
		sort(new int[] {2,0,1,0,2,1});
     }
}
*/
//2
//leetcode-75
import java.util.Arrays;

public class ticketSort {
	public static void sort(int[] tickets) {
		int left=0,trav=0,end=tickets.length-1;
		while(trav<=end) {
			if(tickets[trav]==0) {
				tickets[trav]^=tickets[left];
				tickets[left]^=tickets[trav];
				tickets[trav]^=tickets[left];
				left++;trav++;
			}
			else if(tickets[trav]==1)trav++;
			else {
				tickets[trav]^=tickets[end];
				tickets[end]^=tickets[trav];
				tickets[trav]^=tickets[end];
				end--;
			}
		}
		System.out.println(Arrays.toString(tickets)); //no needed
	
	}
	public static void main(String[] args) {
		sort(new int[] {2,0,0,1,0,2,0,1});
		sort(new int[] {2,0,2,1,1,0});
     }
}