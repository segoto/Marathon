import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Fire {
	static class Item{
		int p,d,t, po;
		Item(int p1,int d1,int t1, int pos){
			p=p1;
			d=d1;
			t=t1;
			po=pos;
		}
	}
	static class ComparatorA implements Comparator<Item>{
		@Override
		public int compare(Item a, Item b){
			if(a.d<b.d){
				return -1;
			}
			return 1;
		}
	}
	public static void main(String[] args) {

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int n = Integer.parseInt(br.readLine());
			Item[] items = new Item[n];
			for(int i=0;i<n;++i){
				String[] a = br.readLine().split(" ");
				Item item = new Item(Integer.parseInt(a[2]),Integer.parseInt(a[1]), Integer.parseInt(a[0]), i+1);
				items[i]=item;
			}
			Arrays.sort(items, new ComparatorA());
			//System.out.println(items[0].d + " "+items[1].d +" "+ items[2].d);
			int[][] matriz = new int[n+1][2050];
			ArrayList<Item>[][] lasQueCojo = new ArrayList[n+1][2050];
			for(int r=0;r<2050;r++) {
				lasQueCojo[n][r]= new ArrayList<>();
			}
			for(int i=n-1;i>=0;--i){
				for(int j=0; j<=2000;++j){
					if(j+items[i].t<items[i].d){
						if(matriz[i+1][j+items[i].t]+items[i].p>matriz[i+1][j]) {
							matriz[i][j]=matriz[i+1][j+items[i].t]+items[i].p;
							lasQueCojo[i][j]=new ArrayList<>(lasQueCojo[i+1][j+items[i].t]);
							lasQueCojo[i][j].add(items[i]);
						}
						else {
							lasQueCojo[i][j]= new ArrayList<>(lasQueCojo[i+1][j]);
							matriz[i][j]= matriz[i+1][j];
						}
					}
					else{
						lasQueCojo[i][j]=new ArrayList<>( lasQueCojo[i+1][j]);
						matriz[i][j]=matriz[i+1][j];
					}
				}
			}
			String s ="";
			for (int i = lasQueCojo[0][0].size()-1; i >=0; --i) {
				s+=""+lasQueCojo[0][0].get(i).po+" ";
			}
			s=matriz[0][0]+"\n"+lasQueCojo[0][0].size()+"\n"+s;
			System.out.println(s);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
