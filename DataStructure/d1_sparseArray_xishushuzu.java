package DataStructure;
//稀疏数组：一个数组中大部分元素是0 或同一个数  可以压缩原数组的大小

public class d1_sparseArray_xishushuzu {
    public static void main(String[] args) {
        //1.先创建一个原始的二维数组11*11  0表示无棋子 1黑色棋子 2白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("-------原始的二维数组：-------");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //遍历二维数组 得到非零数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0)
                    sum++;
            }
        }
        //创建对应的稀疏数组
        int sparseArray[][] = new int [sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组把非零的值存放到稀疏数组中
        int count = 0;//用于记录是第几个非零数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("-------得到的稀疏数组是：------");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        System.out.println();

        //稀疏数组恢复原始数组
        //1.先读取稀疏数组的行和列 创建对应的二维数组
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2.读取稀疏数组后几行的数据 赋给原始的二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("-------得到恢复后的二维数组是：------");
        for (int[] rows : chessArray2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
