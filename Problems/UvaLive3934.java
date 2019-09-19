import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UvaLive3934 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int a = Integer.parseInt(br.readLine());
			ArrayList<Integer> b = new ArrayList<>();
			String st[] = br.readLine().split(" ");
			for(int i = 0; i < a; ++i) {
				b.add( Integer.parseInt(st[i]));
			}
			Collections.sort(b);
			boolean p = true;
			int cant = 1;
			int ultimo = b.get(0);
			int tamAsce = 1;
			int tamDesc = 0;
			String c =b.get(0)+"";
			String f ="";
			for(int i = 1; i < a; ++i) {
				if(ultimo == b.get(i) ) {
					f = b.get(i) + " " + f;
					++tamDesc;
					++cant;
				}
				else if(ultimo!= b.get(i)) {
					ultimo = b.get(i);
					cant = 1;
					c += " "+b.get(i);
					++tamAsce;
				}
				if(cant > 2) {
					p = false;
					break;
				}
			}
			if(p) {
				System.out.println("YES\n"+tamAsce+"\n" + c +"\n"+tamDesc+"\n"+f.trim());
			}
			else
				System.out.println("NO");
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
