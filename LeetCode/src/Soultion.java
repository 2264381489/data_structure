
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=null;
        while(head.next!=null){
          cur=head;
          head=head.next;
          cur.next=pre;
          pre=cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverseList(listNode).val);

    }
}