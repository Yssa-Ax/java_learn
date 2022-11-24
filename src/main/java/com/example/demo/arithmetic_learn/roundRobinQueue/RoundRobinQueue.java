package com.example.demo.arithmetic_learn.roundRobinQueue;

import java.util.Scanner;

/**
 * @author Administrator
 * @description 循环队列
 * @since 2022/11/22 16:15
 **/
public class RoundRobinQueue {
    /*
     * 在循环队列中，当队列为空时，有front(指向第一个元素)=rear(指向最后一个元素)，而当所有队列空间全占满时，也有front=rear。
     * 为了区分这两种情况，规定循环队列最后只能有MaxSize-1个队列元素，当循环队列中只剩下一个空存储单元时，队列就已经满了。
     * 因此队列判满的条件时front=rear，而队列判满的条件时front = (rear+1)%MaxSize
     * */

    public static void main(String[] args) {
        System.out.println("测试模拟环形队列");
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';// 接收数据输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(hear):查出队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("查出队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
            }

        }
        System.out.println("程序退出");

    }

}
