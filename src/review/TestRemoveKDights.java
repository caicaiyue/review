package review;

public class TestRemoveKDights {
	public String RemoveKDights (String s,int k){
		int top = 0;
		int newlength = s.length()-k;
		char[] stack = new char[s.length()];
		for(int i=0;i<s.length();++i){
			char c = s.charAt(i);
			while(top>0&&k>0&&c<stack[top-1]){
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
	
	public String RemoveKDights2(String s,int k){
		String newString = s;
		boolean hasCut = false;
		while(k>0){
			hasCut = false;
			for(int i=0;i<newString.length()-1;i++){
				if(newString.charAt(i)>newString.charAt(i+1)){
					//String s1 = newString.substring(0,i);
					//String s2 = newString.substring(i+1,newString.length());
					newString = newString.substring(0,i)+newString.substring(i+1, newString.length());
					//endpoint不要，所以去掉了i
					hasCut = true;
					break;
				}
			}
			k--;
		}
		
		if(!hasCut){
			newString = newString.substring(0,newString.length()-1);
		}
		
		newString = removeZero(newString);
		
		if(newString.length()==0){
			return "0";
		}
		return newString;
	}
	
	private String removeZero(String s) {
		// TODO Auto-generated method stub
		int k=0;
		while(s.length()>0&&k<s.length()&&s.charAt(0)=='0'){
			s = s.substring(1,s.length());
			k++;
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRemoveKDights krd = new TestRemoveKDights();
		String s = "541270936";
		//String s = "1593212";
		//String s = "30200";
		//String s = "10";
		System.out.println(krd.RemoveKDights(s, 3));
		System.out.println(krd.RemoveKDights2(s, 1));
	}

}
