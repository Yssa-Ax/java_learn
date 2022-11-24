package com.example.demo.arithmetic_learn.oneLinkedList;

import java.sql.SQLOutput;
import java.util.Stack;

/**
 * @author Administrator
 * @description 单项链表
 * @since 2022/11/23 11:15
 **/
public class SingleLinkedList {
    // 初始化一个头节点，头节点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");
    // 添加节点到单项列表
    // 思路，当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后节点的next域指向新的节点
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此需要一个辅助变量
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true){
            if(temp.next == null) {
                break;
            }
            // 如果没有好到 将temp后移
            temp = temp.next;
        }
        // 当退出while循环时temp就指向了链表最后
        temp.next = heroNode;
    }

    // 第二种添加链表方式， 根据排名插入指定位置
    // 如果存在，添加失败，并给出提示
    public void addByOrder(HeroNode heroNode){
        // 因为头节点不能动，我们仍然通过辅助变量来找到添加的位置
        // 因为时单链表，我们找到的temp时位于添加位置的前一个节点，否则加入失败
        HeroNode temp = head;
        boolean flag = false; // 标识添加的编号是否存在，默认为false
        while (true){
            // 说明temp在链表最后
            if (temp.next == null) {
                System.out.println("在链表最后");
                break;
            }

            // 位置找到， 就在temp的后面插入
            if(temp.next.no > heroNode.no){
                break;
            }

            // 说明编号存在
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }

            // 后移
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("插入的编号%d已经存在，插入失败", heroNode.no);
        }else {
            //插入到链表中， temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    // 修改节点信息，根据编号no来修改，no不能修改
    // 根据新节点编号来修改
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        // 找到需要修改的节点， 根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                // 标识遍历结束
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点,不能修改", temp);
        }
    }

    // 删除节点
    // head节点不能动，需要一个辅助节点，找到待删除节点的前一个节点
    // 说明 我们在比较时，是让temp.next.no和需要删除的节点的no进行比较
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("已经遍历到最后了");
                break;
            }

            if (temp.next.no == no){
                // 找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d不存在无法删除", no);
        }
    }

    // 显示链表 通过遍历
    public void list(){
        // 先判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        // 头节点不懂，需要一个辅助节点
        HeroNode temp = head.next;
        while (true){
            // 判断是否到链表最后
            if (temp == null){
                break;
            }

            System.out.println(temp);

            temp = temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }

    // head 链表的头节点
    // 返回有效节点的个数，没有统计头节点
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++ ;
            cur = cur.next;
        }
        return length;
    }

    // 编写一个方法接收 head节点，同时接收一个index
    // index 表示倒数第index个节点
    // 先把链表从头到尾遍历，得到链表的总的长度
    // 得到size后，从链表的第一个开始遍历 size-index 个
    // 找到返回该节点，没有返回空
    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            return null;
        }
        // 第一次遍历得到链表的长度(节点的个数)
        int size = getLength(head);
        // 第二次遍历 size - index位置，就是我们倒数的第K个节点
        // 先做一个index的校验
        if (index <= 0 || index > size){
            return null;
        }
        // 定义 以辅助遍历，for循环定位到倒数的index个
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 单链表的反转
    public static void reverseList(HeroNode head){
        // 如果链表为空，或只有一个节点，无须反转，直接返回
        if (head.next == null || head.next.next == null){
            return;
        }

        // 定义一个辅助指针(变量) 帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null; // 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，并完成从头遍历原来的链表，每遍历一个节点，就将其出来，放在reverseHead的最前端
        while (cur != null){
            next = cur.next; // 暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next; // 将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; // 将cur连接到新的链表上
            cur = next; // 让cur指向下一个节点，后移
        }
        // 将 head.next 指向 reversehead.next 实现单链表反转
        head.next = reverseHead.next;
    }

    // 实现逆序打印 栈
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        // 创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 将链表的所有节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next; // 压入下一个节点
        }
        // 将栈中的节点进行打印 pop()
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    // 合并两个有序的单链表，合并之后链表依然有序

    public static void combineList(HeroNode head1,HeroNode head2){
        HeroNode next1 = head1.next;
        HeroNode next2 = head2.next;

        // 合并后的表头
        HeroNode joinedHead = new HeroNode(0, "", "");
        if (head1.next == null){
            joinedHead.next = head2.next;
        }else if (head1.next == null) {
            joinedHead.next = head1.next;
        }
        // 合并后的链表
        SingleLinkedList joinedLinkedList = new SingleLinkedList();
        HeroNode nextJoined = joinedHead;
        joinedLinkedList.head = nextJoined;
        while (next1 != null || next2 != null) {
            if (next1 == null && next2 != null){
                nextJoined.next = next2;
                next2 = next2.next;
            }else if (next1 != null && next2 == null){
                nextJoined.next = next1;
                next1 = next1.next;
            }else {
                if (next1.no <= next2.no){
                    nextJoined.next = next1;
                    next1 = next1.next;
                }else {
                    nextJoined.next = next2;
                    next2 = next2.next;
                }
            }
            nextJoined = nextJoined.next;
        }
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.list2(joinedHead);
    }

    // 显示链表，通过遍历
    public void list2(HeroNode headNode) {
        // 先判断链表是否为空
        if (headNode.next == null){
            System.out.println("链表为空");
            return;
        }

        // 因为头节点不能动，需要一个变量
        HeroNode temp = headNode.next;
        while (true){
            // 判断是否到链表最后
            if (temp == null){
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
