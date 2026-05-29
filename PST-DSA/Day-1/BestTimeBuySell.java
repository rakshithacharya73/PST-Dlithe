//4
// leetcode-121
public class BestTimeBuySell{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stocks= {7,1,45,3,6,4};
		if(stocks.length<2) return;
		int Cbuy =stocks[0],Csell=stocks[1];
		int Mpro=Csell-Cbuy;
		for(int curr=1;curr<stocks.length;curr++) {
			int Cpro=stocks[curr] -Cbuy;
			if(Cpro>Mpro) {
				Mpro=Cpro;
				Csell=stocks[curr];
			}
			if(stocks[curr]<Cbuy) Cbuy=stocks[curr];
		}
		System.out.println((Csell-Mpro)+" "+Csell);
	}

}
