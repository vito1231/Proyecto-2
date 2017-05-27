package HashTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import Arboles.*;

public class ParOrdenado implements Serializable {

    private ArrayList<Entry> table;
    
    public ParOrdenado() {
          table=new ArrayList<Entry>();
    }
    
    public void add(String nombre, Byte[] arbol){
    	Entry album = new Entry(nombre, arbol);
    	table.add(album);
    	QuickSort(0,table.size()-1);
    }
    
	public void QuickSort(int Primero, int Ultimo)
	{
		int i = Primero;
	    int j = Ultimo;
	    if (j - i >= 1)
	    {
	    	String pivot = table.get(i).getKey();
	    	while (j > i)
	    	{
	    		while (table.get(i).getKey().compareTo(pivot) <= 0 && i < Ultimo && j > i){
	    			i++;
	            }
	    		while (table.get(j).getKey().compareTo(pivot) >= 0 && j > Primero && j >= i){
	    			j--;
	            }
	            if (j > i){
	            	Swap( i, j);
	            }
	            QuickSort(Primero, j - 1);
	            QuickSort(j + 1, Ultimo);
	    	}
	    }
	}
	private void Swap( int i, int j)
	{
		Entry Aux = table.get(i);
	    table.set(i, table.get(j));
	    table.set(j,Aux);
	}



    public Boolean busqueda_binaria(String nombre){
    	int inicio = 0;
    	 int fin = table.size() - 1;
    	 int pos;
    	 while (inicio <= fin) {
    	     pos = (inicio+fin) / 2;
    	     if ( table.get(pos).getKey() == nombre )
    	       return true;
    	     else if ( table.get(pos).getKey().compareTo(nombre) < 0 ) {
    	  inicio = pos+1;
    	     } else {
    	  fin = pos-1;
    	     }
    	 }
    	 return false;
    	    }
    	
    	
    }
    



