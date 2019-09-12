import java.util.*;
import java.io.*;

class solution{
	static public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        Map<String,List<String>> map = new HashMap<>();
		for(List<String> pair: pairs){
            if(!map.containsKey(pair.get(0))){
                List<String> list = new ArrayList<>();
                list.add(pair.get(0));
                list.add(pair.get(1));
                map.put(pair.get(0),list);
            }else{
                List<String> list = map.get(pair.get(0));
                list.add(pair.get(1));
                map.put(pair.get(0),list);
            }
            
            if(!map.containsKey(pair.get(1))){
                List<String> list = new ArrayList<>();
                list.add(pair.get(1));
                list.add(pair.get(0));
                map.put(pair.get(1),list);
            }else{
                List<String> list = map.get(pair.get(1));
                list.add(pair.get(0));
                map.put(pair.get(1),list);
            }
		}

		if(words1.length != words2.length) return false;
		for(int i = 0; i < words1.length; i++){
            if(!map.containsKey(words1[i]))
            {
                List<String> list = new ArrayList<>();
                list.add(words1[i]);
                map.put(words1[i],list);
            }          
            List<String> list = map.get(words1[i]);    
			boolean found = false;
			for(String str: list){
				if(str.equals(words2[i])){
					found = true;
					continue;
				}
			}
            if(found == false) return found;
		}
        return true;
    }

    static public void main(String[] args){
    	String[] words1 = new String[]{"great","acting"};
    	String[] words2 = new String[]{"fine","drama"};
    	List<List<String>> example = new ArrayList<>();
    	List<String> pair1 = new ArrayList<>();
    	pair1.add("great");
    	pair1.add("fine");
    	List<String> pair2 = new ArrayList<>();
    	pair2.add("acting");
    	pair2.add("drama");
    	example.add(pair1);
    	example.add(pair2);
    	boolean res = areSentencesSimilar(words1,words2,example);
    	System.out.println(res);
    }
}