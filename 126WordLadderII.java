public class Solution {
	List<List<String>> result;
	int step;
	public List<List<String>> findLadders(String beginWord,String endWord,List<String> dict) {
		step = dict.size()+1;
		result = new LinkedList<>();
		//if(!dict.contains(endWord)) return result;
		HashMap<String,Boolean> map = new HashMap<>();
		for(String s : dict) {
			map.put(s,false);
		}
		int counter = 0;
		if(dict.contains(beginWord)) {
			map.put(beginWord,true);
			counter++;
		}
		LinkedList<String> list = new LinkedList<>();
		list.offerFirst(beginWord);
		dfs(beginWord,endWord,dict,map,list,counter);
		LinkedList<List<String>> r = new LinkedList<>();
		for(List<String> l : result) {
			if(l.size()==step) {
				r.add(l);
			}
		}
		return r;
	}
	
	void dfs(String beginW,String endW,List<String> dict,HashMap<String,Boolean> map,LinkedList<String> list,int counter) {
		if(counter > dict.size()) return;
		for(int i = 0;i < beginW.length();i++) {
			for(char j = 'a';j <= 'z';j++) {
				if(j != beginW.charAt(i)) {
					String s = beginW.substring(0,i)+ j + beginW.substring(i+1,beginW.length());
					if(map.containsKey(s)&&!map.get(s)) {
						map.put(s,true);
						LinkedList<String> cur =  (LinkedList<String>)(list.clone());
						cur.offerLast(s);
						if(s.equals(endW)) {
							result.add(cur);
							step = Math.min(step,cur.size());
							map.put(s,false);
							return;
						}
						dfs(s,endW,dict,map,cur,counter + 1);
						map.put(s,false);
					}
				}
			}
		}
	}
}
