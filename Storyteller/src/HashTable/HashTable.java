package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import Arboles.*;

public class HashTable {

    private ArrayList<HashEntry> table;
    
    public HashTable() {
          table=new ArrayList<HashEntry>();
    }
    
    public void add(String nombre, Byte[] arbol){
    	HashEntry album = new HashEntry(nombre, arbol);
    	table.add(album);
    	quicksort();
    }
    
    public void quicksort(){
    	
    }

    public HashEntry busqueda_binaria(String nombre){
		return null;
    	
    }
    


}
