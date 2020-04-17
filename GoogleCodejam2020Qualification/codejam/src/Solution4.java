import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution4 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int t, B;
			String initialData[] = br.readLine().split(" ");

			t = Integer.parseInt(initialData[0]);
			B = Integer.parseInt(initialData[1]);
			
			for(int c = 0; c < t; ++c) {
				String resp = "";
				if( B == 10) {
					for(int i = 1 ; i <= 10;++i) {
						System.out.println(i);
						resp += br.readLine();
					}
					System.out.println(resp);
					br.readLine();
				}
				else {
					//for every ten queries the groups for (0,0),(0,1),(1,0),(1,1)
					int numberOfGroups = B/10;
					int nList = 4*numberOfGroups;

					ArrayList<int[]> allLists[] = new ArrayList[nList];
					for(int i = 0; i < nList; ++i) {
						allLists[i] = new ArrayList<>();
					}
					//First queries to add all the pairs to the corresponding group
					for(int block = 1, i = 1, k = 0; block <= numberOfGroups; ++block, i+=5, k+=4) {
						for(int j = i, r = B-i+1; j <=5*block; ++j, --r ) {
							System.out.println(j);
							int posA = Integer.parseInt(br.readLine());
							System.out.println(r);
							int posB = Integer.parseInt(br.readLine());
							int[] pair = {j, r};
							if(posA == posB && posA == 0) {
								//both equal 0
								allLists[k].add(pair);
							}
							else if(posA == posB) {
								//both equal 1
								allLists[k+3].add(pair);
							}
							else if(posA == 0) {
								//first 0 the other 1
								allLists[k+1].add(pair);
							}
							else {
								//first 1 the other 0
								allLists[k+2].add(pair);
							}
						}
					}

					//definitive lists
					ArrayList<int[]> definitive0 = new ArrayList<>();
					ArrayList<int[]> definitive1 = new ArrayList<>();
					ArrayList<int[]> definitive2 = new ArrayList<>();
					ArrayList<int[]> definitive3 = new ArrayList<>();

					int representantDef0 = -1;
					int representantDef3 = -1;
					int trashQueries = 0;
					
					for(int i = 0, groups = 0; i < numberOfGroups; ++i, groups+=4) {
						//both list empty
						if(allLists[groups].size() == 0 && allLists[groups+3].size() == 0) {
							++trashQueries;
							continue;
						}
						//definitive empty, then assign and find the value for the representative value of each one 
						else if(definitive0.size()==0 && definitive3.size()==0) {
							
							definitive0 = allLists[groups];
							definitive3 = allLists[groups+3];
							if(allLists[groups].size()== 0) {
								System.out.println(allLists[groups+3].get(0)[0]);
								representantDef3 = Integer.parseInt(br.readLine());
								representantDef0 = representantDef3 == 1? 0 : 1;
							}
							else {
								System.out.println(allLists[groups].get(0)[0]);
								representantDef0 = Integer.parseInt(br.readLine());
								representantDef3 = representantDef0 == 1? 0 : 1;
							}
							continue;
						}
						
						//see if the actual is empty  and try with the other one
						if(allLists[groups].size()==0) {
							
							System.out.println(allLists[groups+3].get(0)[0]);
							int bit = Integer.parseInt(br.readLine());
							if(bit == representantDef3) {
								definitive3.addAll(allLists[groups+3]);
							}
							else {
								definitive0.addAll(allLists[groups+3]);
							}
						}
						else {
							
							System.out.println(allLists[groups].get(0)[0]);
							int bit = Integer.parseInt(br.readLine());
							if(bit == representantDef3 ) {
								definitive3.addAll(allLists[groups]);
								definitive0.addAll(allLists[groups+3]);

							}
							else {
								definitive3.addAll(allLists[groups+3]);
								definitive0.addAll(allLists[groups]);
							}
						}
					}
					
					if(B == 100) {
						for(int i =0 ;i<trashQueries;++i) {
							System.out.println("1");
							br.readLine();
						}
					}
					
					int representantDef1 = -1;
					int representantDef2 = -1;
					trashQueries = 0;
					for(int i = 0, groups = 0; i < numberOfGroups; ++i, groups+=4) {
						if(allLists[groups+1].size() == 0 && allLists[groups+2].size() == 0) {
							++trashQueries;
							continue;
						}
						else if(definitive1.size()==0 && definitive2.size()==0) {
							
							definitive1 = allLists[groups+1];
							definitive2 = allLists[groups+2];
							if(allLists[groups+1].size()== 0) {
								System.out.println(allLists[groups+2].get(0)[0]);
								representantDef2 = Integer.parseInt(br.readLine());
								representantDef1 = representantDef2 == 1? 0 : 1;
							}
							else {
								System.out.println(allLists[groups+1].get(0)[0]);
								representantDef1 = Integer.parseInt(br.readLine());
								representantDef2 = representantDef1 == 1? 0 : 1;
							}
							continue;
						}
						
						if(allLists[groups+1].size()==0) {
							
							System.out.println(allLists[groups+2].get(0)[0]);
							int bit = Integer.parseInt(br.readLine());
							if(bit == representantDef2) {
								definitive2.addAll(allLists[groups+2]);
							}
							else {
								definitive1.addAll(allLists[groups+2]);
							}
						}
						else {
							
							System.out.println(allLists[groups+1].get(0)[0]);
							int bit = Integer.parseInt(br.readLine());
							if(bit == representantDef2 ) {
								definitive2.addAll(allLists[groups+1]);
								definitive1.addAll(allLists[groups+2]);

							}
							else {
								definitive2.addAll(allLists[groups+2]);
								definitive1.addAll(allLists[groups+1]);
							}
						}
					}
					//complete until the change
					if(B == 100) {
						for(int i = 0 ;i<trashQueries;++i) {
							System.out.println("1");
							br.readLine();
						}
					}
					
					int answer[] = new int[B];
					
					if(definitive0.size() != 0) {
						System.out.println(definitive0.get(0)[0]);
						int bit = Integer.parseInt(br.readLine());
						int compl = bit == 0 ? 1 : 0; 
						for(int i = 0; i <definitive0.size(); ++i ) {
							answer[definitive0.get(i)[0]-1] = bit;
							answer[definitive0.get(i)[1]-1] = bit;
						}
						for(int i = 0 ; i < definitive3.size(); ++i) {
							answer[definitive3.get(i)[0]-1] = compl;
							answer[definitive3.get(i)[1]-1] = compl;
						}
					}
					else if(definitive3.size()!=0) {
						System.out.println(definitive3.get(0)[0]);
						int compl = Integer.parseInt(br.readLine());
						for(int i = 0 ; i < definitive3.size(); ++i) {
							answer[definitive3.get(i)[0]-1] = compl;
							answer[definitive3.get(i)[1]-1] = compl;
						}
					}
					if(definitive1.size() != 0) {
						System.out.println(definitive1.get(0)[0]);
						int bit = Integer.parseInt(br.readLine());
						int compl = bit == 0 ? 1 : 0; 
						for(int i = 0; i <definitive1.size(); ++i ) {
							answer[definitive1.get(i)[0]-1] = bit;
							answer[definitive1.get(i)[1]-1] = compl;
						}
						for(int i = 0 ; i < definitive2.size(); ++i) {
							answer[definitive2.get(i)[0]-1] = compl;
							answer[definitive2.get(i)[1]-1] = bit;
						}
					}
					else if(definitive2.size() != 0){
						System.out.println(definitive2.get(0)[0]);
						int bit = Integer.parseInt(br.readLine());
						int compl = bit == 0 ? 1 : 0; 
						for(int i = 0; i <definitive2.size(); ++i ) {
							answer[definitive2.get(i)[0]-1] = bit;
							answer[definitive2.get(i)[1]-1] = compl;
						}
					}
					for(int i = 0; i < B; ++i) {
						resp+=answer[i];
					}
					System.out.println(resp);
					String correct = br.readLine();
					if(correct.equals("N")) {
						return;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
