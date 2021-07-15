/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestructura;

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
    
    public static CircularLinkedList<Numero> moverDerecha(CircularLinkedList<Numero> ns){
       NodeList<Numero> tmp;
       CircularLinkedList<Numero> resultado = new CircularLinkedList<>();
        int i = 1;
        for (tmp= ns.getLast().getNext();i<=ns.getEffectiveSize(); tmp = tmp.getNext()) {
                tmp.getPrevious().getContent().setNumero(tmp.getPrevious().getContent().getNumero()+1);
                resultado.addLast(tmp.getPrevious().getContent());
                i++;
        }
        return resultado;
    }
     
    public static CircularLinkedList<Numero> moverIzquierda(CircularLinkedList<Numero> ns){
       NodeList<Numero> tmp;
       CircularLinkedList<Numero> resultado = new CircularLinkedList<>();
        int i = 1;
        for (tmp= ns.getLast().getNext();i<=ns.getEffectiveSize(); tmp = tmp.getNext()) {
                tmp.getNext().getContent().setNumero(tmp.getNext().getContent().getNumero()-1);
                resultado.addLast(tmp.getNext().getContent());
                i++;
        }
        return resultado;
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
