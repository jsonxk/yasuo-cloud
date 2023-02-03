package com.yasuo;

/**
 * @Description:
 * @Author: xk
 * @Date: 2023/1/3 16:13
 **/
public class Solution {

    public int findKthLargest(int[] a, int index) {
        return selectNode(a, 0, a.length - 1, index - 1);
    }

    public int selectNode(int[] node, int left, int right, int index) {
        if (left >= right) {
            return node[left];
        }
        int target = findNode(node, left, right);
        if (target == index) {
            return node[target];
        } else if (target > index) {
            return selectNode(node, left, target - 1, index);
        } else {
            return selectNode(node, target + 1, right, index);
        }
    }

    public int findNode(int[] node, int left, int right) {
        int target = node[right];
        while (left < right) {
            while (left < right && node[left] <= target) {
                left++;
            }
            node[right] = node[left];
            while (left < right && node[right] >= target) {
                right--;
            }
            node[left] = node[right];
        }
        node[right] = target;
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] aa = new int[]{7, 6, 5, 3, 3, 4, 9, 10};
        int a = solution.findKthLargest(aa, 4);
        System.out.println(a);
    }
}
