package review;

import java.util.Arrays;

public class TestBigSum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBigSum tbs = new TestBigSum();
		System.out.println(tbs.sumbigNum("426709752318","95481253129"));
	}

	private String sumbigNum(String a, String b) {
		// TODO Auto-generated method stub
		int maxlength = a.length()>b.length()?a.length():b.length();
		int[] resultarray = new int[maxlength+1];
		int[] arraya = new int[maxlength+1];
		for(int i=0;i<a.length();i++){
			arraya[i]=a.charAt(a.length()-1-i)-'0';
		}
		int[] arrayb = new int[maxlength+1];
		for(int i=0;i<b.length();i++){
			arrayb[i]=b.charAt(b.length()-1-i)-'0';
		}
		
		int temp = 0;
		for(int i=0;i<maxlength;i++){
			temp = resultarray[i];
			temp += arraya[i];
			temp += arrayb[i];
			if(temp>=10){
				temp=temp-10;
				resultarray[i+1]=1;
			}
			resultarray[i]=temp;
			
		}
		
		System.out.println(Arrays.toString(resultarray));
		
		StringBuilder bd = new StringBuilder();
		boolean isfirst = false;
		for(int i=resultarray.length-1;i>0;i--){
			if(!isfirst){
				if(resultarray[i]==0){
					continue;
				}else{
					isfirst = true;
				}
			}
			
			bd.append(resultarray[i]);
		}
		
		return bd.toString();
	}

}
