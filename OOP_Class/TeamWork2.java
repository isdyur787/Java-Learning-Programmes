package OOP_Class;
//计互231 7组邵昱铭
import java.util.Scanner;

//航班管理
public class TeamWork2 {
    static String flightNumber;
    static String departureTime;
    static String arrivalTime;
    static Boolean isTakeOff;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        setFlightNumber(sc);
        getFlightNumber();
        setDepartureTime(sc);
        getDepartureTime();
        setArrivalTime(sc);
        getArrivalTime();
        setIsTakeOff(sc);
        getIsTakeOff();
    }

    //输入航班号
    public static void setFlightNumber(Scanner sc){
        while(true) {
            System.out.println("请输入航班号：");
            String inputFlightNumber = sc.next();
            if (inputFlightNumber.length() >= 4 && inputFlightNumber.length() <= 6) {
                flightNumber = inputFlightNumber;
                return;
            }
            else
                System.out.println("输入航班号格式有误，请重试");
        }
    }

    //输出航班号
    public static void getFlightNumber(){
        System.out.println("此航班号为：" +  flightNumber);
    }

    //输入起飞时间
    public static void setDepartureTime(Scanner sc){
        while(true) {
            System.out.println("请输入起飞时间(格式为Hour:Min)：");
            String inputDepartureTime = sc.next();
            if (inputDepartureTime.length() == 5 && (inputDepartureTime.charAt(2) == ':' || inputDepartureTime.charAt(2) == '：')) {
                departureTime = inputDepartureTime;
                return;
            }
            else
                System.out.println("输入时间格式有误，请重试");
        }
    }

    //输出起飞时间
    public static void getDepartureTime(){
        System.out.println("此航班的起飞时间是：" +  departureTime);
    }

    //输入降落时间
    public static void setArrivalTime(Scanner sc){
        while(true) {
            System.out.println("请输入降落时间(格式为Hour:Min)：");
            String inputArrivalTime = sc.next();
            if (inputArrivalTime.length() == 5 && (inputArrivalTime.charAt(2) == ':' || inputArrivalTime.charAt(2) == '：')) {
                arrivalTime = inputArrivalTime;
                return;
            }
            else
                System.out.println("输入时间格式有误，请重试");
        }
    }

    //输出降落时间
    public static void getArrivalTime(){
        System.out.println("此航班的降落时间是：" +  arrivalTime);
    }

    //输入起飞状态
    public static void setIsTakeOff(Scanner sc){
        System.out.println("请输入航班是否起飞：");
        isTakeOff = sc.nextBoolean();
    }

    //输出起飞状态
    public static void getIsTakeOff(){
        System.out.println("是否起飞：" + (isTakeOff ? "是" : "否"));
    }
}
