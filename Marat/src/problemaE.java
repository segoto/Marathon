import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class problemaE {
	static class Comparador implements Comparator<int[]>{

		 //mayor = 1
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2] < o2[2]){
				return -1;
			}
			else{
				return 1;
			}
		}
	}
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < n; ++i) {
				int k = 2*Integer.parseInt(br.readLine());
				ArrayList<int[]> costos = new ArrayList<>();
				int grafo[][] = new int[k][k];
				for(int j = 0; j < k-1; ++j) {
					String s[] = br.readLine().split(" ");
					int[] edge = new int[3];
					
					edge[0] = Integer.parseInt(s[0]);
					edge[1] = Integer.parseInt(s[1]);
					edge[2] = Integer.parseInt(s[2]);
					costos.add(edge);
					grafo[edge[0]-1][edge[1]-1] = edge[2];
					grafo[edge[1]-1][edge[0]-1] = edge[2];
				}
				Set<Integer> conjunto = new HashSet<>();
				Comparator nuevo = new Comparador();
				costos.sort(nuevo);
				int G = 0 ;
				for(int j = 0 ; j < costos.size();++j) {
					int[] hola = costos.get(j);
					G+=hola[2];
					conjunto.add(hola[0]);
					conjunto.add(hola[1]);
					if(conjunto.size()==k) {
						break;
					}
				}
				for(int j = 0 ; j < k; ++j) {
					int costo[] = new int[k];
					costo[0] = 0;
					boolean visitados[] = new boolean[k];
					
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void DFS(int inicio, boolean visitados[], int[][] grafo, int costo[]) {
		visitados[inicio] = true;
		for(int i = 0; i < visitados.length; ++i ) {
			if(grafo[inicio][i]!=0 && !visitados[i]) {
				costo[i] = costo[i-1]+grafo[inicio][i];
				DFS(i,visitados, grafo,costo);
			}
		}
	}
}
