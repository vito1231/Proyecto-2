package HashTable;

public class Entry {
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