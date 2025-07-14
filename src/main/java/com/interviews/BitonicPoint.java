package com.interviews;

/**
 * Bitonic Point - Maximum in Increasing Decreasing Array
 */
public class BitonicPoint {
    public static void main(String[] args) {
        //Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
        //Output: 8
        System.out.println(findMaximum(new int[] {1, 2, 4, 5, 7, 8, 3})); //8
        System.out.println(findMaximum(new int[] {10, 20, 30, 40, 50})); //50
        System.out.println(findMaximum(new int[] {120, 100, 80, 20, 0})); //120
    }
    // function to find the maximum element
    static int findMaximum(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + (right -left)/2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length-1 ||
                    arr[mid] > arr[mid+1]
                    )) {
                return arr[mid];
            }else if(mid > 0 && arr[mid] > arr[mid-1]) {
                left = mid+1;
            }else  {
                right = mid-1;
            }
        }
        return  -1;

    }
}
