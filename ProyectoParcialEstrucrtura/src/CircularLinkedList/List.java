/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularLinkedList;

/**
 *
 * @author Stefany Farias
 */
public interface List<E> extends Iterable<E> {
    public boolean addFirst(E element);
    public boolean addFiLast(E element);
    public boolean add(int index, E element);
    public E remove (int index);
    public E get (int index);
    public E set(int index, E element);
    public int size();
    public boolean isEmpty();
    public void clear();
    public E removeFirst(); // remueve el elemento al inicio de la lista
    public E removeLast(); // remueve el elemento al final de la lista 
    @Override
    public String toString();
    public NodeList getPrevios (NodeList p);
}
