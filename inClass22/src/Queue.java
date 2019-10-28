/*
Name: Yunlu Li
Computing ID: yl4df

*/


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		// TODO: Complete this method to implement the add() method for a Queue
        growIfNecessary();
        elements[tail]=s;
        tail=(tail+1)%elements.length;
        currentSize++;
        
	}
	
	public String remove(){
		// TODO: Complete this method to implement the remove() method for a Queue
        if(currentSize==0) {
            return null;
        }
        String item = elements[head];
        head=(head+1)%elements.length;
        currentSize--;
        return item;
	}
	
	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
        Queue q = new Queue();
        q.add("a");
        q.add("b");
        q.add("c");
        q.add("d");
        q.add("e");
        q.add("f");
        q.add("g");
        q.add("h");
        q.add("i");
        q.add("j");
        q.add("k");
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add("l");
        q.add("m");
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        
        

	}

}
