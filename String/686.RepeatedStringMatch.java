// 686. Repeated String Match
// Easy

// 553

// 551

// Favorite

// Share
// Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

// For example, with A = "abcd" and B = "cdabcdab".

// Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

// Note:
// The length of A and B will be between 1 and 10000.

// 让sb比B长，repeat q次，测试此时包含与否，测试q+1包含与否
// q+2会落入完全与q时候一样的pattern，所以测试完这两个就可以返回-1了

class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while(sb.length() < B.length()){
            sb.append(A);
            counter++;
        }
        if(sb.toString().contains(B)) return counter;
        if(sb.append(A).toString().contains(B)) return ++counter;
        return -1;
    }
}