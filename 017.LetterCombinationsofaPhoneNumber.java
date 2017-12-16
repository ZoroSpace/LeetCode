class Solution {
	public List<String> letterCombinations(String dig) {
		//待修正，list的大小在动态变化
		LinkedList<StringBuilder> result = new LinkedList<>();
		result.add(new StringBuilder());
			char[] chArray = String.toCharArray(dig);
			StringBuilder s0;
			StringBuilder s1;
			StringBuilder s2;
			for(char c : chArray) {
				switch(c) {
					case '2':
					{
						for(StringBuilder s : result) {
							s0 = s + 'a';
							s1 = s + 'b';
							s = s + 'c';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '3':
					{
						for(StringBuilder s : result) {
							s0 = s + 'd';
							s1 = s + 'e';
							s = s + 'f';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '4':
					{
						for(StringBuilder s : result) {
							s0 = s + 'g';
							s1 = s + 'h';
							s = s + 'i';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '5':
					{
						for(StringBuilder s : result) {
							s0 = s + 'j';
							s1 = s + 'k';
							s = s + 'l';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '6':
					{
						for(StringBuilder s : result) {
							s0 = s + 'm';
							s1 = s + 'n';
							s = s + 'o';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '7':
					{
						for(StringBuilder s : result) {
							s0 = s + 'p';
							s1 = s + 'q';
							s2 = s + 'r';
							s = s + 's';
							result.add(s0);
							result.add(s1);
							result.add(s2);
						}
						break;
					}
					case '8':
					{
						for(StringBuilder s : result) {
							s0 = s + 't';
							s1 = s + 'u';
							s = s + 'v';
							result.add(s0);
							result.add(s1);
						}
						break;
					}
					case '9':
					{
						for(StringBuilder s : result) {
							s0 = s + 'w';
							s1 = s + 'x';
							s2 = s + 'y';
							s = s + 'z';
							result.add(s0);
							result.add(s1);
							result.add(s2);
						}
						break;
					}
					default break;
				}
			}
			return result;
		}
}


