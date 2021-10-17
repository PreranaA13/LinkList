
public class Main {

	public static void main(String[] args) {
		Linklist l1 = new Linklist();
		l1.revercePrint(l1.head);
		//l1.print();  
		System.out.println(l1); // using toString
		
		/*
		l1.insert(10);
		
		l1.insert(20);
		
		l1.insert(30);
		
		l1.insert(40);
		
		//l1.print();
		System.out.println(l1);
		*/
		
		/*for(int i = 0; i<100; i++) {
			l1.insert(i);
			
		}*/
		
		l1.insert(67);
		l1.insert(6);
		l1.insert(7);
		l1.insert(13);
		l1.insert(90);
		l1.deleteFirst();
		
		System.out.println(l1);
		
		System.out.println(l1);
	}
}
