package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.event.ListSelectionEvent;
import javax.swing.text.html.HTMLDocument.Iterator;

public class TestQuickSort {

	public void quickSort(int[] array, int startindex, int endindex) {

		Stack<Map<String, Integer>> quickstack = new Stack<Map<String, Integer>>();
		Map<String, Integer> pivotmap = new HashMap<String, Integer>();
		pivotmap.put("startindex", startindex);
		pivotmap.put("endindex", endindex);
		quickstack.push(pivotmap);
		while (!quickstack.isEmpty()) {
			pivotmap = quickstack.pop();
			int start = pivotmap.get("startindex");
			int end = pivotmap.get("endindex");
			if (start >= end) {
				continue;
			}
			int pivotindex = partition(array, start, end);
			Map<String, Integer> endmap = new HashMap<String, Integer>();
			endmap.put("startindex", pivotindex + 1);
			endmap.put("endindex", end);
			quickstack.push(endmap);
			Map<String, Integer> startmap = new HashMap<String, Integer>();
			startmap.put("startindex", start);
			startmap.put("endindex", pivotindex - 1);
			quickstack.push(startmap);
		}
	}

	private int partition(int[] array, int start, int end) {
		// TODO Auto-generated method stub

		int pivot = array[start];
		int index = start;
		int temp;
		for (int i = start + 1; i <= end; i++) {
			if (array[i] < pivot) {
				index++;
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}
		array[start] = array[index];
		array[index] = pivot;

		return index;
	}

	// 计数排序
	public int[] countSort(int[] array) {
		if (array.length <= 0) {
			return array;
		}
		int max = array[0];
		int min = array[0];
		for (int i : array) {
			if (i > max) {
				max = i;
			}

			if (i < min) {
				min = i;
			}
		}

		int count = max - min + 1;
		int[] countarray = new int[count];
		for (int i : array) {
			int num = i - min;
			countarray[num]++;
		}
		// System.out.println(Arrays.toString(countarray));

		for (int i = 0; i < countarray.length; i++) {
			if (i >= 1) {
				countarray[i] = countarray[i] + countarray[i - 1];
			}
		}

		// List list = new ArrayList();
		int[] sortedarray = new int[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			int num = array[i] - min;
			sortedarray[countarray[num] - 1] = array[i];
			countarray[num]--;
		}

		// System.out.println(Arrays.toString(sortedarray));
		/*
		 * int num = 0; 这样写会破坏相当的两个值的顺序，弄不明白 for(int i=0;i<count;i++){
		 * while(countarray[i]>0){ //list.add(i+min); sortedarray[num]=i+min;
		 * countarray[i]--; num++; } }
		 */

		return sortedarray;

	}

	public void bucketsort(double[] array){
		if(array.length<=0){
			return;
		}else{
			double min = array[0];
			double max = array[0];
			
			for(double i:array){
				if(i<min){
					min = i;
				}
				
				if(i>max){
					max = i;
				}
			}
			
		   double bucketsize = (max-min)/(array.length-1);
		   
		   List<LinkedList<Double>> bucketlist = new ArrayList<LinkedList<Double>>();
		   
		   for(int i=0;i<array.length;i++){
			   LinkedList<Double> ld = new LinkedList<Double>();
			   bucketlist.add(ld);
		   }
		   
		   
		   for(double d:array){
			   int num = (int) ((d-min)/bucketsize);
			   bucketlist.get(num).add(d);
		   }
		   
		   for(int i=0;i<bucketlist.size();i++){
			   Collections.sort(bucketlist.get(i));
		   }
		   
		   double[] sortedarray = new double[array.length];
		   int index =0;
		   for(int i=0;i<bucketlist.size();i++){
			   for(double d:bucketlist.get(i)){
				   sortedarray[index]=d;
				   index++;
			   }
		   }
		   
		   System.out.println(Arrays.toString(sortedarray));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] array = {4,7,6,5,3,2,8,1};
		// int[] array = {3,5,7,1,8,4,9};
		// int[] array ={2,3,4,7,8,9,10,12,13,1};
		// int[] array = {1,2,3,4,3,2,3,7,8,9};
		// int[] array = {90,99,95,94,95};
		//double[] array = { 0.5, 2.18,7.1, 0.84,3.25, 1.6,0,4.5 };
		 double[] array = {4.12,1.212,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
		// double[] array =
		// {4.12,1.212,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
		TestQuickSort tqs = new TestQuickSort();
		// qs.quickSort(array, 0, array.length-1);
		// tqs.countSort(array);
		// System.out.println(Arrays.toString(tqs.countSort(array)));
		tqs.bucketsort(array);
		//System.out.println(Arrays.toString(array));
	}

}
