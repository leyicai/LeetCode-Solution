class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length < 0)
			return new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] s = strs[i].toCharArray();
			Arrays.sort(s);
			String key = String.valueOf(s);
			if (!map.contains(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(strs[i]);
		}
		return new ArrayList<>(map.values());
	}
}