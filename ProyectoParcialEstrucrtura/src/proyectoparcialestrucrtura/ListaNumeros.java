/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestrucrtura;

import CircularLinkedList.CircularLinkedList;
import CircularLinkedList.NodeList;

/**
 *
 * @author HP
 */
public class ListaNumeros {
    private CircularLinkedList<Numero> numbers;
    
    public ListaNumeros(CircularLinkedList<Numero> ns){
        this.numbers = ns;
    }
    
    public static int sumaNumeros(CircularLinkedList<Numero> ns){
        int total=0;
        NodeList<Numero> tmp;
        int i = 1;
        for (tmp= ns.getLast().getNext();i<=ns.getEffectiveSize(); tmp = tmp.getNext()) {
                int n = tmp.getContent().getNumero();
                total = total + n;
                i++;
        }
        return total;
    }
     
     
     public static void dobleEliminacion(CircularLinkedList<Numero> l1,CircularLinkedList<Numero> l2,int index){
         l1.remove(index);
         l2.remove(index);
     }
    
    public boolean agregarParticipante(Numero num){
        if(num!=null){
            numbers.addLast(num);
            return true;
        }else{
            return false;
        }
    }
    
}
