import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class patternMatch {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for(int c = 1; c<=t; ++c) {
				int l = Integer.parseInt(br.readLine());
				String act = "";
				boolean bandera = false;
				String[] words = new String[l];
				String[] words2 = new String[l];
				ArrayList<String> medium = new ArrayList<>();
				for(int i = 0 ; i < l; ++i) {
					String line = br.readLine();
					
					String ln[] = line.split("\\*");
					
					if(line.startsWith("*")&&line.endsWith("*")) {
						for(int j = 0 ; j < ln.length; ++j) {
							medium.add(ln[j]);
						}
						words[i]="";
						words2[i] = "";
					}
					else if(line.startsWith("*")) {
						
						if(ln.length>1) {
							words[i] = ln[ln.length-1];
						}
						else {
							words[i] = "";
						}
						
						for(int j = 0 ; j < ln.length-1; ++j) {
						
							medium.add(ln[j]);
						}
						words2[i]="";
					}
					else if(line.endsWith("*")) {
						for(int j = 1 ; j < ln.length; ++j) {
							medium.add(ln[j]);
						}
						words2[i]=ln[0];
						words[i] = "";
					}
					else {

						words[i] = ln[ln.length-1];
						
						for(int j = 1 ; j < ln.length-1; ++j) {
							medium.add(ln[j]);
						}
						
						words2[i] = ln[0];
					}


				}
				Arrays.sort(words, new Comparator<String>() { 
					@Override public int compare(String p1, String p2) 
					{ 
						return p1.length() - p2.length(); 
					} 
				}); 
				Arrays.sort(words2, new Comparator<String>() { 
					@Override public int compare(String p1, String p2) 
					{ 
						return p1.length() - p2.length(); 
					} 
				}); 

				for(int i  = 0 ; i < l-1; ++i) {
					if(!(words[l-1].endsWith(words[i])) || !(words2[l-1].endsWith(words2[i])||words2[l-1].startsWith(words2[i]))) {
						bandera = true;

						System.out.println("Case #"+c+": *");
						break;
					}
				}
				if(!bandera) {
					String resp = "Case #"+c+": "+words2[l-1];
					for(int i = 0; i < medium.size(); ++i) {
						resp+=medium.get(i);
					}
					resp+=words[l-1];
					System.out.println(resp);
				}


			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}
