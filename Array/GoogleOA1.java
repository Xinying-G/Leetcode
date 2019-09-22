// Google water plan 
// 
// OA有两题coding
// 1) 浇花
// 有一个水桶容量是‍‌‍‍‌‍‌‌‌‌‌‌‌‌‍‍‌‍‍C，每朵花需要的水量是Ai(1<=i<=N)，i=0是补水站
// 需要依序浇水，如果水桶剩余水量不够就必须i=0补水
// 一开始在i=0，问浇完所有花的最少移动步数
// sample:
// C = 3, A = [2, 2, 1, 1, 2]
// 移动路径: 0->1->0->2->3->0->4->5 total=13
// [2,4,5,1,2]
//plant
//1 ,  2
//step
//+1 ,+1,
//water,
// 4, 0,


import java.util.*;
import java.io.*;
class solution {
	public static int waterPlant(int[] plants, int capacity){
		int water = capacity, step = 0;
		for(int i = 0; i < plants.length; i++){
			step++;
			if(water < plants[i]){
				step += i*2;
				water = capacity;
			}
			water -= plants[i];
		}
		return step;
	}

	public static void main(String[] args){
		int[] arr = new int[]{2,4,5,1,2};
		int steps = waterPlant(arr,6);
		System.out.println(steps);
		int[] arr2 = new int[]{2,2,1,1,2};
		int steps2 = waterPlant(arr2,3);
		System.out.println(steps2);
	}
}