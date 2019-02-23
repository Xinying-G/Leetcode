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
// 要点，难点：1. StringBuilder string builder 可以append value。String.valueOf()返回string
// 2. 算法， 假设4个数字，第一个排列de(index) = k/(n-1)!, k = k - 第一个排列(index)*(n-1)! 第二个排列de(index) = k/(n-2)! 
// k = k - 第二个排列de(index)*k/(n-2)!
// 3.String.valueOf(int)
// 4.List.get(index)
// 归类：Permutation
// 难点: 算法，permutation的个数取决于后面几位有几种
// 复杂度： O(n)
// 数据结构：String，StringBuilder，List


import java.lang.StringBuilder;
import java.util.*;

public class getPermutation
{
	public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int[] fractorial = new int[n+1]; 

        for(int i = 1; i <= n; i++)
        {
        	nums.add(i);
        }

        int sum = 1;
        fractorial[0] = 1;
        for(int i = 1; i <= n; i++)
        {
        	sum *= i;
        	fractorial[i] = sum; 
        }

        k--;
        for(int i = 1; i <= n; i++)
        {
        	int index = k/fractorial[n-i];
        	k = k - index*fractorial[n-i];
        	sb.append(String.valueOf(nums.get(index)));
        	nums.remove(index);
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args)
	{
		// Scanner reader = new Scanner(System.in);
		// System.out.println("Enter a number: ");
		// int n = reader.nextInt();
		getPermutation per = new getPermutation();
		String res = per.getPermutation(4,3);
		System.out.printf(res);
	}
}










