    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
     
    public class CodeForces1213C {
    	public static void main(String[] args) {
    		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
    			long[] uno = {1,2,3,4,5,6,7,8,9,0};
    			long[] dos = {2,4,6,8,0};
    			long[] tres = {3,6,9,2,5,8,1,4,7,0};
    			long[] cuatro = {4,8,2,6,0};
    			long[] cinco = {5,0};
    			long[] seis = {6,2,8,4,0};
    			long[] siete = {7,4,1,8,5,2,9,6,3,0};
    			long[] ocho = {8,6,4,2,0};
    			long[] nueve = {9,8,7,6,5,4,3,2,1,0};
    			int casos = Integer.parseInt(br.readLine());
    			long n, m;
    			ArrayList<long[]> secuencias = new ArrayList<>();
    			secuencias.add(uno);
    			secuencias.add(dos);
    			secuencias.add(tres);
    			secuencias.add(cuatro);
    			secuencias.add(cinco);
    			secuencias.add(seis);
    			secuencias.add(siete);
    			secuencias.add(ocho);
    			secuencias.add(nueve);
    			String[] st;
    			long[] secuencia;
    			for(int i = 0; i < casos; ++i){
    				st = br.readLine().split(" ");
    				n = Long.parseLong(st[0]);
    				m = Long.parseLong(st[1]);
    				long fin = m%10;
    				if(fin==0 || m>n){
    					System.out.println("0");
    					continue;
    				}
    				//System.out.println(fin);
    				secuencia = secuencias.get((int)(fin-1));
    				long r = 0;
    				int suma;
    				if(fin % 2 == 0){
    					suma = 20;
    				}
    				else{
    					if(fin == 5){
    						suma = 5;
    					}
    					else{
    						suma = 45;
    					}
    				}
    				long cabe = Math.floorDiv(n,m);
    				long cicloCompleto = Math.floorDiv(cabe, secuencia.length);
    				long sobra = cabe % secuencia.length;
    				long sumaDeloQueSobra = 0;
    				for(int j = 0; j < sobra; ++j){
    					sumaDeloQueSobra += secuencia[j];
    				}
    				r = (cicloCompleto*suma) + sumaDeloQueSobra;
    				System.out.println(r);
    			}
    		}
    		catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }