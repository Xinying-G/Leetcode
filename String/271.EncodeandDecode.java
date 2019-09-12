// 271. Encode and Decode Strings
// Medium

// 277

// 102

// Favorite

// Share
// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:

// string encode(vector<string> strs) {
//   // ... your code
//   return encoded_string;
// }
// Machine 2 (receiver) has the function:
// vector<string> decode(string s) {
//   //... your code
//   return strs;
// }
// So Machine 1 does:

// string encoded_string = encode(strs);
// and Machine 2 does:

// vector<string> strs2 = decode(encoded_string);
// strs2 in Machine 2 should be the same as strs in Machine 1.

// Implement the encode and decode methods.

// 直觉：加%20然后decode
// 要点，难点：1. 记录string length，之后每一次都直接让index跳到到被记录的那个位置，进行decode
// 2. StringBuilder sb.append(), sb.toString() string.indexOf('/',startIndex)
// 3. String to interger: Integer.valueOf()
// 4. String.substring(startIndex,endIntex+1);
// 归类：String
// 难点: 很难想出
// 复杂度： O（n）
// 数据结构：StringBuilder

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //5/abcde6/erfs
        List<String> res = new ArrayList<>();
        int ind = 0;
        while(ind < s.length()){
            int slash = s.indexOf('/',ind);
            int size = Integer.valueOf(s.substring(ind,slash));
            ind = slash+1+size;
            String str = s.substring(slash+1,ind);
            res.add(str);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));