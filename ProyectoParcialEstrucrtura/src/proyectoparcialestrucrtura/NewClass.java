/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestrucrtura;

import CircularLinkedList.CircularLinkedList;
import static proyectoparcialestrucrtura.ListaNumeros.*;

/**
 *
 * @author HP
 */
public class NewClass {
    public static void main(String[] args){
        CircularLinkedList<Numero> prueba =  new CircularLinkedList<>();
        prueba.addLast(new Numero(2));
        prueba.addLast(new Numero(3));
        prueba.addLast(new Numero(4));
        prueba.addLast(new Numero(5));
        System.out.println(prueba);
       
        System.out.println(moverDerecha(prueba));
        System.out.println(moverIzquierda(prueba));
        
    }
}
