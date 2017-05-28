import java.util.Random;

public class RansacTest {
	public static double Savg;
	public static boolean findList(int r, int arr[]){
		for(int i=0; i<arr.length; i++){
			if(arr[i]==r)
				return false;
		}
		return true;
	}
	
	public static double getSubAvg(int arr[], int add){	
		double avg=0;
		double subavg=0;
		for(int i=0; i<arr.length; i++){
			avg+=arr[i];		
			}
		if(add>0){
			Savg=(avg+add)/(arr.length+1);
		}
		else{
			Savg=(avg)/(arr.length);
		}
		
		for(int i=0; i<arr.length; i++){
			subavg+=Math.abs(arr[i]-Savg);
		}
		if(add>0){
			subavg=(subavg+Math.abs(add-avg))/(arr.length+1);
		}
		else{
			subavg=(subavg)/(arr.length);
		}
		return subavg;
	}
	
	public static void main(String[] args) {
		int allData[]= {6,2,6,4,6,6,7,8,9,6,161,6,6,6,6,16,6,6,6,200,6,6,6,6,6,6,27,28};
		int sampleData[]= new int[allData.length/3];
		int sampleIndex[]= new int[allData.length/3];
		
		int sampleI=0;
		Random ran = new Random();
		while(sampleI<sampleData.length){	
			int r = ran.nextInt(allData.length);
			if(findList(r,sampleIndex)){
				sampleData[sampleI]=allData[r];
				sampleIndex[sampleI]=r;
				sampleI++;
			}
		}
		Savg=0;
		double subavg = getSubAvg(sampleData,0);
		System.out.println(subavg);
		
		for(int i=0; i<allData.length;i++){
			if(subavg>Math.abs(allData[i]-Savg)){
					subavg=getSubAvg(sampleData,allData[i]);
					System.out.println(Savg);
			}
		}
		
	//	System.out.println(Savg);
	}
}
