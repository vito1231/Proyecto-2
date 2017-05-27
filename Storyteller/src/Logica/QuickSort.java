package Logica;

import java.util.ArrayList;

public class QuickSort {
	
	@SuppressWarnings("unused")
	private void OQuickSort(ArrayList<String> Lista, int Primero, int Ultimo)
	{
		int i = Primero;
	    int j = Ultimo;
	    if (j - i >= 1)
	    {
	    	String pivot = Lista.get(i);
	    	while (j > i)
	    	{
	    		while (Lista.get(i).compareTo(pivot) <= 0 && i < Ultimo && j > i){
	    			i++;
	            }
	    		while (Lista.get(j).compareTo(pivot) >= 0 && j > Primero && j >= i){
	    			j--;
	            }
	            if (j > i){
	            	Swap(Lista, i, j);
	            }
	            OQuickSort(Lista, Primero, j - 1);
	            OQuickSort(Lista, j + 1, Ultimo);
	    	}
	    }
	}
	
	
	private void Swap(ArrayList<String> Lista, int i, int j)
	{
		String Aux = Lista.get(i);
	    Lista.set(i, Lista.get(j));
	    Lista.set(j,Aux);
	}
}
