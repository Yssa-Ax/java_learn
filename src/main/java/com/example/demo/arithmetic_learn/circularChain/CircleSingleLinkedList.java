package com.example.demo.arithmetic_learn.circularChain;

/**
 * @author Administrator
 * @description 环形链表
 * @since 2022/11/24 9:05
 **/
public class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = null;

    // 添加节点，构建一个环形链表

    public void add(int nums){
        // nums 做一个数据校验
        if (nums < 1){
            System.out.println("nums的值不正确");
            return;
        }

        // 辅助指针，构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // 编剧编码创建节点
            Boy boy = new Boy(i);
            // 第一个节点比较特别
            if (i == 1){
                first = boy;
                first.setNext(first); // 构成一个环
                curBoy = first; // 让curboy指向第一个节点
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    public void showBoy(){
        // 链表是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        // first不能动，需要辅助指针
        Boy curBoy  = first;
        while (true){
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();


        }
    }

    // 更具用户的输入，计算出圈的顺序
    public void countBoy(int startNo, int countNum, int nums){
        // 校验
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建辅助指针,帮助完成除权
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        // 加入startNo不是1，先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数之前，让first和helper指针同时移动countNum次，然后出圈
        // 循环，直到圈中只有一个节点
        while (true){
            if (helper == first){ // 说明只有一个节点了
                break;
            }
            // 让first, helper同时移动countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // first指向的节点就是出圈的节点
            System.out.printf("小孩%d出圈 \n", first.getNo());
            // 将first指向的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}
