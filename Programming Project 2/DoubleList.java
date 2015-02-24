import java.io.*;


public class DoubleList<T> implements ListADT<T>{
    
    private DoubleNode head;
    private DoubleNode tail;
    private DoubleNode current;
    
    //Constructor
    public DoubleList(T Object){
        
        head = new DoubleNode(Object);
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
            
        while(!(current.getNext().equals(null)){
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    
    
    //Inner class DoubleNode used to store Objects
    private class DoubleNode{
         
         private DoubleNode prev;
         private DoubleNode next;
         private T object;
         
         public DoubleNode(T object){
            prev = null;
            next = null;
            this.object = object;
         }
         
         public DoubleNode getPrev(){
            return prev;
         }
         
         public DoubleNode getNext(){
            return next;
         }
         
         public T getObject(){
            return object;
         }
         
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

}