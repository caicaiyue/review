package review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestFindMaxDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TestFindMaxDiff tfmd = new TestFindMaxDiff();
       //int[] array = {2,6,3,4,5,10,9};
      //int[] array = {4,7,6,5,3,2,8,1};
       //int[] array ={2,3,4,7,1,8,9,10,12,13,1};
		// int[] array = { 1, 2, 3, 5, 4 };
		// int[] array = { 2, 3, 1,4, 5, 1 };
		//int[] array = { 4, 4, 6, 5, 3, 2, 8, 1 };
		 int[] array = { 90, 99, 95, 94, 95 };
		// int[] array = { 95, 94, 91, 98, 99, 90, 99, 93, 91, 92 };
      // tfmd.findMaxDiff(array);
      System.out.println( tfmd.findMaxDiff2(array));
	}

	private int findMaxDiff2(int[] array) {
		// TODO Auto-generated method stub
		int max = array[0];
		int mini = array[0];
		for(int i:array){
			if(i>max){
				max = i;
			}
			
			if(i<mini){
				mini = i;
			}
		}
		
		int diff = max -mini;
		if(diff==0){
			return 0;
		}
		
		int bucketnum = array.length;
		Bucket[] bucketarray = new Bucket[bucketnum];
		for(int i=0;i<bucketnum;i++){
			bucketarray[i] = new Bucket();
		}
		
		int temp = 0;
		for(int i:array){
			temp = (i-mini)*(bucketnum-1)/diff;
			if(bucketarray[temp].mini==null||bucketarray[temp].mini>i){
				bucketarray[temp].mini = i;
			}
			
			if(bucketarray[temp].max==null||bucketarray[temp].max<i){
				bucketarray[temp].max = i;
			}
		}
		
		int leftmax = bucketarray[0].max;
		int maxdiff = 0;
		for(int i=1;i<bucketnum;i++){
			if(bucketarray[i].mini==null){
				continue;
			}
			
			if(bucketarray[i].mini-leftmax>maxdiff){
				maxdiff = bucketarray[i].mini-leftmax;
			}
			
			leftmax = bucketarray[i].max;
		}
		
		return maxdiff;
	}
	
	private static class Bucket{
		Integer mini;
		Integer max;
	}

	private void findMaxDiff(int[] array) {
		// TODO Auto-generated method stub
		List<LinkedList<Integer>> bucketlist = new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<array.length;i++){
			bucketlist.add(new LinkedList());
		}
		
		int mini = array[0];
		int max = array[0];
		for(int i:array){
			if(i<mini){
				mini = i;
			}
			
			if(i>max){
				max = i;
			}
		}
		
		//System.out.println("mini:"+mini+",max:"+max);
		
		int diff = max - mini;
		int temp = 0;
		for(int i:array){
			temp = (i-mini)*(array.length-1)/diff;
			bucketlist.get(temp).add(i);
		}
		
		for(int i=0;i<array.length;i++){
			Collections.sort(bucketlist.get(i));
		}
		
		
		
		for(int i=0;i<array.length;i++){
			Collections.sort(bucketlist.get(i));
		}
		
		int aftermini = 0;
		int beforemax  = 0;
		int maxdiff =0;
		
		for(int i=0;i<array.length-1;i++){
			if(!bucketlist.get(i).isEmpty()){
				beforemax = bucketlist.get(i).getLast();
				
			}
			
			if(!bucketlist.get(i+1).isEmpty()){
				aftermini = bucketlist.get(i+1).getFirst();
			}
			
			if(aftermini-beforemax>maxdiff){
				maxdiff = aftermini-beforemax;
			}
		}
		
		System.out.println(maxdiff);
	}
}
