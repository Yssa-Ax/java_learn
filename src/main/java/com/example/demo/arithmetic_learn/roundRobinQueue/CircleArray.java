package com.example.demo.arithmetic_learn.roundRobinQueue;

/**
 * @author Administrator
 * @description 队列
 * @since 2022/11/22 16:44
 **/
public class CircleArray {
    private int maxSize;
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("判断队列满");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移动 必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    // 出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列空， 不能取数据");
        }
        // 这里需要分析front是指向队列的第一个元素
        // 1. 先把front对应的值保存到一个临时变量
        // 2. 将front后移，考虑取模
        // 3. 将临时保存的变量返回
        System.out.println("==========="+front);
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue(){
        if(isEmpty()) {
            throw new RuntimeException("队列空，无法查看数据");
        }
        // 思路:从front开始遍历，遍历多少个元素
        for (int i = 0; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }


    // 求出当前对立有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }

}
