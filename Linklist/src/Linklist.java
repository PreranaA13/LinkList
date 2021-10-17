
public class Linklist {
	Node head;
	
	public Linklist() {
		head = null;
	}
	
	public void insert(int value) {
		//space = O(1)
		//time = O(1)
		
		Node temp =new Node(value);  // created object name temp (creating NODE) that have 2 contain data and next
		
		// no node available therefore this is 1st node
		if(this.head==null) { 
			head = temp;  // head pointed to temp
		}
		else {
			// this is not the first node to be inserted
			temp.next = head; // head ke contain temp ke next me copy kiye
			head = temp;   // temp pointed(next) copy into head

		}
	}
	
	public void append(int value) {
		//space =O(1)
		//time =O(n-1)=O(n)
		
		Node temp = new Node(value);
		
		// no node available therefore this is 1st node
		if(this.head == null) {
			head = temp;
		}
		// 1 and more than one node available
		else {
			Node it = this.head;  // it pointed to head pointed
			while(it.next != null) { //it++ up to it.next get null
				it = it.next;
			}
			// it pointed to last node
			it.next = temp;     // insert value at last
			temp.next = null;
		}
	}
	
	public void deleteFirst() {
		// space = O(1)
		// time = O(1)
		
		if (head !=null) {
			// we have 1 or more node in LL
			
			// check if we have only 1 node
			if(this.head.next == null) {
				// yes we have onlu 1 node in LL
				//delete that node and make head = null
				Node temp = this.head;
				this.head = null;
				
				// java dont have delete.... so just make object ref as null
				// GC will delete this object ASAP
				temp.next = null;
				temp = null;
			}
			else {
				// we have more than 1 node
				Node temp = this.head;
				this.head =temp.next;
				
				temp.next= null;
				temp=null;
			}
		}
	}
	
	public void deleteLast() {
		//space = O(1)
		//time = O(n-1)+ O(n-2) = O(n) + O(n) = O(2n)
		
		if (head !=null) {
			// we have 1 or more node in LL
			
			// check if we have only 1 node
			if(this.head.next == null) {
				// yes we have only 1 node in LL
				//delete that node and make head = null
				Node temp = this.head;
				this.head = null;
				
				// java dont have delete.... so just make object ref as null
				// GC will delete this object ASAP
				temp.next = null;
				temp = null;
			}
			else {
				// go to last node
				Node it = this.head;
				
				while(it.next!=null) {
					it = it.next;
				}
				// now it points to last node
				
				Node itp = this.head;
				while(itp.next != it) {
					itp = itp.next;
				}
				// now itp points to last but one node.				
				itp.next = null;
				it = null;
			}
		}
	}
	
	/*public void deleteLastComplasity() {
		//space = O(1)
		//time = O(n-1) = O(n)
		
		if (head !=null) {
			if(this.head.next == null) {
				
				Node temp = this.head;
				this.head = null;
				
				temp.next = null;
				temp = null;
			}
			else {
				// go to last node
				Node it = this.head;
				Node itp = this.head;
				
				while(it.next != null ) {
					it = it.next;
					if(it.next != null)
						itp = itp.next;
				}
				// now it points to last node
				// now itp points to last but one node.	
				
				itp.next = null;
				it = null;
			}
		}
	}*/
	
	public void insertByPos(int value, int position) {
		int noOfNodes = getCount();
		if(position == 1) {
			insert(value);
		}
		else if(position == noOfNodes+1) {
			append(value);
		}
		else if(position >1 && position < noOfNodes+1) {
			// now we have to insert node somewhere in middle
			Node it = head;
			int x = position-1;
			while(--x != 0) {
				it = it.next;
				
			}
			// it reached position where position -1 node
			
			Node temp = new Node(value);
			temp.next = it.next;
			it.next = temp;
		}
		else {
			// not in LinkList invalid position
			System.out.println("Invalid Position");
		 }
	}
	
	public void deleteByPos(int position) {
		int noOfNodes = getCount();
		if(position == 1) {
			deleteFirst();
		}
		else if(position == noOfNodes) {
			deleteLast();
		}
		else if(position >1 && position < noOfNodes) {
			// now we have to delete node somewhere in middle
			Node it = head;
			int x = position-1;
			while(--x != 0) {
				it = it.next;
			}
			// it reached position where position -1 node
			
			Node itp =it.next;
			it.next =itp.next ;
			itp.next = null;
			itp = null;
		}
		else {
			// not in LinkList invalid position
			System.out.println("Invalid Position");
		 }
	}
	
	public void revercePrint(Node it) {	// create local variable
		if(it != null && it.next != null)	{			// exit condition
			revercePrint(it.next);		// recursion (it.next is given to it means +1)
		}
		if(it != null) {
			System.out.print(it.data + "--> ");
		}
		if(it==head) {
			System.out.println();
		}
	}
	
	public void reverce() {
		Node itn = head;
		Node it =head;
		Node itp = null;
		while(it != null) {
			itn = it.next;
			it.next = itp;
			itp = it;
			it = itn;
		}
		head = itp;
	}
	
	private int getCount() {
		Node it = head;
		int counter = 1;
		while(it != null) { // job tak it = null, tab tak count +1 
			counter++;
			it =it.next;
		}
		return counter;
	}
	
	/*
	 public void print() {
	 
		if(this.head == null) {
			System.out.println("linklist is emapty");
			
		}
		else {
			Node it = head; // head jisko point kr raha h it bhi use point kare
			while(it != null) {
				System.out.print(it.data +"--> ");
				it = it.next; // it jisko point kr raha h uske next ko as data it me copy kr le
			}
		}
		System.out.println();
	}*/

	public String toString() {
		String str = "";
		if(this.head == null) {
			str =str + "linklist is emapty";
			
		}
		else {
			Node it = head; // head jisko point kr raha h it bhi use point kare
			while(it != null) {
				str =str + it.data +"--> ";
				it = it.next; // it jisko point kr raha h uske next ko as data it me copy kr le
			}
		}
		str =str +"\n";
		return str;
	}
}
