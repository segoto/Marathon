import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Codeforces1157c1 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			StringBuilder str = new StringBuilder();
			int a = Integer.parseInt(br.readLine());
			int[] b = new int[a];
			String[] c = br.readLine().split(" ");
			for(int i = 0; i < a; ++i) {
				b[i]=Integer.parseInt(c[i]);
			}
			int actual = Integer.MIN_VALUE;
			int inicio = 0;
			int fin = a-1;
			int contador = 0;
			while(fin-inicio>=0) {
				if(actual < b[inicio] && actual < b[fin]) {
					if(b[inicio] > b[fin]) {
						actual = b[fin];
						--fin;
						str.append("R");
					}
					else {
						actual = b[inicio];
						++inicio;
						str.append("L");
					}
				}
				else if (actual > b[inicio] && actual < b[fin]) {
					actual = b[fin];
					--fin;
					str.append("R");
				}
				else if (actual > b[fin] && actual < b[inicio]){
					actual = b[inicio];
					++inicio;			
					str.append("L");
				}
				else {
					break;
				}
				++contador;
			}
			System.out.println(contador + "\n" + str.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
