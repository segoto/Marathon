import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA12651 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String s = br.readLine();
			while(!s.equals("")) {
				int cant = Integer.parseInt(s);
				String[] st = br.readLine().split(" ");
				int[] sumas = new int[cant];
				sumas[0] = Integer.parseInt(st[0]);
				for(int i = 1; i< cant; ++i) {
					sumas[i] = sumas[i-1]+Integer.parseInt(st[i]);
				}
				int resp = 0;

				if(sumas[cant-1]%3 ==0) {
					int c = sumas[cant-1]/3;
					for(int i = 0; i < cant; ++i) {
						int a = (sumas[i]+c);
						if(a > sumas[cant-1])
							break;
						if(busquedaBinaria(a , sumas) && busquedaBinaria(a +c, sumas)) {
							++resp;
						}

					}

				}
				System.out.println(resp);
				s = br.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	private static boolean busquedaBinaria(int a, int[] sumas) {
		int ini = 0;
		int fini = sumas.length-1;
		while(fini>= ini) {
			int miti = (fini+ini)/2;
			if(sumas[miti]== a) {
				return true;
			}
			else if(sumas[miti]> a) {
				fini = miti-1;
			}
			else {
				ini = miti+1;
			}
		}
		return false;
	}
}
