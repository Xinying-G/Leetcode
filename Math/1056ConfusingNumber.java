// 1056. Confusing Number
// Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:

// We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid. A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

class Solution {
    // one: 0,1,6,8,9
    // two: 11,18,81,89,98,86, 10, 01,60,06,80,08,
//     1->1, 6->9,8->8,9->6, 0->0
    public boolean confusingNumber(int N) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(6,9);
        map.put(9,6);
        map.put(0,0);
        map.put(8,8);
        String str = Integer.toString(N);
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1;i >= 0; i--){
            if(map.containsKey(str.charAt(i)- '0'))
                sb.append(map.get(str.charAt(i) - '0'));
            else return false;
        }

        if(sb.toString().equals(str)) return false;
        return true;
    }
    
} 