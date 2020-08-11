package review;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Stack;

public class TestRemoveKDigits2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRemoveKDigits2 trkd = new TestRemoveKDigits2();
		//System.out.println(trkd.removeKDigits("1593212",3));
		trkd.removeKDigits2("1593212",3);
		trkd.removeKDigits2("30200", 1);
		trkd.removeKDigits2("10", 2);
		trkd.removeKDigits2("541270936", 3);
	}

	private String removeKDigits(String s, int number) {
		// TODO Auto-generated method stub
		String newNum = s;
		for(int i=0;i<number;i++){
			boolean hasCut = false;
			for(int j=0;j<newNum.length()-1;j++){
				if(newNum.charAt(j)>newNum.charAt(j+1)){
					newNum = newNum.substring(0, j)+newNum.substring(j+1,newNum.length());
					hasCut = true;
					break;
				}
			}
			
			if(!hasCut){
				newNum = newNum.substring(0, newNum.length()-1);
			}
			
			newNum = removeZero(newNum);
		}
		
		if(newNum.length()==0){
			return "0";
		}
		
		return newNum;
	}

	private String removeZero(String newNum) {
		// TODO Auto-generated method stub
		for(int i=0;i<newNum.length()-1;i++){
			if(newNum.charAt(0)!='0'){
				break;
			}
			
			newNum = newNum.substring(1, newNum.length());
		}
		
		return newNum;
	}

	private void removeKDigits2(String s, int number){
		int newlength = s.length()-number;
		char[] stack = new char[s.length()];
		int top = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			while(top>0&&stack[top-1]>c&&number>0){
				top--;
				number--;
			}
			stack[top++]= c;
		}
		
		int offset = 0;
		while(stack[offset]=='0'&&offset<newlength){
			offset++;
		}
		
		String newString = offset==newlength?"0":s.valueOf(stack, offset, newlength-offset);
		System.out.println(newString);
		
		
	}
}
