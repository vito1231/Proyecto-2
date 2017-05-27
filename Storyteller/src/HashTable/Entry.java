package HashTable;

import java.io.Serializable;

public class Entry implements Serializable{
    private String key;
    private byte[] value;

	public Entry(String nombre, byte[] arbol) {
		key=nombre;
		value=arbol;
	}


	public String getKey() {
          return key;
    }

    public byte[] getValue() {
          return value;
    }

	@Override
	public String toString() {
		return "HashEntry [key=" + key + ", value=" + value + "]";
	}
   
}