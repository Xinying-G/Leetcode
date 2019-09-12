// 1007. Minimum Domino Rotations For Equal Row
// Medium

// 108

// 81

// Favorite

// Share
// In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

// We may rotate the i-th domino, so that A[i] and B[i] swap values.

// Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

// If it cannot be done, return -1.
// 其实就是比较两行，看看是否都有共同的元素，如果有就计算换过来的

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
//         int val1 = A[0];
//         int val2 = B[0];
//         int counter1 = 0, counter2 = 0;
//         for(int i = 1; i < A.length; i++){
//             if(counter1 != -1 && B[i] == val1 && A[i] != val1) counter1++;
//             if(A[i] != val1 && B[i] != val1) counter1 = -1;
//             if(counter2 != -1 && A[i] == val2 && B[i] != val2) counter2++;
//             if(A[i] != val2 && B[i] != val2) counter2 = -1;
//         }
//         if(counter1 != -1) counter1 = Math.min(counter1,B.length - counter1);
//         if(counter2 != -1) counter2 = Math.min(counter2,B.length - counter2);
//         System.out.println(counter1);
//         System.out.println(counter2);
//         System.out.println(B.length);
//         return counter1 != -1? (counter2 != -1? Math.min(counter1,counter2): counter1):(counter2 != -1? counter2: -1);
        
//     }
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }
}