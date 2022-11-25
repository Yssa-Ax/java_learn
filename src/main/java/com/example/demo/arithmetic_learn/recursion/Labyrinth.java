package com.example.demo.arithmetic_learn.recursion;

/**
 * @author Administrator
 * @description 递归 迷宫问题
 * @since 2022/11/25 14:27
 **/
public class Labyrinth {
    public static void main(String[] args) {
        // 迷宫问题
        // 0 表示该点没有走过   1 表示墙  2 表示通路可以走，但是走不通
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                map[0][j] = 1;
                map[7][j] = 1;
                map[i][0] = 1;
                map[i][6] = 1;
            }
        }

        // 设置挡板  1
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("迷宫走过之后地图");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    *  通过递归回溯来给小球找路
    *  说明
    *   map 表示地图
    * i, j 表示从地图哪个位置开始出发(1, 1)
    * 如果小球能找到map[6][5]位置，则说明通路找到了
    * 当map[i][j]为0，表示该点没有走过  1 墙  2 通路可以走  3 已做过，
    * 再走迷宫时，需要确定一个策略(方法)， 下->右->上->左 如果该点走不通，在回溯
    *
    * */
    private static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map, i + 1, j)){ // 下
                    return true;
                }else if (setWay(map, i, j + 1)){ // 右
                    return true;
                }else if (setWay(map, i - 1, j)){ // 上
                    return true;
                }else if (setWay(map, i, j - 1)){ // 左
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }

}
