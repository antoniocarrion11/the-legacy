
public class DoubleIterator implements Iterator<T>{
    
    private DoubleNode current;
    
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
    
    public T remove() throws UnsupportedOperationException{
        throw UnsupportedOperationException();
    }
    
}