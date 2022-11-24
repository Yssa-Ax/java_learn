package com.example.demo.arithmetic_learn.circularChain;

/**
 * @author Administrator
 * @description 环行链解决约瑟夫问题
 * @since 2022/11/24 9:03
 **/
public class Boy {
    private int no;
    private Boy next; // 默认空

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
