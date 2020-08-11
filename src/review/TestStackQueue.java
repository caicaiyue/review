package review;

import java.util.Stack;

//������ջʵ�ֶ���
public class TestStackQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	//����ջ��ʵ�ֽ�����
	public void intostackqueue(int data){
		s1.push(data);
	}
	
	public Integer outstackqueue(){
		if(s2.isEmpty()){
			if(s1.isEmpty()){
				//System.out.println("�����Ѿ����ˣ����ܳ�����");
				return null;
			}else{
				transfer();
			}
		}
		
		return s2.pop();
	}
	
	private void transfer() {
		// TODO Auto-generated method stub
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStackQueue tsq = new TestStackQueue();
		tsq.intostackqueue(1);
		tsq.intostackqueue(2);
		tsq.intostackqueue(3);
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		tsq.intostackqueue(4);
		System.out.println(tsq.outstackqueue());
		tsq.intostackqueue(5);
		tsq.intostackqueue(6);
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
		System.out.println(tsq.outstackqueue());
	}

}
