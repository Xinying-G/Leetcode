// 71. Simplify Path

// Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
// In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
// Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

// Example 1:

// Input: "/home/"
// Output: "/home"
// Explanation: Note that there is no trailing slash after the last directory name.
// Example 2:

// Input: "/../"
// Output: "/"
// Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
// Example 3:

// Input: "/home//foo/"
// Output: "/home/foo"
// Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
// Example 4:

// Input: "/a/./b/../../c/"
// Output: "/c"
// Example 5:

// Input: "/a/../../b/../c//.//"
// Output: "/c"
// Example 6:

// Input: "/a//b////c/d//././/.."
// Output: "/a/b/c"

// 直觉：stack
// 要点，难点：1.Stack很考察function的运用
// functions：1. Deque<String> xxx = new LinkedList<>()
// 2. Set<String> skip = new HashSet<>()
// 3. Arrays.asList(",",".","..")
// 4. string.split(" ")
// 5. string.equals()
// 6. LikedList.isEmpty()
// 7. hashste.contains()
// 归类：Stack
// 难点: Array
// 复杂度： O(n)
// 数据结构：dp
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList(".","..",""));
        for(String str: path.split("/"))
        {
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(str)) stack.push(str);
        }
        
        String res = "";
        for(String dir: stack)
        {
            res = "/" + dir + res;
        }
        
        return res.isEmpty()? "/":res;
    }
}