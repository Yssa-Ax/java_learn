package com.example.demo.arithmetic_learn.recall;

/**
 * @author Administrator
 * @description 递归回溯  解决8皇后问题
 * @since 2022/11/25 16:11
 **/
public class Queen8 {
    // 定义一个max表示有多少个皇后
    int max = 8;
    // 定义数组array, 保存皇后防止位置的结果
    int [] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        // 测试
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w

    }
    // 编写一个方法放置n个皇后
    // 特别注意：check 是 每一次递归时，进入到check中都有 for(int i = 0; i < max; i++), 因此会有回溯
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n, 放到改行的第一列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                // 接着放n + 1皇后， 即开始递归
                check(n + 1);
            }
            // 如果冲突， 就继续执行 array[n] = i; 即将第n个皇后，放置在本行得，后移得一个位置。
        }
    }

    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
