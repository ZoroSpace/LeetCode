class Solution {
	public String simplifyPath (String path) {
		if(path.length() < 2) return path;
		Deque<Character> list = new LinkedList<>();
		list.addLast('/');
		char cur;
		char back;
		for(int i = 1;i < path.length();i++) {
			cur = path.charAt(i);
			if(cur == '/') {
				if(list.peekLast() == cur) continue;
				else if(list.peekLast() == '.') {
					list.pollLast();
				}
				else list.offerLast(cur);
			} else if(cur == '.') {
				if(list.peekLast() != '.') {
					list.addLast(cur);
				} else {
                    if(list.size() == 2) list.pollLast();
                    else {
					list.pollLast();
					list.pollLast();
					back = list.peekLast();
					while(back != '/') {
						list.pollLast();
						back = list.peekLast();
					}
                    }
				}
			} else {
				list.addLast(cur);
			}
		}
        if(list.peekLast() == '.') list.pollLast();
        if(list.size() == 1) return "/";
		if(list.peekLast() == '/') list.pollLast();
		StringBuilder result = new StringBuilder("");
        int size = list.size();
		for(int i = 0;i < size;i++) {
			result.append(list.pollFirst());
		}
		return result.toString();
	}
}


class Solution {
	public String simplifyPath (String path) {
		String[] words = path.split("/");
        //if(words.length != 0) return words[0];
		String result = "";
		Deque<String> q = new LinkedList<>();
		for(int i = 0;i < words.length;i++) {
			if(words[i].equals(".")) continue;
			else if(words[i].equals("..")) {
				if(q.size() != 0) q.pollLast();
			} else if(words[i].length() != 0) q.offerLast(words[i]);
		}
        
        if(q.size() == 0) return "/";
		while(q.size() > 0) result += "/" + q.pollFirst();
		return result;
	}
}
