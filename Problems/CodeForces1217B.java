import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class CodeForces1217B {
	static Comparator<int[]> comparador = new Comparator<int[]>(){

		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[2]> o2[2]) {
				return -1;
			}
			else if(o1[2]<o2[2]) {
				return 1;
			}
			else {
				if(o1[0]> o2[0]) {
					return -1;
				}
				else if(o1[0]<o2[0]) {
					return 1;
				}
				else {
					if(o1[1]<o2[1])
						return -1;
					else if(o1[1]> o2[1])
						return 1;
				}
			}
			return 0;
		}

	};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b, h;
		String str[];
		for(int i = 0; i < a; ++i) {
			str = br.readLine().split(" ");
			b = Integer.parseInt(str[0]);
			h = Integer.parseInt(str[1]);
			int mayores = 0;
			int maximoGlobal = 0;
			int total = 0;
			ArrayList<int[]> p = new ArrayList<>();
			for(int j = 0 ; j < b; ++j ) {
				int[] f = new int[3];
				str = br.readLine().split(" ");
				f[0] = Integer.parseInt(str[0]);
				maximoGlobal = f[0] > maximoGlobal? f[0] : maximoGlobal;
				f[1] = Integer.parseInt(str[1]);
				if(f[0]<=f[1]) {
					++mayores;
					continue;
				}
				f[2] = f[0]-f[1];
				p.add(f);
			}
			total = h-maximoGlobal;
			if(total <= 0) {
				System.out.println(1);
				continue;
			}
			if(mayores==b)
				System.out.println(-1);
			else {
				p.sort(comparador);
				int[] max = p.get(0);
				//System.out.println((h-maximoGlobal)+"dsfasdfasdfasdfsa"+max[2]);

				if(total <= 0) {
					System.out.println(1);
					continue;
				}
				int cabe = total/max[2];
				//System.out.println(cabe + "          asdfasdfasdfasdfasdf");
				if(((cabe*max[0])-((cabe)*max[1]))>=total) {
					System.out.println(cabe+1);
				}
				else {
					System.out.println(cabe+2);
				}
				//System.out.println(h+"        "+Math.ceil((double)h/(double)dif)+ "           "+dif+ "               "+ p1[0]);
				//System.out.println((int)Math.ceil((double)h/(double)dif));
			}

		}
	}
}
