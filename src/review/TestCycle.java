package review;

public class TestCycle {
	Boolean hasCycle;
	int cyclelength;
	
	
	//p1ָ��һ��ָ����һ���ڵ㣬ÿ�ξ�����һ����p2ָ��һ������������p1 p2 �������������������л� 
	//p1 p2 ��һ��������p1������������1��p2������������2�����ǵ��ٶȲ�Ϊ1��������ʱ���ߵĲ������ǻ���
	public void isCycle(Node head) {
		hasCycle = false;
		int checkcount = 0;
		int step = 0;
		Node p1 = head;
		Node p2 = head;
		while (p2 != null && p2.next != null&&checkcount<2) {
			p1 = p1.next;
			step++;
			p2 = p2.next.next;
			if (p1 == p2) {
				hasCycle = true;
				checkcount++;
				
				if(checkcount>1){
					cyclelength = step;
					return;
				}else{
					step = 0;
				}
			}
		}

		hasCycle =  false;
	}
	
	//p1һ������1����p2һ������������p1��p2��һ��������p1�ص���㡣p2ͣ�ڵ�һ�������㡣
	//������p1��p2ÿ�ζ�ֻ����һ��������������뻷��
	public void FindEnterNode(Node head){
		Node p1 = head;
		Node p2 = head;
		int checkcount = 0;
		while(p2!=null&&p2.next!=null&&checkcount<2){
			p1 = p1.next;
			if(checkcount>=1){
				p2 = p2.next;
			}else{
				p2 = p2.next.next;
			}
			
			if(p1==p2&&checkcount<1){
				p1 = head;
				checkcount++;
			}
			
			if(p1==p2&&checkcount>=1){
				System.out.println("���������ǣ�"+p1.data);
				checkcount++;
				return;
			}
		}
		
		System.out.println("����δ�ɻ���û�����");
	}

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		TestCycle tc = new TestCycle();
		// TODO Auto-generated method stub
		Node n1 = new Node(5);
		Node n2 = new Node(3);
		Node n3 = new Node(7);
		Node n4 = new Node(2);
		Node n5 = new Node(6);
		Node n6 = new Node(8);
		Node n7 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n2;
		tc.isCycle(n1);
		System.out.println(tc.hasCycle);
		System.out.println(tc.cyclelength);
		tc.FindEnterNode(n1);
	}

}
