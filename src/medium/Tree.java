package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
	
	public static List<List<Integer>> getResult(int N, long X) {
		
		List<List<List<Integer>>> res = new ArrayList<>();
		
		List<Integer> t = new ArrayList<>();
		t.add(1);
		t.add(2);
		List<List<Integer>> t2 = new ArrayList<>();
		t2.add(t);
		res.add(t2);		
		
		List<List<List<Integer>>> res2 = new ArrayList<>();
		
		for(int j=3; j<=N; j++) {
			
			
			for (List<List<Integer>> ares: res) {		
				
				for(int i=1; i<j; i++) {
					
					List<List<Integer>> temp3 = new ArrayList<>();
					
					for(List<Integer> bres: ares) {
						List<Integer> atemp3 = new ArrayList<>();
						atemp3.add(bres.get(0));
						atemp3.add(bres.get(1));
						temp3.add(atemp3);
					}
					
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);			
					temp3.add(temp);			
					res2.add(temp3);				
				}					
			}
			res.clear();
			for(List<List<Integer>> ares2: res2) {
				res.add(ares2);
			}
			res2.clear();
		}
				
		
		for(List<List<Integer>> ares: res) {
			int count = 0;
			for(int i = 0; i<ares.size(); i++) {
				List<Integer> temp = new ArrayList<>();
				temp.add(ares.get(i).get(0));
				temp.add(ares.get(i).get(1));
				while (temp.get(0)>1) {
					
						for(int j=1; j<temp.get(1); j++) {
							List<Integer> temp2 = Arrays.asList(j, temp.get(0));
							int temp3 = temp.get(0);
							if(ares.contains(temp2)) {
								temp.clear();
								temp.add(j);
								temp.add(temp3);
								count++;
								break;
							}
							count++;
						}
					
				}
				count++;
				
			}
			
			if (count == X) {
				return ares;
			}
			
		}
		
		List<List<Integer>> negResult = new ArrayList<>();
		negResult.add(Arrays.asList(-1,-1));
		return negResult;
	}
	
	public static void main(String[] args) {
		System.out.println(getResult(6,7));
	}

}
