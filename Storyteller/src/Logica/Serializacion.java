package Logica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion<T> {
	public byte[] serializar(T objeto){
		ByteArrayOutputStream bs= new ByteArrayOutputStream();
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream (bs);
			os.writeObject(objeto);
			os.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		return bs.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public T deserializar(byte[] bytes){
		ByteArrayInputStream bs= new ByteArrayInputStream(bytes);
		ObjectInputStream is;
		T objeto = null;
		try {
			is = new ObjectInputStream(bs);
			objeto = (T)is.readObject();
			is.close();
		} catch (IOException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return objeto;
	}
}
