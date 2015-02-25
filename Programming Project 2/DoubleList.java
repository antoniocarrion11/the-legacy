import java.util.*;


public class DoubleList<T> implements ListADT<T>{
    
    protected DoubleNode head;
    protected DoubleNode tail;
    protected DoubleNode current;
    
    //Constructor
    public DoubleList(){
        
        head = null;
        tail = null;
        current = head;
    }
    
    /**  
     * Removes and returns the first element from this list. 
     * 
     * @return the first element from this list
     */
    public T removeFirst(){
        T temp;
        
        //Setting Current Reference to Front node
        current = head;
        
        //Setting new front
        head = head.getNext();
        
        //Saving element and cutting off all ties to node
        temp = current.getObject();
        head.setPrev(null);
        current = head;
        
        return temp;
    }
    
    /**  
     * Removes and returns the last element from this list. 
     *
     * @return the last element from this list
     */
    public T removeLast(){
        T temp;
        
        //Setting Current Reference to tail node
        current = tail;
        
        //Setting new tail
        tail = tail.getPrev();
        
        //Saving element and cutting off all ties to node
        temp = current.getObject();
        tail.setNext(null);
        current = tail;
        
        return temp;
    }
    
    /**  
     * Removes and returns the specified element from this list. 
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element){
    
    //Return element if it is located in the first node
        if(head.getObject().equals(element)){
            head = head.getNext();
            head.setPrev(null);
            
            return element;
        }
      
        else{
            //Set current to the second node
            current = head.getNext();
            
            //Search the list for element
            while(current.getNext() != null){
            
                current = current.getNext(); 
                if(current.equals(element)){
                    //delete references to thst node
                    current.getNext().setPrev(null);
                    current.getPrev().setNext(null);
                    
                    return element;
                }
            }
        }
        
        return null;
    }
    
    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     */
    public T first(){
       return head.getObject();
    }
    
    /**  
     * Returns a reference to the last element in this list. 
     *
     * @return a reference to the last element in this list
     */
    public T last(){
        return tail.getObject();
    }
    
    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target){  
    //Search the list for element
        while(current != null){
            if(current.equals(target)){
                return true;
            }
            
            else{
                current = current.getNext();
            }
        }
        return false;
     }

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty(){
        //
        if(head == null)
            return true;
        else
            return false;
    }
    
    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    public int size(){
        int count = 0;
        current = head;
        
        if(current == null)
            return count;
            
        while(!(current.getNext().equals(null))){
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    /**  
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements in this list
     */
    public Iterator<T> iterator(){
        
        DoubleIterator it = new DoubleIterator(head);
        return it;
    }
    
    //Inner class DoubleNode used to store Objects
    protected class DoubleNode{
         
         //References to nodes previous and next, and element in node
         private DoubleNode prev;
         private DoubleNode next;
         private T object;
         
         public DoubleNode(T object){
            prev = null;
            next = null;
            this.object = object;
         }
         
         //Get references to Nodes and Object
         public DoubleNode getPrev(){
            return prev;
         }
         
         public DoubleNode getNext(){
            return next;
         }
         
         public T getObject(){
            return object;
         }
         
         //Change Fields
         public void setPrev(DoubleNode prev){
            this.prev = prev;
         }
         
         public void setNext(DoubleNode next){
            this.next = next;
         }
         
         public void setObject(T object){
            this.object = object;
         }
         
    }
    
    //InnerClass DoubleIterator
    public class DoubleIterator implements Iterator<T>{
    
    private DoubleNode current;
    
    public DoubleIterator(DoubleNode head){
        
        current = head;
    }
    
    //Returns true if iteration has more methods
    public boolean hasNext(){
        
        if(current.getNext().equals(null))
            return false;
        else
            return true;
    }
    
    //Returns the current element while setting current to the next node
    public T next(){
        T temp = current.getObject();
        current = current.getNext();
        return temp;
    }
    
    //function not supported
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    
}

}