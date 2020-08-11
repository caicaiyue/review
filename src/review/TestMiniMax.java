package review;

import java.util.Arrays;

public class TestMiniMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMiniMax tmm = new TestMiniMax();
		String s = "14532";
		tmm.testmini(s);
	}

	private void testmini(String s) {
		// TODO Auto-generated method stub
		char[] c = s.toCharArray();
		int[] array = new int[s.length()];
		for(int i=0;i<s.length();i++){
			array[i] = c[i]-'0';
		}
		
		int index = 0;
		for(int i=array.length-1;i>0;i--){
				if(array[i]>array[i-1]){
					index = i;
					break;
				}
			
		}
		
		if(index==0){
			System.out.println("已是最大数组合了");
			return;
		}
		
		index--;
		int temp = 0;
		for(int i=array.length-1;i>index;i--){
			if(array[i]>array[index]){
				temp = array[i];
				array[i]=array[index];
				array[index]=temp;
				break;
			}
		}
		
		System.out.println(Arrays.toString(array));
		
		for(int i=array.length-1;i>index;i--){
			for(int j=index+1;j<i;j++){
				if(array[j]>array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
