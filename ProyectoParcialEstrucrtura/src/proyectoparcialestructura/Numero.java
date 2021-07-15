/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcialestructura;

/**
 *
 * @author HP
 */
public class Numero {
    private int numero;
    
    public Numero(){};
    
    public Numero(int n){
        this.numero = n;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int n){
        this.numero = n;
    }

    @Override
    public String toString() {
        return  "" + numero;
    }
    
    
}
