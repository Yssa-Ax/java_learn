package com.example.demo.arithmetic_learn.oneLinkedList;

/**
 * @author Administrator
 * @description 单向链接测试
 * @since 2022/11/23 14:07
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"公孙胜","入云龙 ");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero2);

        //按照编号加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();
        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2,"小卢","*玉麒麟*");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改之后的链表：");
        singleLinkedList.list();

        HeroNode head = singleLinkedList.getHead();
        int length = SingleLinkedList.getLength(head);
        System.out.println(length);
        System.out.println("反转之后的链表：");
        SingleLinkedList.reverseList(head);
        singleLinkedList.list();
        //删除一个节点
//        System.out.println("删除一个节点：");
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);
//        singleLinkedList.del(4);
//        singleLinkedList.list();





        //创建一个链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        //按照编号加入
        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero2);

        HeroNode hero5 = new HeroNode(5,"关胜","大刀");
        HeroNode hero6 = new HeroNode(6,"林冲","豹子头");
        HeroNode hero7 = new HeroNode(7,"秦明","霹雳火");
        HeroNode hero8 = new HeroNode(8,"呼延灼","双鞭 ");


        //创建一个链表
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        //按照编号加入

        singleLinkedList2.addByOrder(hero6);
        singleLinkedList2.addByOrder(hero7);
        singleLinkedList2.addByOrder(hero8);
        singleLinkedList2.addByOrder(hero5);


        SingleLinkedList.combineList(singleLinkedList1.getHead(),singleLinkedList2.getHead());



    }
}
