// Example:

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6

class Solution {
    public int trap(int[] height) {
        int buffer = 0;
        int[] right = new int[height.length]; 
        for(int i = 0; i < height.length; i++)
        {
            buffer = (height[i] > buffer)? height[i]: buffer; 
            // System.out.println(height[i]);
            right[i] = buffer - height[i];
        }
        int[] left = new int[height.length];
        buffer = 0;
        for(int i = height.length-1; i >= 0; i--)
        {
            buffer = (height[i] > buffer)? height[i]: buffer;
            left[i] = buffer - height[i];
        }
        int sum = 0;
        for(int i = 0; i < height.length-1; i++)
        {
            sum += right[i] > left[i]? left[i]:right[i];
        }
        return sum;
    }
}