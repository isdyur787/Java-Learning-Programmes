package DataStructure;

import java.util.Scanner;

//环形数组队列
public class d3_circleArrayQueue_huanxingduilie {
    public static void main(String[] args) {
        //创建队列对象
        CircleArrayQueue aq = new CircleArrayQueue(4);
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


class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头 指向队列头部（包含数据） 初始0
    private int rear;//尾 指向队列尾的后一个位置（不包含队列最后一个数据）初始值是0
    private int[] arr;//该数组用于存放数据 模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，添加数据失败");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //rear后移 需要考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据（数据出队列）
    public int getQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空，获取数据失败");//因为是int类型的方法 所以没法return 用抛异常的方法解决
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，显示数据失败");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出队列中有效的数据长度
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头部数据（不是取出数据）
    public int headQueue(){
        if(isEmpty())
            throw new RuntimeException("队列为空，没有头部数据");
        return arr[front];
    }
}
