package DataStructure;
//单链表
public class d4_SingleLinkedList_danlianbiao {
    public static void main(String[] args) {
        //创建节点
        HeroNode hd1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hd2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hd3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hd4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hd5 = new HeroNode(5, "邵昱铭", "YYDS");
        HeroNode hd6 = new HeroNode(6, "蒋文宣", "哈哈哈");

        //创建链表 加入
        SingleLinkedList sll = new SingleLinkedList();
//        sll.add(hd1);
//        sll.add(hd2);
//        sll.add(hd3);
//        sll.add(hd4);
//        sll.add(hd5);
//        sll.add(hd6);
        //按编号加入
        sll.addHeroByOrder(hd1);
        sll.addHeroByOrder(hd4);
        sll.addHeroByOrder(hd6);
        sll.addHeroByOrder(hd2);
        sll.addHeroByOrder(hd5);
        sll.addHeroByOrder(hd3);
        sll.addHeroByOrder(hd3);
        sll.List();

        //测试修改节点代码
        System.out.println("");
        System.out.println("---------------修改后-----------------");
        HeroNode newHeroNode = new HeroNode(5, "sym", "nb");
        sll.update(newHeroNode);
        sll.List();

        //测试删除节点
        System.out.println("");
        sll.delete(1);
        sll.delete(3);
        sll.delete(5);
        System.out.println("---------------删除后-----------------");
        sll.List();
    }
}

//定义SingleLinkedList 管理hero
class SingleLinkedList {
    //先初始化一个头节点 头节点不要动 不存放具体数据
    private HeroNode head = new HeroNode(0,"", "");

    //添加节点到单向链表：找到当前链表的最后节点 将最后这个节点的next指向新的节点
    public void add(HeroNode newNode) {
        //head节点不能动 所以需要一个辅助指针temp
        HeroNode temp = head;
        //遍历链表
        while(true){
            if(temp.next == null){
                //找到链表最后
                break;
            }
            //没找到 指针后移
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //第二种添加方式：根据排名将英雄插入到指定位置
    public void addHeroByOrder(HeroNode newHero){
        HeroNode temp = head;
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

    //修改节点信息 根据编号来修改 no编号不能改  根据传入的newHeroNode的no来修改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp == null)
                break;//已经遍历完整个链表
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号为%d的节点", newHeroNode.no);
        }
    }

    //删除节点
    public void delete(int deleteHeroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (head.next == null) {
                System.out.println("链表为空");
                break;
            }
            if(temp.next == null){//没找到
                break;
            }
            if(temp.next.no == deleteHeroNode){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为%d的节点", deleteHeroNode);
        }
    }
    //显示链表 遍历
    public void List(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode 每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便 重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
