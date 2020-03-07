package linkdelist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
//进行测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        //显示一把
        singleLinkedList.list();


        //加入

    }
}
//定义SingleLinkedList管理我們的英雄
class SingleLinkedList{
    //初始化一個頭結點
    private HeroNode head=new HeroNode(0,"","");
    //添加節點到單項列表
    //思路当不考虑编号顺序时
    //1.找到当前链表的最后的节点
    //2.将最后这个节点的next指向新的节点

    public void add(HeroNode heroNode){
        //因为head节点不能动,因此我们需要一个辅助的遍历temp
        HeroNode temp=head;
        //遍历链表找到最后
        while (true){
            //找到链表的最后了
            if (temp.next==null){
                //
                break;
            }
            temp=temp.next;
            //如果没有找到最后
        }
        temp.next=heroNode;
    }
    //显示链表
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此我们需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while (true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息(因为已经重写节点的toString了)
            System.out.println(temp);
            //将temp向后移,
            temp=temp.next;
        }
    }
}
//定义一个heronode（链表节点），每个heronode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
    //为了显示方法，我们重新toString
}
