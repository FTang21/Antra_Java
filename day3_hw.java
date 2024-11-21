// First Unique Character in a String
public int firstUniqChar(String s) {
    Map<Character, Long> freqMap = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    int min = freqMap.keySet().stream()
        .filter(c -> freqMap.get(c) == 1)
        .mapToInt(c -> s.indexOf(c))
        .reduce(Math::min)
        .orElse(-1);
    return min;
}

// Top K Frequent Words
public List<String> topKFrequent(String[] words, int k) {
    Map<String, Long> freqMap = Arrays.stream(words)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    
    List<String> res = freqMap.keySet().stream()
        .sorted((a, b) -> {
            int val = freqMap.get(b).compareTo(freqMap.get(a));
            if (val == 0) {
                return a.compareTo(b);
            } 
            return val;
        })
        .limit(k)
        .collect(Collectors.toList());
    return res;
}

// Sum of Unique Elements
public int sumOfUnique(int[] nums) {
    Map<Integer, Long> freqMap = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    
    int sum = freqMap.keySet().stream()
        .filter(n -> freqMap.get(n) == 1)
        .reduce(0, Integer::sum);
    return sum;
}