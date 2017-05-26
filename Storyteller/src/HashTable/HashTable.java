package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

import Arboles.*;

public class HashTable {
	private final int TABLE_SIZE = 13;
	 
    HashEntry[] table;

    public HashTable() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public Byte[] get(String key) {
          int hash = (Math.abs(key.hashCode()) % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                return null;
          else
                return table[hash].getValue();
    }

    public void put(String key, Byte[] value) {
          int hash = (Math.abs(key.hashCode()) % TABLE_SIZE);
          while (table[hash] != null && table[hash].getKey() != key)
                hash = (hash + 1) % TABLE_SIZE;
          table[hash] = new HashEntry(key, value);
    }

    
@Override
	public String toString() {
		return "HashTable [table=" + Arrays.toString(table) + "]";
	}

}
