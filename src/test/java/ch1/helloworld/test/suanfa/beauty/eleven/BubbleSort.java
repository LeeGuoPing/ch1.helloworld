package ch1.helloworld.test.suanfa.beauty.eleven;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        // 数组不存在,不需要排序
        if (a == null || a.length <= 1) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            boolean swapFlag = false;  // 做的优化, 不需要交换数据代表排序完成.
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }
}
