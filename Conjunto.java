/*<p> Clase que modela conjuntos </p> <p>Esta clase sirve para crear
 * conjuntos y hacer operaciones entre ellos</p>
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 * @version 1.0
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
public class Conjunto <T> implements Iterable, Conjuntable<T> {
    
 /* Arreglo donde guardaremos los elementos de un conjunto */
    private T[] conjunto;
    /* Número de elementos que tiene el conjunto*/
    private int elementos;

    private class IteradorConjunto implements Iterator {
        /* Variable para contar cuantos elementos hay en el conjunto
        no debe tener repeticiones, ni espacios en blanco para que funcione */
       int contador;
       public IteradorConjunto(){
           contador  = -1;
       }
    
       public boolean hasNext(){
           //Aqui va tu codigo.
    	  return contador<elementos-1;
       }
    
       public Object next(){
           //Aqui va tu codigo.
    	   if(hasNext()){
    		contador+=1;
    	   	return conjunto[contador];
    	   }
    	   else{
    		   return null;
    		   }
       }
    }
    
    public Conjunto(Conjunto<T> c){ 
        conjunto =(T[]) new Object[c.cardinalidad()];
        Iterator i = c.iterator();
        int j=0;
        while(i.hasNext()){
            conjunto[j]=(T)i.next();
            j+=1;
           }
        this.elementos = c.elementos;
        this.conjunto = conjunto;
        }
    
    public Conjunto(){
        elementos = 0;
        Object[] conjuntoTem = new Object[1];
        conjunto = (T[])conjuntoTem;
        
    }
    public Conjunto(T[] elementos){
    	this.conjunto = elementos;
    	this.elementos = elementos.length;
    }
    
    /**
     * Método que nos dice si el conjunto está vacío.
     * @return <code>true</code> si el conjunto está vacío, <code>false</code>
     * en otro caso.
     */
    public boolean esVacio(){
        if(elementos == 0){
        return true;
    }
    return false;
    }
    
    /**
     * Método para obtener el tamaño de un conjunto
     * @return número de elementos en el conjunto
     */
    public int cardinalidad(){
        return elementos;
    }
    
    
    /**
     * Método para eliminar todos los elementos de un conjunto
     */
    public void vaciar(){
    elementos = 0;
    Object[] conjuntoTem = new Object[conjunto.length];
        conjunto = (T[])conjuntoTem;
    }
    
    
    /**
     * Método para agregar un elemento al conjunto
     * @param elemento Objeto que se incorporara al conjunto
     */
    public void agregar(T elemento){
    	Iterator i = this.iterator();
    	boolean repetido = this.contiene(elemento);
            if(!repetido){
                if(elementos>=conjunto.length){
                Object[] conjuntoTem = new Object[conjunto.length*2];
                    for(int j = 0; j<elementos;j+=1){
                        conjuntoTem[j] = conjunto[j];
                        }
                    conjuntoTem[elementos]= elemento;
                    conjunto = (T[])conjuntoTem;
                    }
                conjunto[elementos]=elemento;
                elementos +=1;
                
            }
        }
        
    
    
    /**
     * Método para eliminar un <code>elemento</code> del conjunto
     * @param elemento Objeto que se eliminara del conjunto
     */
    @Override
    public void eliminar(T elemento){
        Boolean esta = this.contiene(elemento);
        if(esta){
        	int indice =0;
        	for(int i=0; i<this.cardinalidad();i++){
                if(conjunto[i]==elemento){
                    indice = i;
                    break;
                }
            }
            Object[] conjuntoTem = new Object[conjunto.length];
            for(int j = 0; j< indice;j+=1){
                conjuntoTem[j] = conjunto[j];
            }
            for(int j =indice+1; j<elementos;j++){
                conjuntoTem[j-1]=conjunto[j];
            }
            conjunto = (T[])conjuntoTem;        
        }
    }       
           
    /**
     * Método para ver si un elemento pertenece al conjunto
     * @param elemento Objeto que se va a buscar en el conjunto
     * @return <code>true</code> si el elemento esta en el conjunto,
     * <code>false</code> en otro caso.
     */
    @Override
    public boolean contiene(T elemento){
        boolean indice = false;
        Iterator i = this.iterator();
        while(i.hasNext()) {
        	if(i.next()==elemento) {
        		indice =true;
        	}
        }
        return indice;
    }
    
    /**
     * Método para calcular la union de dos conjuntos
     * @param c1 conjunto con el que se calculará la unión
     * @return Conjuntable conjunto que contiene la unión
     */
    @Override
    public Conjuntable union(Conjuntable c){
    	Conjunto conUni = new Conjunto(this);
    	Iterator i = c.iterator();
    	while(i.hasNext()){
    		conUni.agregar(i.next());
    	}
        return conUni;
    }

    /**
     * Método para calcular la intersección de dos conjuntos
     * @param c conjunto con el que se calculará la intersección.
     * @return Conjuntable que con tiene la intersección.
     */
    //@Override
    public Conjuntable interseccion(Conjuntable c){
    	Conjunto inter = new Conjunto(this);
    	Iterator i = iterator();
    	while(i.hasNext()) {
    		T elemento = (T)i.next();
    		if(!c.contiene(elemento)) {
    			inter.eliminar(elemento);
    		}
    	}
        return inter;
    }

    /**
     * Método para calcular la diferencia de dos conjuntos
     * @param c conjunto con el que se va a calcular la diferencia
     * @return Conjuntable con la diferencia
     */
    @Override
    public Conjuntable diferencia(Conjuntable c){
        Conjunto dif = new Conjunto(this);
        Iterator i = iterator();
        
    	while(i.hasNext()) {
    		T elemento = (T)i.next();
    		if(c.contiene(elemento)) {
    			dif.eliminar(elemento);
    		}
    	}
    	return dif;
    }

    /**
     * Método para calcular la diferencia simétrica de dos conjuntos
     * @param c conjunto con el que se va a calcular la diferencia simétrica
     * @return Conjuntable con la diferencia simétrica
     */
    public Conjuntable diferenciaSimetrica(Conjuntable c){
    Conjunto dif1 = (Conjunto)c.diferencia(this);
    Conjunto dif2 = (Conjunto)this.diferencia(c);
    return dif1.union(dif2);
    }
    
    
    /**
     * Método para determinar si un conjunto esta contenido en otro
     * @param c conjunto en se va a probar si el que llama es subconjunto
     * @return boolean true si el conjunto que llama a este metodo es 
     *         subconjunto del parametro y false en otro caso
     */
    @Override
    public boolean subconjunto(Conjuntable c){
        //Aqui va tu codigo.
    	Iterator i = c.iterator();
    	while(i.hasNext()){
    		if(!c.contiene(i.next())) {
    			return false;
    		}
    	}
    	return true;
    }

    @Override
    public String toString(){
    	Iterator i = this.iterator();
    	String conjunto = "";
    	while(i.hasNext()) {
    		conjunto += i.next();
    	}
        return conjunto;

    }
    
    /**
     * Método para crear un iterador sobre un conjunto
     * @return Iterator iterador sobre el conjunto.
     */
    @Override
    public java.util.Iterator iterator(){
        IteradorConjunto i = new IteradorConjunto();
        
        return i;
    }

   

}