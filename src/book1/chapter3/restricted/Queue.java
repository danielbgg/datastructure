package book1.chapter3.restricted;

public class Queue {
	private Listing[] data;
	private int size;
	private int numOfNodes;
	private int front;
	private int rear;

	public Queue() {
		size = 100;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data = new Listing[100];
	}

	public Queue(int n) {
		size = n;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data = new Listing[n];
	}

	public boolean enque(Listing newNode) {
		if (numOfNodes == size)
			return false; // ** overflow error **
		else {
			numOfNodes = numOfNodes + 1;
			data[rear] = newNode.deepCopy();
			rear = (rear + 1) % size;
			return true; // push operation successful
		}
	}

	public Listing deque() {
		int frontLocation;
		if (numOfNodes == 0)
			return null; // ** underflow error **
		else {
			frontLocation = front;
			front = (front + 1) % size;
			numOfNodes = numOfNodes - 1;
			return data[frontLocation];
		}
	}

	public void showAll() {
		int i = front;
		for (int c = 1; c <= numOfNodes; c++) {
			System.out.println(data[i].toString());
			i = (i + 1) % size;
		}
	}
}
