import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

	private int head;
	private int elements;
	private E[] ring;
	
	//Default constructor to initialise variables
	
	public CircularArrayRing() {
		
		ring = (E[]) new Object[10];
		head = 0;
	}

	//Constructor which takes size of ring as an argument
	
	public CircularArrayRing(int size) {
		
		ring = (E[]) new Object[size];
		head = 0;
	}
	
	//Method to add elements to the ring
	
	public boolean add(E e) {
		
		ring[head] = e;
		head++;
		
		if(head == ring.length) {
			
			head = 0;
		}
	
		if(elements < ring.length) {
			
			elements++;
		}
	
		return false;
	}
	
	
	public Iterator<E> iterator() {
		
		return new RingIterator();
	}
	
	//Method to return size of the ring
	
	public int size() {
		
		return elements;
	}
	
	//Method that gets the last variable added
	//Throws an exception if the index is: larger than number of elements, larger than ring size or less than 0
	
	public E get(int index) throws IndexOutOfBoundsException {
		
		int indexToGet = (head -1 -index);
		
		if(index > elements -1 || index > ring.length -1 || index < 0) {
			
			throw new IndexOutOfBoundsException();
		}
		
		else {
			if(indexToGet < 0) {
				indexToGet = ring.length + indexToGet;
			}
		}
	
		return ring[indexToGet];
	}


	//Nested class
	
	private class RingIterator implements Iterator<E> {
		
		private int currentIndex = 0;
		
		
		//Method to determine currentIndex is less than elements to decipher whether there is a next element in the ring
		
		public boolean hasNext() {
			
			if(currentIndex < elements) {
				
				return true;
			}
		
			else {
				
				return false;
			}
		}
		
		
		//Method to determine the next element in the ring
		//Throws a NoSuchElementException if currentIndex is larger than ring length
		
		public E next() {
			
			if(currentIndex > ring.length - 1) {
				
				throw new NoSuchElementException();
			}
	
			if(currentIndex < head) {
				
				return (E) ring[head - 1 - currentIndex++];
			}
			
			else {
				
				return (E) ring[ring.length + head - 1 - currentIndex++];
		    }
		
		}
		
		//Remove method that throws an UnsupportedOperationException
		
		public void remove() throws UnsupportedOperationException {
			
			throw new UnsupportedOperationException();
			
		}
		
	}
	
}	

	
		
		
	
