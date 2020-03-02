
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
//class Solution2 {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre=null;
//        ListNode cur=null;
//        while(head.next!=null){
//          cur=head;
//          head=head.next;
//          cur.next=pre;
//          pre=cur;
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(3);
//        listNode.next.next.next=new ListNode(4);
//        listNode.next.next.next.next=new ListNode(5);
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.reverseList(listNode).val);
//
//    }
//}
//class Solution {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode linked = new ListNode(0);
//        ListNode linked1 = linked;
//        int val=0;
//        while (l1 != null && l2 != null) {
//            linked.val = l1.val + l2.val;
//            linked.next = new ListNode(0);
//            if (val == 1) {
//                linked1.val += 1;
//                val = 0;
//            }
//            if (linked1.val >= 10) {
//                linked1.val = linked1.val % 10;
//                val = 1;
//            }
//            linked = linked.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        if (l1 == null) {
//            linked.next = l2;
//        }
//        if (l2 == null) {
//            linked.next = l1;
//        }
////        int val = 0;
//        linked = linked1;
////        while (linked1 != null) {
////            if (val == 1) {
////                linked1.val += 1;
////                val = 0;
////            }
////            if (linked1.val >= 10) {
////                linked1.val = linked1.val % 10;
////                val = 1;
////            }
////            linked1 = linked1.next;
////        }
//        return linked;
//    }

//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(2);
//        listNode2.next.next = new ListNode(3);
//        listNode2.next.next.next = new ListNode(4);
//        listNode2.next.next.next.next = new ListNode(5);
//        Solution solution = new Solution();
//        System.out.println(solution.addTwoNumbers(listNode, listNode2).val);

//
//    }
//}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode linked = new ListNode(0);
        ListNode linked1 = linked;
        ListNode linked2=new ListNode(0);
        int val=0;
        while (l1!= null && l2!=null) {
            linked.val = l1.val + l2.val;
            if (val == 1) {
                linked.val += 1;
                val = 0;
            }
            if (linked.val >= 10) {
                linked.val = linked.val % 10;
                val = 1;
            }
            if(l1.next!=null&&l2.next!=null){
                linked.next = new ListNode(0);
                linked = linked.next;
            }
            linked2=linked1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            linked.next = l1;
        }
        if (l2 != null) {
            linked.next = l2;
        }

        linked = linked1;
        if(val==1){
            linked2.next=new ListNode(1);
        }
        return linked;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
//        listNode2.next.next.next = new ListNode(4);
//        listNode2.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(listNode, listNode2).val);


    }

}