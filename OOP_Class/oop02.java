package OOP_Class;

import java.util.Scanner;

public class oop02 {
    public static void main(String[] args) {
        String borderName = "sym";
        String flightName = "C919";
        String sitNumber = "16A";
        long tel = 7368;
        Double price = 699.50;
        String bordeTime = "2024/9/4 12:00";
        Boolean isBorde = true;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请验证您的手机号后四位以查看航班信息：");
            long isTel = sc.nextInt();
            if (isTel == tel) {
                System.out.println("您的姓名是：" + borderName);
                System.out.println("您的航班号是：" + flightName);
                System.out.println("您的登机时间是：" + bordeTime);
                System.out.println("您的座位号是：" + sitNumber);
                System.out.println("您的票价是：" + price);
                System.out.println("是否登机：" + ((isBorde) ? "是" : "否"));
                return;
            } else System.out.println("验证失败");
        }
    }
}
