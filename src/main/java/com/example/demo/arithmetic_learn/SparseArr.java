package com.example.demo.arithmetic_learn;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Administrator
 * @description 稀疏数组
 * @since 2022/11/22 14:16
 **/
public class SparseArr {
    /*当一个数组总部分元素是0,或者为同一值的数组，可以用稀疏数组来保存改数据*/
    /*
     * 二维数组 转 稀疏数组的思路
     * 1. 遍历 原始的二位数组，得到有效数据的个数 sum
     * 2. 根据sum 就可以创建 稀疏数组 sparseArr int[sum + 1][3]
     * 3. 将二维数组的有效数据存入到 稀疏数组
     *
     * 稀疏数组转原始的二维数组的思路
     * 1. 读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，
     * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组即可
     * */

    public static void sparseArrayToIO(int[][] sparseArr) throws Exception{
        System.out.println("将稀疏数组存入磁盘");
        File file = new File("F:\\learn\\java_learn\\src\\main\\resources\\files\\sparseArr.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        for(int i =0; i < sparseArr.length; i++) {
            for(int j = 0; j < 3; j++) {
                writer.write(sparseArr[i][j]);
            }
        }
        writer.flush();
        writer.close();
    }

    //从磁盘中读取稀疏数组
    public static int[][] sparseArrFromIO(int lines) throws Exception {
        System.out.println("从磁盘中读取稀疏数组");
        FileReader reader = new FileReader("F:\\learn\\java_learn\\src\\main\\resources\\files\\sparseArr.txt");
        int getNum = 0;
        int[][] sparseArray = new int[lines][3];
        for(int i = 0;i < lines;i++) {
            for (int j = 0; j < 3; j++) {
                getNum = reader.read();
                sparseArray[i][j] = getNum;
            }
        }
        return sparseArray;
    }


    /**
     * @return void
     * @author Administrator
     * @description
     * @since 2022/11/22 14:21
     */
    public static void ArrSparseArrTransfer() {
        // 创建一个原始的二维数组
        // 0表示没有棋子， 1 黑子， 2 蓝字
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组的思路
        // 1. 先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        // 2. 创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];

        // 3.稀疏数组复制
        sparseArr[0][0] =  11;
        sparseArr[0][1] =  11;
        sparseArr[0][2] =  sum;

        // 遍历二维数组，将非0的值存放到稀疏数组种
        int count = 0; // 用来记录第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println("稀疏数组");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sparseArr2[][] = new int[sum + 1][3];
        try {
            sparseArrayToIO(sparseArr);
            sparseArr2 = sparseArrFromIO(3);
            for (int[] row : sparseArr2) {
                for (int data : row) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        //稀疏数组恢复成原始的二维数组
        //1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        //2、再读取稀疏数组后几行的数据(从第二行开始)，并赋给原始的二维数组即可
        for(int i = 1;i<sparseArr2.length;i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }


        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ArrSparseArrTransfer();
    }
}
