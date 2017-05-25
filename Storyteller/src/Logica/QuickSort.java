package Logica;

public class QuickSort {
	private int i;
	private int j;
	private int Pivote;
	
	public QuickSort()
	{
		i = 0;
		j = 0;
		Pivote = 0;
	}
	
	
	public void OrdenarQuicksort(int[] Vector, int Primero, int Ultimo)
	{
		i = Primero; 
		j = Ultimo;
		Pivote = Vector[(Primero + Ultimo) / 2];
		int Auxiliar;
		do
		{
			while(Vector[i] < Pivote) i++; 
			while(Vector[j] > Pivote) j--;
			if (i <= j)
			{
				Auxiliar = Vector[j];
				Vector[j] = Vector[i];
				Vector[i] = Auxiliar;
				i++;
				j--;
			}
		} 
		while (i <= j);
		if(Primero < j) OrdenarQuicksort(Vector, Primero, j);
		if(Ultimo > i) OrdenarQuicksort(Vector, i, Ultimo);
	}
}
