import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue {
	

	private Integer[] array;
	private int I;
	private int head;
	private int tail;
	private int count = 0;
	
	//Default constructor to initialise the variables
	
	public CircularArrayQueue() {
		
		this.I = 10;
		array = new Integer[I];
		head = tail = 0;
	}
	
	//Constructor which takes the size of the queue as an argument
	
	public CircularArrayQueue(int size) {
		
		this.I = size;
		array = new Integer[I];
		head = tail = 0;
	}
	
	//Method to enqueue an element to the tail 
	//Calls the resize method if the queue is full
	
	public void enqueue(int in) {
		count++;
		if(isFull()) {
			
			resize();
			tail = (tail+1) % I;
		array[tail] = in;
	}
		else {
			tail = (tail+1) % I;
			array[tail] = in;
		}
	}
	
	//Method to dequeue from the head
	//If the queue is empty a NoSuchElementException is thrown
	
	public int dequeue() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		
		head = (head + 1) % I;
		int headElement = array[head];
		count--;
		return headElement;
	  }
	
	//Returns how many free spaces in the queue is available	
	
	public int getCapacityLeft() {
		
		return I - 1 - count;
		
	}
	
	//Method that doubles the size of the array
	
	private void resize() {
		
		Integer[] temp = new Integer[array.length*2];
		I = array.length*2;
		for(int i=0 ; i<array.length; i++) {
			
			temp[i] = array[i];
		}
		
		array = temp;
	}
	

	//Method to determine whether the queue is empty
	
	public boolean isEmpty() {
		
		return head == tail;
	}
	
	//Method to determine whether the queue is full
	
	public boolean isFull() {
		
		return head == ((tail+1) % I);
	}

	//Calculates the number of items currently in the queue
	//Count is used to keep track of items
	
	public int noItems() {
	 
		return count;
	}

}


