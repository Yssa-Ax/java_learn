package com.example.demo.arithmetic_learn.circularChain;

/**
 * @author Administrator
 * @description 环形链解决约瑟夫问题测试
 * @since 2022/11/24 9:44
 **/
public class Josepfu {
    public static void main(String[] args) {
        //构建环形链表和遍历是否OK
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);//加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,5);//2,4,1,5,3
    }


}
