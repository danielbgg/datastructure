package book.dsauj.chapter3.restricted;

public class MainStack {
	public static void main(String[] args) {
		Stack s = new Stack(3);
		Listing l;
		Listing l1 = new Listing("Bill", "1st Avenue", "123 4567");
		Listing l2 = new Listing("Al", "2nd Avenue", "456 3232");
		Listing l3 = new Listing("Mike", "3rd Avenue", "333 3333");
		Listing l4 = new Listing("Carol", "4th Avenue", "444 4444");
		// an attempt to perform a pop on an initialized (empty) stack will
		// return null
		System.out.println(s.pop());
		// perform three pushes to fill the stack and then output the stack
		System.out.println(s.push(l1));
		System.out.println(s.push(l2));
		System.out.println(s.push(l3));
		s.showAll();
		// perform three pop operations to empty the stack
		l = s.pop();
		System.out.println(l.toString());
		l = s.pop();
		System.out.println(l.toString());
		l = s.pop();
		System.out.println(l.toString());
		// an attempt to perform a pop on an empty stack will return null
		l = s.pop();
		System.out.println(l);
		System.exit(0);
	}
}
