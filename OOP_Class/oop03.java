package OOP_Class;

import java.util.Scanner;

public class oop03 {
    static String name;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputName(sc);
        outputName();
    }

    public static void inputName(Scanner sc){
        System.out.println("请输入姓名：");
        name = sc.next();
    }

    public static void outputName(){
        System.out.println("你的名字是：" + name);
    }
}
