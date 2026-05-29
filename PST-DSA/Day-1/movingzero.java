//1
//leetcode-283
import java.util.Arrays;

public class movingzero {
	public static void move(int[] trucks) {
		int valid =0,traversal=1,size=trucks.length;
		while(traversal<size) {
			if(trucks[valid]==0) {
				 trucks[valid]=trucks[traversal];
				 valid++;
			}
			traversal++;
		}
		Arrays.fill(trucks,valid ,size,0);  //val:0
		System.out.println(Arrays.toString(trucks));
	}
    public static void main(String[] args) {
     move(new int[] {20,0,19,5,0,3,10,3,2});
     move(new int[] {3,0,0,1,0,5,0,6,0});
    }
}