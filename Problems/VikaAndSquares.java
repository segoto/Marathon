import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VikaAndSquares {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int a = Integer.parseInt(br.readLine());
			int b[] = new int[a];
			String s[] = br.readLine().split(" ");
			long menor= Integer.parseInt(s[0]);
			for( int i = 0 ; i < a ; ++i) {
				b[i] = Integer.parseInt(s[i]);
				if(menor>=b[i]) 
					menor = b[i];
			}
			ArrayList<Long> p = new ArrayList<>();
			int dondeAparecioUltimaVez=0;
			long distancia = 0;
			long mayor = 0;
			for(int i = 0 ; i < a ; ++i) {
				if(menor==b[i]) {
					distancia=i-dondeAparecioUltimaVez-1;
					p.add(distancia);
					if(mayor<distancia) 
						mayor = distancia;
					
					dondeAparecioUltimaVez=i;
					distancia=0;
				}
			}
			distancia = a-dondeAparecioUltimaVez;
			distancia+=p.get(0);
			p.add(distancia);
			mayor= mayor > p.get(p.size()-1)?mayor:p.get(p.size()-1);
			System.out.println(((long)menor*a) + mayor);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
