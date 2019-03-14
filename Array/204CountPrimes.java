// 204. Count Primes
// Count the number of prime numbers less than a non-negative number, n.

// Example:

// Input: 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

// 直觉：一个一个和前面看是否能除尽
// 要点，难点：1. 列一个数组notPrime，如果false，把是2的倍数全部都设置为true，把是3的倍数全true。。。依次类推直到k*2 < n
// 难点: 从头开始解把所有的可以被乘出来的数字全部都画为nonPrime
// 复杂度： O(n^2)
// 数据结构：Array

class Solution {
    public int countPrimes(int n) {
        boolean[] array = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++)
        {
            if(array[i] == false)
            {
                count++;
                for(int j = 2; i*j < n; j++)
                {
                    array[j*i] = true;
                }
            }
        }
        return count;
    }
}