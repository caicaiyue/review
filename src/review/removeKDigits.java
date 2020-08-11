package review;

//给出一个整数，从该整数中去掉K个数字，要求剩下的数字形成的新整数尽可能小
//假设给出一个整数1593212，删去3个数字，新整数最小的情况是1212
public class removeKDigits {
	
	public String removeKDigits(String s,int k){
		int newlength = s.length()-k;
		int top = 0;
		char[] stack = new char[s.length()];
		for(int i=0;i<s.length();++i){
			char c = s.charAt(i);
			while(top>0&&stack[top-1]>c&&k>0){
				top--;
				k--;
			}
			stack[top++]=c;
		}
		
		int offset = 0;
		while(offset<newlength&&stack[offset]=='0'){
			offset++;
		}
		
		return offset==newlength?"0":new String(stack,offset,newlength-offset);
		
	}
	
	public String removeKDigits2(String s,int k){
		String newString = s;
		boolean hascut;
		for(int i=0;i<k;i++){
			hascut = false;
			for(int j=0;j<newString.length()-1;j++){
				if(newString.charAt(j)>newString.charAt(j+1)){
					newString = newString.substring(0, j)+newString.substring(j+1, newString.length());
					hascut = true;
					break;
				}
			}
			if(!hascut){
				newString = newString.substring(0,newString.length()-1);
			}
			
			newString = removeZero(newString);
		}
		
		if(newString.length()==0){
			return "0";
		}
		
		return newString;
	}

	private String removeZero(String s) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length();i++){
			if(s.charAt(0)!='0'){
				break;
			}
			s = s.substring(1,s.length());
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeKDigits rkd = new removeKDigits();
		//String s = "541270936";
		String s = "1593212";
		//String s = "30200";
		//String s = "10";
		//System.out.println(rkd.removeKDigits(s, 3));
		System.out.println(rkd.removeKDigits2(s, 3));
	}

}
