import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class UVA12189 {
	static class Comparador implements Comparator<int[]>{

		 //mayor = 1
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0] < o2[0]){
				return -1;
			}
			else if(o1[0] == o2[0]){
				if(o1[1] < o2[1])
					return -1;
				else if (o1[1] > o2[1])
					return 1;
				else{
					if(o1[2]<o2[2]){
						return -1;
					}
					else{
						return 1;
					}
				}
			}
			else{
				return 1;
			}
		}
		
	}
	public static void main(String[] args) {
		try (BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))) {
			String s = br.readLine();
			while(!s.equals("0")){
				int cases = Integer.parseInt(s);
				HashMap<int[], String> hash = new HashMap<>();
				ArrayList<int[]> hora = new ArrayList();
				int eReal = 0;
				int xReal = 0;
				for( int i = 0; i< cases; ++i ) {
					String[] line = br.readLine().split(" ");
					int[] agregar = new int[3];
					if(line[1].equals("E"))
						++eReal;
					else if(line[1].equals("X"))
						++xReal;
					String c[] = line[0].split(":");
					for(int j = 0 ; j<3 ; ++j){
						agregar[j] = Integer.parseInt(c[j]);
					}
					hash.put(agregar, line[1]);
					hora.add(agregar);
				}
				Comparador t= new Comparador();
				hora.sort(t);
				String[] a = new String[cases];
				for(int i = 0 ; i< cases; ++i){
					a[i] = hash.get(hora.get(i));
				}
				int xDebe = cases/2;
				for(int j = cases-1; j>=0 ; --j){
					if(a[j].equals("?")&& xReal != xDebe){
						++xReal;
						a[j] = "X";
					}
					else if(a[j].equals("?")&& xReal == xDebe){
						++eReal;
						a[j] = "E";
					}
				}
				int respuesta = 0;
				int temp = 0;
				for(int j = 0; j < cases; ++j){				
					if(a[j].equals("E"))
						++temp;
					else if(a[j].equals("X"))
						--temp;
					if(temp> respuesta)
						respuesta = temp;
					
				}
				System.out.println(respuesta);
				s=br.readLine();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
