import java.util.*;

public class DoubleOrdered<T extends Comparable<T>> extends DoubleList<T> implements OrderedListADT<T>{

    public DoubleOrdered(){
       
       super();
        
    }
    
    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
     public void add(T target){
        
        //Temporary object to compare to
        T temp;
        //Create New Node
        DoubleNode newNode = new DoubleNode(target);
        current = head;
        temp = current.getObject();
        
        //Special case for head
        if(target.compareTo(temp) == 0 || target.compareTo(temp) == 1){
            //Add node to the front of the list and make it the new Head
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        while(target.compareTo(temp) == -1){
        //Traversing through the list
            //Current is set to the next node and temp is set
            //to the next node's object
            current = current.getNext();
            temp = current.getObject();
            
            //Will check if current is at end of list
            if(current.equals(null))
                break;
        }
        //Will break out of loop and execute this line if target has found its place
        if(target.compareTo(temp) == 0 || target.compareTo(temp) == 1){
            //set newNode's references equal to the nodes next to it
            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            //Set Prev node's next reference to new node
            current.getPrev().setNext(newNode);
            //Set next node's Prev reference to new node
            current.setPrev(newNode);
        }
        
        
    }
}