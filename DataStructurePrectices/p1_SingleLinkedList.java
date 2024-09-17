package DataStructurePrectices;

public class p1_SingleLinkedList {
    public static void main(String[] args) {
        //创建链表
        SingleLinkedList sll = new SingleLinkedList();
        //创建节点
        FriendNode fn1 = new FriendNode(1, "sym", 19);
        FriendNode fn2 = new FriendNode(2, "jwx", 20);
        FriendNode fn3 = new FriendNode(3, "zyf", 18);
        FriendNode fn4 = new FriendNode(4, "scz", 19);
        FriendNode fn5 = new FriendNode(5, "swy", 18);
        FriendNode fn6 = new FriendNode(6, "lhy", 20);

        sll.addHeroByOrder(fn1);
        sll.addHeroByOrder(fn2);
        sll.addHeroByOrder(fn3);
        sll.addHeroByOrder(fn4);
        sll.addHeroByOrder(fn5);
        sll.addHeroByOrder(fn6);

        System.out.println(sll.getLength(sll.getHead()));
    }
}

class SingleLinkedList{
    private FriendNode head = new FriendNode(0,"", 0);

    public FriendNode getHead() {
        return head;
    }

    /**
     * @param head 链表的头节点
     * @return 返回的是有效节点的个数
     */
//获取到单链表的有效节点的个数（不统计头节点）
    public static int getLength(FriendNode head){
        if(head.next == null)
            return 0;
        int length = 0;
        FriendNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;//忽略头节点
        }
        return length;
    }

    //第二种添加方式：根据排名将英雄插入到指定位置
    public void addHeroByOrder(FriendNode newHero){
        FriendNode temp = head;
        boolean flag = false;//标志添加的编号是否存在 默认false
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > newHero.no){//位置找到，在temp后插入即可
                break;
            } else if (temp.next.no == newHero.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag值
        if(flag){
            //不能添加 编号存在
            System.out.println("待插入的英雄编号" + temp.next.no + "已存在，插入失败");
        } else {
            newHero.next = temp.next;
            temp.next = newHero;
        }
    }
}

class FriendNode{
    public int no;
    public String name;
    public int age;
    public FriendNode next;//指向下一个节点
    //构造器
    public FriendNode(int no, String name, int age){
        this.no = no;
        this.name = name;
        this.age = age;
    }

    //为了显示方便 重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}

