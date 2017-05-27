package HashTable;

public class HashEntry {
    private String key;
    private Byte[] value;


    public HashEntry(String key, Byte[] value) {
          this.key = key;
          this.value = value;
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