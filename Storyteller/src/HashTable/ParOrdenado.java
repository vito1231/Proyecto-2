package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import Arboles.*;

public class ParOrdenado {

    private ArrayList<Entry> table;
    
    public ParOrdenado() {
          table=new ArrayList<Entry>();
    }
    
    public void add(String nombre, Byte[] arbol){
    	Entry album = new Entry(nombre, arbol);
    	table.add(album);
    	quicksort();
    }
    
    public void quicksort(){
    	
    }

    public Entry busqueda_binaria(String nombre){
		return null;
    	
    }
    


}
