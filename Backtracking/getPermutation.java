// 60. Permutation Sequence
// The set [1,2,3,...,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note:

// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.
// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314
// 
// 解决方法：将size视作一个counter 然后把每一个不同的元素都放在size counter的位置，这样前几位就都是不同的数字，
// 直觉：同解决方法 
// 要点，难点：size做指针又做counter， in-place
// 归类：unique subset
// 难点：in-place，
// 复杂度： O(n)，
// 数据结构：vector

import java.util.Scanner;
Public class getPermutation
{
	public String getPermutation(int n, int k) {
        dfs()
    }

    public String dfs()
}










