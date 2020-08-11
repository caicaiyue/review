package review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestRemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRemoveKDigits trkd = new TestRemoveKDigits();
		String s = "32517489";
		trkd.removeKDights(s,4);
	}

	private void removeKDights(String s,int num) {
		// TODO Auto-generated method stub
		if(num>s.length()){
			System.out.println("³¬³ö·¶Î§");
		}
		int[] array = new int[s.length()];
		for(int i=0;i<s.length();i++){
			array[i] = s.charAt(i)-'0';
		}
		
		int count=0;
		boolean isFind = false;
		while(count<num){
			isFind = false;
			for(int j=0;j<array.length-1;j++){
				if(array[j]>array[j+1]){
					array[j]=0;
					count++;
					isFind = true;
					break;
				}
			}
			
			if(!isFind){
				array[count]=0;
				count++;
			}
			
			
		}
		
		System.out.println(Arrays.toString(array));
		
	}

}
