package review;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestFindLinkCycle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFindLinkCycle tflc = new TestFindLinkCycle();
		List<Node> list = new LinkedList<Node>();
		Node n1 = new Node(5);
		list.add(n1);
		Node n2 = new Node(3);
		list.add(n2);
		n1.next = n2;
		Node n3 = new Node(7);
		list.add(n3);
		n2.next = n3;
		Node n4 = new Node(2);
		list.add(n4);
		n3.next = n4;
		Node n5 = new Node(6);
		list.add(n5);
		n4.next = n5;
		Node n6 = new Node(8);
		list.add(n6);
		n5.next = n6;
		Node n7 = new Node(1);
		list.add(n7);
		n6.next = n7;
		//n7.next = n4;
		System.out.println(tflc.findCycle(n1));
		System.out.println(tflc.checkCycleLength(n1));
		System.out.println(tflc.findIntoNode(n1).data);
	}

	private static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	private Boolean findCycle(Node n1){
		Boolean hasCycle = false;
		Node one = n1;
		Node two = n1;
		while(two!=null&&two.next!=null){
			one = one.next;
			two = two.next.next;
			
			if(one.equals(two)){
				
				hasCycle = true;
				break;
			}
			
		}
	
		
		return hasCycle;
	}
	
	private int checkCycleLength(Node n1){
		int length = 0;
		int count = 0;
		if(findCycle(n1)){
			Node one = n1;
			Node two = n1;
			
			while(count<2){
				one = one.next;
				two = two.next.next;
				if(one.equals(two)){
					if(count<1){
						count=1;
					    
					}else{
						break;
					}
				}
				
				if(count>=1){
					length++;
				}
				
			}
		}
		
		
		return length; 
	}
	
	private Node findIntoNode(Node n1){
		Node into = n1;
		if(findCycle(n1)){
			Node one = n1;
			Node two = n1;
			while(two.next!=null&&two!=null){
				one = one.next;
				two = two.next.next;
				if(one.equals(two)){
					one = n1;
					break;
				}
			}
			
			
			while(!one.equals(two)){
				one = one.next;
				two = two.next;
				
			}
			
			into = one;
		}
		
		
		return into;
	}

}
