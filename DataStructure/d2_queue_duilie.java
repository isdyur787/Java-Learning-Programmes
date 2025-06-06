package DataStructure;

import java.util.Scanner;

//队列 使用数组模拟
public class d2_queue_duilie {
    public static void main(String[] args) {
        //创建队列对象
        ArrayQueue aq = new ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner sc = new Scanner(System.in);
        Boolean loop = true;
        while (loop) {
            System.out.println("请输入您的选择：");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列获取数据");
            System.out.println("h(head): 获取队列头部数据");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    aq.showQueue();
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                case 'a':
                    System.out.println("请输入您要添加的数据：");
                    int a = sc.nextInt();
                    aq.addQueue(a);
                    break;
                case 'g':
                    try{
                        int res = aq.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try{
                        int res = aq.headQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
        System.out.println("程序已退出");
    }
}

class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//尾
    private int[] arr;//该数组用于存放数据 模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部的前一个位置（不包含数据）
        rear = -1;//指向队列尾的具体位置（就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，添加数据失败");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据（数据出队列）
    public int getQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空，获取数据失败");//因为是int类型的方法 所以没法return 用抛异常的方法解决
        front++;//后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，显示数据失败");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头部数据（不是取出数据）
    public int headQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空，没有头部数据");
        return arr[front + 1];
    }

}
