/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularLinkedList;

import java.util.ListIterator;

/**
 *
 * @author Stefany Farias
 */
public interface List<E> extends Iterable<E> {
    public boolean addFirst(E element);
    public boolean addLast(E element);
    public boolean add(int index, E element);
    public E remove (int index);
    public E get (int index);
    public E set(int index, E element);
    public int size();
    public boolean isEmpty();
    public void clear();
    public E removeFirst(); 
    public E removeLast();
    
    
}
