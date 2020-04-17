import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProblemaB {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int cases = Integer.parseInt(br.readLine());
			char[] sequence;
			int L,D,U,R;
			for(int i = 0; i < cases; ++i) {
				L = 0;
				D = 0;
				U = 0;
				R = 0;
				sequence = br.readLine().toCharArray();
				for(int j = 0 ; j < sequence.length; ++j) {
					if (sequence[j]==('L')) {
						++L;
					}
					else if (sequence[j]==('R')) {
						++R;
					}
					else if (sequence[j]==('U')) {
						++U;
					}
					else {
						++D;
					}
				}
				int substractLR = Math.abs(L-R);
				int substractUD = Math.abs(U-D);
				if (L>R) {
					L-=substractLR;
				}
				else {
					R-=substractLR;
				}
				if(U>D) {
					U-=substractUD;
				}
				else {
					D-=substractUD;
				}
				String s = "";
				int tot = U+D+L+R;
				if(L>0 && U>0 && D>0 && R>0){
					for(int j = 0; j < tot; ++j) {
						if(j < L) {
							s+="L";
						}
						else if (j<L+U) {
							s+="U";
						}
						else if(j<L+R+U) {
							s+="R";
						}
						else {
							s+="D";
						}
					}
					System.out.println(tot+"\n"+s);
				}
				else if (L>0 && U==0 && R>0 || L>0 && D==0 && R>0) {
					System.out.println(2+"\n"+"LR");
				}
				else if(U>0 && D>0 && R == 0 || U>0 && L==0 && D>0) {
					System.out.println(2+"\n"+"UD");
				}
				else if(U>=0 && D==0 && R>=0 && L==0||D>=0 && U==0 && R>=0 && L==0 || 
						U>=0 && D==0 && L>=0 && R==0||D>=0 && U==0 && L>=0 && U==0) {
					System.out.println("0\n");
				}
				
			}
		}
		catch(Exception e) {
			
		}
	}
}
