package linkdelist;

public class DoubleLinkedListDemo {

    public static void main(String[] args)
    {
        System.out.println("开始创建任务");
//先创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2= new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
//创建双向链表
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();
//修改测试
        HeroNode2 newHeronode=new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeronode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的的链表情况~~~");
        doubleLinkedList.list();
    }


}

//定义一个heronode（双向链表节点），每个heronode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点,默认为null
    public HeroNode2 pre;//指向前一个节点,默认为null
    //构造器

    public HeroNode2(int no, String name, String nickname) {
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
//黄建一个双向链表的类
class DoubleLinkedList{
    //初始化一個頭結點
    private HeroNode2 head=new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }
    //遍历双向链表
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动,因此我们需要一个辅助变量来遍历
        HeroNode2 temp=head.next;
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
    //为节点添加一个双向链表
    public void add(HeroNode2 heroNode){
        //因为head节点不能动,因此我们需要一个辅助的遍历temp
        HeroNode2 temp=head;
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
        //形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    //修改一个节点的内容
    //可以看到双向链表的节点内容修改和单向链表一扬
    public void update(HeroNode2 newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要的节点,根据no编号
        //定义一个辅助变量
        HeroNode2 temp=head.next;
        boolean flag=false;//表示是否找到该节点
        while(true){
            if(temp==null){
                break;//到链表的遍历完毕了.
            }
            if(temp.no==newHeroNode.no){
                //找到了
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            //没有找到
            System.out.printf("没有找到编号等于%d的节点\n",newHeroNode.no);
        }
    }
    //从双向链表中删除一个节点.
    //对于双向链表,我们可以直接找到要删除的节点.
    //找到后自我删除即可.
    public void del(int no){
        //判断当前链表是否为空
        if(head.next==null){
            System.out.println("链表为空,无法删除");
            return;
        }
        HeroNode2 temp=head.next;//辅助变量(指针)
        boolean flag=false;//标识是否找到待删除节点的
        while(true){
            if(temp==null){
                //已经到了链表的最后(最后一个的next)
                break;
            }
            if (temp.no==no){
                //找到了待删除节点的前一个结点temp
                flag=true;
                break;
            }
            temp=temp.next;//temp后移,遍历
        }
        //判断flag
        if(flag){
            temp.pre.next=temp.next;
            //如果是最后一个节点就没必要执行这句话,否则出现空指针.
            //temp.next=null.pre\
            if(temp.next!=null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }

}