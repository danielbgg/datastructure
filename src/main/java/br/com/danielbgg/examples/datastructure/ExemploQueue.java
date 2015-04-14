package br.com.danielbgg.examples.datastructure;

class StateNode {
	int xPos;
	int yPos;
	int moveCount;
}

class ExemploQueue {
	StateNode[] queueData = new StateNode[2500];
	int queueFront = 0;
	int queueBack = 0;

	void Enqueue(StateNode node) {
		queueData[queueBack] = node;
		queueBack++;
	}

	StateNode Dequeue() {
		StateNode returnValue = null;
		if (queueBack > queueFront) {
			returnValue = queueData[queueFront];
			queueFront++;
		}
		return returnValue;
	}

	boolean isNotEmpty() {
		return (queueBack > queueFront);
	}

	public static void main(String[] args) {
	}
}
