/**
 * 21. 合并两个有序链表
 */
class ListNode {
    int val;
    ListNode next;   // 下一个链表对象
    ListNode(int x) { val = x; }  //赋值链表的值
}
public class Solution_21 {

    ListNode l3;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode l3;
        ListNode l4;
        if (l1.val>=l2.val){
            l3=new ListNode(l2.val);
            l4=l3;
            l2=l2.next;
        }else {
            l3=new ListNode(l1.val);
            l4=l3;
            l1=l1.next;
        }

        while(l1!=null || l2!=null){
            if (l1==null||l1.val>=l2.val){
                ListNode l=new ListNode(l2.val);
                l3.next=l;
                l3=l;
                l2=l2.next;
            }else{
                ListNode l=new ListNode(l1.val);
                l3.next=l;
                l3=l;
                l1=l1.next;
            }
        }


        return l4;
    }
//    public void tostring(ListNode l3) {
//        while(l3!=null){
//            System.out.println(l3.val);
//            l3=l3.next;
//        }
//    }

//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.next=new ListNode(3);
//        listNode.next.next=new ListNode(4);
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next=new ListNode(3);
//        listNode1.next.next=new ListNode(5);
//        Solution_21 solution = new Solution_21();
//        solution.tostring(solution.mergeTwoLists(listNode,listNode1));
//
//    }
}