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
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //加入按照编号的顺序
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        //显示一把
        singleLinkedList.list();
       //测试修改节点的代码
        HeroNode newheroNode = new HeroNode(2, "小路", "小尾巴");
singleLinkedList.update(newheroNode);
        System.out.println("修改后链表");
        singleLinkedList.list();
        //删除一个节点
        System.out.println("删除一个");
        singleLinkedList.del(4);
        singleLinkedList.list();
        System.out.println();
        System.out.println(getLength(singleLinkedList.getHead()));//2
        //测试一下看看是否得到了倒数第k个节点
        HeroNode res=findLastIndexNode(singleLinkedList.getHead(),2);
        System.out.println(res);
    }
    //方法:获取到单链表的节点的个数(如果是带头节点的链表,需求不统计头节点)
    /**
     *heronode链表的头节点
     * 返回有效节点的个数.
     */
    public static int getLength(HeroNode heroNode){
        if (heroNode.next==null){
            return 0;
        }
        int length=0;
        //定义一个辅助变量,这里我们没有统计头节点
        HeroNode cur=heroNode.next;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }




//查找单链表中的倒数第k个节点[新浪面试题]
//思路
//1.编写一个方法接受head节点,同时接受一个index
//2.inidex表示的是倒数index个节点
//3.先把链表从头到尾遍历,得到链表的总的长度getlength
//4.得到size后,从链表的第一个开始遍历,(size-index个),就可以得到了
public static HeroNode findLastIndexNode(HeroNode head,int index){
        //如果链表为空,返回null
    if(head.next==null){
        return null;//没有找到
    }
    //第一个遍历得到链表的长度
    int size=getLength(head);
    //第二次遍历,size-index位置,这就是我们倒数的第k个节点
    //先做一个index的校验
    if(index<=0||index>size){
        return null;
    }
    //定义一个辅助变量,for循环定位到倒数的index
    HeroNode cur=head.next;
    for(int i=0;i<size-index;i++){
        cur=cur.next;
    }
    return  cur;
}


}














//定义SingleLinkedList管理我們的英雄
class SingleLinkedList{
    //初始化一個頭結點
    private HeroNode head=new HeroNode(0,"","");
//返回头节点
    public HeroNode getHead() {
        return head;
    }

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
    //第二种方式添加英雄时,根据排名将英雄插入到指定位置
    //(如果有这个排名,则添加失败,并给出提示.)
    public void addByOrder(HeroNode heroNode){
      //因为头节点不能动,因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表,因为我们找到的temp时位于添加位置的前一个节点,否则加插入不了.
        HeroNode temp=head;
        boolean flag=false;//添加的编号是否存在,默认为false
        //这个循环就是找位置,并不是找到位置直接插入,这也是为什么break,找到位置就跳出
        while(true){
            if(temp.next==null){
                //说明temp已经到了链表的最后了
                break;
            }
            if(temp.next.no>heroNode.no){
                //位置找到,就到temp的后面插入.因为要按顺序插入,所以找到第一个比要插入节点大的节点.
                break;
            }else if(temp.next.no==heroNode.no){
                flag=true;
                break;

            }
            temp=temp.next;
        }
        //判断falg的值
        if(flag){
            //不能添加,说明编号存在
            System.out.printf("准备插入的英雄的编号%d 已经存在了,不能加入\n",heroNode.no);
        }else{
            heroNode.next=temp.next;//将加入节点的指针指向下一个节点(temp.next是一个值,表示temp下一个节点)
            temp.next=heroNode;//(temp.next在这里是一个指针)
        }
    }
    //修改节点的信息,根据编号来修改,既no编号不能改
    //说明
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
        return;
        }
        //找到需要的节点,根据no编号
        //定义一个辅助变量
        HeroNode temp=head.next;
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
//删除节点
    //思路
    //1.head不能动,因此我们需要一个temp辅助节点找到删除节点的前一个节点.
    //2.说明我们在比较时,是temp.next.no和需要删除的节点的no比较
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;//标识是否找到待删除节点的
        while(true){
            if(temp.next==null){
                //已经到了链表的最后
                break;
            }
            if (temp.next.no==no){
                //找到了待删除节点的前一个结点temp
                flag=true;
                break;
            }
            temp=temp.next;//temp后移,遍历
        }
        //判断flag
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.printf("要删除的%d节点不存在\n",no);
        }
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

