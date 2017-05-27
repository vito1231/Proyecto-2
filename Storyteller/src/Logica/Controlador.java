package Logica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import HashTable.ParOrdenado;

public class Controlador {

	public Controlador(){
		
	}
	public void salvar(ParOrdenado table){
		Serializacion<ParOrdenado> se= new Serializacion<ParOrdenado>();
		byte[] bytes = se.serializar(table);
		
		
		FileOutputStream fileOutput = null;
		try {
			fileOutput = new FileOutputStream ("ParOrdenado.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
        try
        {
            bufferedOutput.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
        	   bufferedOutput.close();
        	   
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
	}
	
	
	
	public ParOrdenado cargar(){
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream("ParOrdenado.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}
		BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
	     byte[] bytes;
		try {
	    	 bytes = new byte[100000000];
	    	 bufferedInput.read(bytes);
	     }
	     catch(Exception e){
	         e.printStackTrace();
	         return null;
	     }finally{
	              try {
					bufferedInput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           }
		Serializacion<ParOrdenado> se= new Serializacion<ParOrdenado>();
		ParOrdenado table= (ParOrdenado) se.deserializar(bytes);
		return table;
	}
}
