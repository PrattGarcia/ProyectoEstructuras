/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Estefany Farias
 */
public class CircularLinkedList<E> implements List<E> {

    private NodeList<E> last;
    private int effectiveSize;

    public CircularLinkedList() {
        this.last = null;
        effectiveSize = 0;
    }

    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    public int getEffectiveSize() {
        return effectiveSize;
    }

    public void setEffectiveSize(int effectiveSize) {
        this.effectiveSize = effectiveSize;
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }

        NodeList<E> nuevo = new NodeList(element);
        if (isEmpty()) {
            this.last = nuevo;
            nuevo.setNext(nuevo);
            nuevo.setPrevious(nuevo);
        } else {
            nuevo.setNext(last.getNext());
            nuevo.setPrevious(last);
            last.getNext().setPrevious(nuevo);
            last.setNext(nuevo);
        }
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }

        if (isEmpty()) {
            addFirst(element);
            return true;
        } else {

            NodeList<E> nuevo = new NodeList(element);

            nuevo.setPrevious(last);
            nuevo.setNext(last.getNext());
            last.getNext().setPrevious(nuevo);
            last.setNext(nuevo);
            setLast(nuevo);
            effectiveSize++;
            return true;
        }
    }

    @Override
    public boolean add(int index, E element) {
        if (element != null) {
            if (index >= 0 && index <= effectiveSize) {
                if (index == 0) {
                    addFirst(element);
                } else if (index == effectiveSize) {
                    addLast(element);
                } else {
                    NodeList<E> nuevo = new NodeList(element);
                    NodeList<E> tmp = last.getNext();
                    int count = 0;
                    while (count < index - 1) {
                        tmp = tmp.getNext();
                        count++;
                    }
                    nuevo.setNext(tmp.getNext());
                    nuevo.setPrevious(tmp);
                    tmp.getNext().setPrevious(nuevo);
                    tmp.setNext(nuevo);
                    effectiveSize++;
                }
            } else {
                System.out.println("Error");
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            throw new IndexOutOfBoundsException();
        } else {
            NodeList<E> tmp = last.getNext();
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            return tmp.getContent();
        }
    }

    @Override
    public E set(int index, E element) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {

            NodeList<E> retorno = last;
            retorno.getNext().setPrevious(retorno.getPrevious());
            retorno.getPrevious().setNext(retorno.getNext());
            retorno.setNext(null);
            if (effectiveSize == 1) {
                setLast(null);
            } else {
                setLast(last.getPrevious());
            }
            retorno.setPrevious(null);
            effectiveSize--;
            return retorno.getContent();
        }
    }

    @Override
    public int size() {
        return effectiveSize;

    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        NodeList<E> nodo = last.getNext();
        for (int cont = 0; cont < effectiveSize; cont++) {
            NodeList<E> next = nodo.getNext();
            nodo.setContent(null);
            nodo.setNext(null);
            nodo.setPrevious(null);
            nodo = next;
        }
        effectiveSize = 0;
    }

    @Override
    public E remove(int index) {
        if(index > effectiveSize-1 || index < 0){//Tambien manda una excepticion cuando está vacio
            throw new IndexOutOfBoundsException();
        }if(isEmpty()){
            throw new NoSuchElementException();
        }else if(index==0){
            return removeFirst();
        }else if(index==effectiveSize-1){
            return removeLast();
        }
        else{
            
            NodeList<E> retorno = last.getNext();
            int count=0;
            while(count < index){
                retorno = retorno.getNext();
                count++;
            }
            
            retorno.getNext().setPrevious(retorno.getPrevious());
            retorno.getPrevious().setNext(retorno.getNext());
            retorno.setNext(null); 
            retorno.setPrevious(null);
            effectiveSize--;
            return retorno.getContent();
        }
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            
            NodeList<E> retorno = last.getNext();
            last.setNext(retorno.getNext());
            retorno.getNext().setPrevious(last);
            retorno.setNext(null); 
            retorno.setPrevious(null);
            if(effectiveSize==1){
                setLast(null);
            }
            effectiveSize--;
            return retorno.getContent();
        }
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            
            NodeList<E> retorno = last;
            retorno.getNext().setPrevious(retorno.getPrevious());
            retorno.getPrevious().setNext(retorno.getNext());
            retorno.setNext(null);
            if(effectiveSize==1){
                setLast(null);
            }else{
                setLast(last.getPrevious());
            }
            retorno.setPrevious(null);
            effectiveSize--;
            return retorno.getContent();
        }
    }
    
    @Override
    public String toString(){
        String result="{";
        if(!isEmpty()){
            NodeList<E> tmp = last.getNext();
            for( int n=0; n<effectiveSize; n++){
                if(tmp==last){
                    result += tmp.getContent().toString();
                }else{
                    result += tmp.getContent().toString() + ",";
                }
                tmp = tmp.getNext();
            }
        }
        result +="}"; 
        return result;
    }

    @Override
    public Iterator<E> iterator() {
		return new Iterator<E>() {
            NodeList<E> next = last.getNext();
            NodeList<E> lastReturned = null;
            @Override
            public boolean hasNext() {
                return  effectiveSize!=0;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    return null;
                }else{
                    lastReturned = next;
                    next = next.getNext();
                    return lastReturned.getContent();
                }

            }
            
            @Override
            public void remove(){
                if(isEmpty() || lastReturned==null){
                    throw new NoSuchElementException();
                }
                lastReturned.getNext().setPrevious(lastReturned.getPrevious());
                lastReturned.setNext(null); 
                lastReturned = lastReturned.getPrevious();
                lastReturned.getNext().setPrevious(null);
                lastReturned.setNext(next);
                if(lastReturned==last){
                    setLast(last.getPrevious());
                }else if(effectiveSize==1){
                    setLast(null);
                }
                effectiveSize--;
            }
            
        };
           
    }
}
