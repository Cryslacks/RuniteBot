// 
// Decompiled by Procyon v0.5.36
// 

public class Deque
{
    public Node head;
    Node current;
    
    public Deque() {
        this.head = new Node();
        this.head.next = this.head;
        this.head.previous = this.head;
    }
    
    public void clear() {
        while (true) {
            final Node node_0 = this.head.next;
            if (node_0 == this.head) {
                break;
            }
            node_0.unlink();
        }
        this.current = null;
    }
    
    public void addFront(final Node node_0) {
        if (node_0.previous != null) {
            node_0.unlink();
        }
        node_0.previous = this.head.previous;
        node_0.next = this.head;
        node_0.previous.next = node_0;
        node_0.next.previous = node_0;
    }
    
    public void addTail(final Node node_0) {
        if (node_0.previous != null) {
            node_0.unlink();
        }
        node_0.previous = this.head;
        node_0.next = this.head.next;
        node_0.previous.next = node_0;
        node_0.next.previous = node_0;
    }
    
    public Node popFront() {
        final Node node_0 = this.head.next;
        if (node_0 == this.head) {
            return null;
        }
        node_0.unlink();
        return node_0;
    }
    
    public Node popTail() {
        final Node node_0 = this.head.previous;
        if (node_0 == this.head) {
            return null;
        }
        node_0.unlink();
        return node_0;
    }
    
    public Node getFront() {
        final Node node_0 = this.head.next;
        if (node_0 == this.head) {
            return this.current = null;
        }
        this.current = node_0.next;
        return node_0;
    }
    
    public Node getTail() {
        final Node node_0 = this.head.previous;
        if (node_0 == this.head) {
            return this.current = null;
        }
        this.current = node_0.previous;
        return node_0;
    }
    
    public Node getNext() {    	
    	try{
    		final Node node_0 = this.current;
    	
	        if (node_0 == this.head) {
	            return this.current = null;
	        }
	        this.current = node_0.next;
	        return node_0;
	        
    	}catch(NullPointerException e){
    		return null;
    	}
    }
    
    public Node getPrevious() {
        final Node node_0 = this.current;
        if (node_0 == this.head) {
            return this.current = null;
        }
        this.current = node_0.previous;
        return node_0;
    }
    
    public static void method4075(final Node node_0, final Node node_1) {
        if (node_0.previous != null) {
            node_0.unlink();
        }
        node_0.previous = node_1.previous;
        node_0.next = node_1;
        node_0.previous.next = node_0;
        node_0.next.previous = node_0;
    }
}
