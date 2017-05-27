package HashTable;

import java.io.Serializable;

public class Entry implements Serializable{
    private String key;
    private Byte[] value;





	public Entry(String nombre, Byte[] arbol) {
		key=nombre;
		value=arbol;
	}





	public String getKey() {
          return key;
    }

    public Byte[] getValue() {
          return value;
    }

	@Override
	public String toString() {
		return "HashEntry [key=" + key + ", value=" + value + "]";
	}
   
}