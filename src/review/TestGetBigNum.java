package review;

import java.util.Arrays;

public class TestGetBigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "426709752318";
		String s2 = "95481253129";
		TestGetBigNum tgb = new TestGetBigNum();
		tgb.CountBigNum(s1,s2);
		
	}

	private  void CountBigNum(String s1, String s2) {
		// TODO Auto-generated method stub
		int bigSize=s1.length()>s2.length()?s1.length():s2.length();
		int[] result = new int[bigSize+1];
		int[] arrayA = new int[bigSize+1];
		int[] arrayB = new int[bigSize+1];
		
		for(int i=0;i<s1.length();i++){
			arrayA[i] = s1.charAt(s1.length()-1-i)-'0';
		}
		
		for(int i=0;i<s2.length();i++){
			arrayB[i] = s2.charAt(s2.length()-1-i)-'0';
		}
		
		int temp;
		for(int i=0;i<result.length;i++){
			temp = arrayA[i]+arrayB[i]+result[i];
			if(temp>=10){
				temp = temp - 10;
				result[i+1]++;
			}
			result[i] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		String ss = "";
		boolean findfirst = false;
		int k = 0;
		
		for(int i=bigSize;i>=0;i--){
			if(!findfirst){
				if(result[i]==0){
					continue;
				}
				findfirst = true;
			}
			
			sb.append(result[i]);
			ss = ss+result[i];
		}

		String s = sb.toString();
		System.out.println(s);
		System.out.println(ss);
		
		
	}
		
	}


