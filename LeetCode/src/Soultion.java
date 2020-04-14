import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//////import java.util.ArrayList;
//////import java.util.Collection;
//////import java.util.Collections;
//////
//////////import java.lang.reflect.Array;
////////
////////import java.lang.reflect.Array;
////////import java.util.ArrayList;
////////import java.util.Arrays;
////////
//////////import java.lang.reflect.Array;
//////////import java.util.Arrays;
//////////
////////////import java.lang.reflect.Array;
////////////
//////////////
//////////////class ListNode {
//////////////      int val;
//////////////      ListNode next;
//////////////      ListNode(int x) { val = x; }
//////////////  }
////////////////class Solution2 {
////////////////    public ListNode reverseList(ListNode head) {
////////////////        ListNode pre=null;
////////////////        ListNode cur=null;
////////////////        while(head.next!=null){
////////////////          cur=head;
////////////////          head=head.next;
////////////////          cur.next=pre;
////////////////          pre=cur;
////////////////        }
////////////////        return head;
////////////////    }
////////////////
////////////////    public static void main(String[] args) {
////////////////        ListNode listNode = new ListNode(1);
////////////////        listNode.next=new ListNode(2);
////////////////        listNode.next.next=new ListNode(3);
////////////////        listNode.next.next.next=new ListNode(4);
////////////////        listNode.next.next.next.next=new ListNode(5);
////////////////        Solution2 solution2 = new Solution2();
////////////////        System.out.println(solution2.reverseList(listNode).val);
////////////////
////////////////    }
////////////////}
////////////////class Solution {
////////////////    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
////////////////        ListNode linked = new ListNode(0);
////////////////        ListNode linked1 = linked;
////////////////        int val=0;
////////////////        while (l1 != null && l2 != null) {
////////////////            linked.val = l1.val + l2.val;
////////////////            linked.next = new ListNode(0);
////////////////            if (val == 1) {
////////////////                linked1.val += 1;
////////////////                val = 0;
////////////////            }
////////////////            if (linked1.val >= 10) {
////////////////                linked1.val = linked1.val % 10;
////////////////                val = 1;
////////////////            }
////////////////            linked = linked.next;
////////////////            l1 = l1.next;
////////////////            l2 = l2.next;
////////////////        }
////////////////        if (l1 == null) {
////////////////            linked.next = l2;
////////////////        }
////////////////        if (l2 == null) {
////////////////            linked.next = l1;
////////////////        }
//////////////////        int val = 0;
////////////////        linked = linked1;
//////////////////        while (linked1 != null) {
//////////////////            if (val == 1) {
//////////////////                linked1.val += 1;
//////////////////                val = 0;
//////////////////            }
//////////////////            if (linked1.val >= 10) {
//////////////////                linked1.val = linked1.val % 10;
//////////////////                val = 1;
//////////////////            }
//////////////////            linked1 = linked1.next;
//////////////////        }
////////////////        return linked;
////////////////    }
//////////////
////////////////    public static void main(String[] args) {
////////////////        ListNode listNode = new ListNode(1);
////////////////        listNode.next = new ListNode(2);
////////////////        listNode.next.next = new ListNode(3);
////////////////        listNode.next.next.next = new ListNode(4);
////////////////        listNode.next.next.next.next = new ListNode(5);
////////////////        ListNode listNode2 = new ListNode(1);
////////////////        listNode2.next = new ListNode(2);
////////////////        listNode2.next.next = new ListNode(3);
////////////////        listNode2.next.next.next = new ListNode(4);
////////////////        listNode2.next.next.next.next = new ListNode(5);
////////////////        Solution solution = new Solution();
////////////////        System.out.println(solution.addTwoNumbers(listNode, listNode2).val);
//////////////
////////////////
////////////////    }
////////////////}
//////////////class Solution {
//////////////    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//////////////        ListNode linked = new ListNode(0);
//////////////        ListNode linked1 = linked;
//////////////        ListNode linked2=new ListNode(0);
//////////////        int val=0;
//////////////        while (l1!= null && l2!=null) {
//////////////            linked.val = l1.val + l2.val;
//////////////            if (val == 1) {
//////////////                linked.val += 1;
//////////////                val = 0;
//////////////            }
//////////////            if (linked.val >= 10) {
//////////////                linked.val = linked.val % 10;
//////////////                val = 1;
//////////////            }
//////////////            if(l1.next!=null&&l2.next!=null){
//////////////                linked.next = new ListNode(0);
//////////////                linked = linked.next;
//////////////            }
//////////////            linked2=linked1;
//////////////            l1 = l1.next;
//////////////            l2 = l2.next;
//////////////        }
//////////////        if (l1 != null) {
//////////////            linked.next = l1;
//////////////        }
//////////////        if (l2 != null) {
//////////////            linked.next = l2;
//////////////        }
//////////////
//////////////        linked = linked1;
//////////////        if(val==1){
//////////////            linked2.next=new ListNode(1);
//////////////        }
//////////////        return linked;
//////////////    }
//////////////    public static void main(String[] args) {
//////////////        ListNode listNode = new ListNode(2);
//////////////        listNode.next = new ListNode(4);
//////////////        listNode.next.next = new ListNode(3);
////////////////        listNode.next.next.next = new ListNode(4);
////////////////        listNode.next.next.next.next = new ListNode(5);
//////////////        ListNode listNode2 = new ListNode(5);
//////////////        listNode2.next = new ListNode(6);
//////////////        listNode2.next.next = new ListNode(4);
////////////////        listNode2.next.next.next = new ListNode(4);
////////////////        listNode2.next.next.next.next = new ListNode(5);
//////////////        Solution solution = new Solution();
//////////////        System.out.println(solution.addTwoNumbers(listNode, listNode2).val);
//////////////
//////////////
//////////////    }
//////////////
//////////////}
//////////////class Solution {
//////////////    public String countAndSay(int n) {
//////////////        String i="1";
//////////////        String[] arr = i.split(",");
//////////////        while(n!=0){
//////////////
//////////////
//////////////
//////////////
//////////////            n--;
//////////////            }
//////////////
////////////
//////////////class Solution {
//////////////    public String countAndSay(int n) {
//////////////        String s="1";
//////////////        if(n==1){
//////////////            return s;
//////////////        }
////////////////        char pre=s.charAt(0);
//////////////        while(n!=1) {
//////////////            StringBuilder str = new StringBuilder();
//////////////            char pre=s.charAt(0);
//////////////            int count = 1;
//////////////            for (int j = 0; j < s.length(); j++) {
//////////////
//////////////                if (str.charAt(j) == pre) {
//////////////                    count++;
//////////////                } else {
//////////////                    str.append(count).append(pre);//
//////////////                    pre = str.charAt(j);//
//////////////                    count=1;//重新计数
//////////////                }
//////////////
//////////////
//////////////
//////////////                n--;
//////////////            }
//////////////        }
//////////////        return s;
//////////////
//////////////    }
//////////////}
//////////////            n--;//移动目标
//////////////        }
//////////////    }
//////////////}
////////////
////////////
////////////class Solution {
////////////    public String countAndSay(int n) {
////////////        String s="1";
////////////        if(n==1)
////////////            return s;
////////////        for(int i=2;i<=n;i++)
////////////        {
////////////            StringBuilder str=new StringBuilder();
////////////            char pre=s.charAt(0);     //取第一个字符作为初始判断
////////////            int count=1;
////////////            for(int j=1;j<s.length();j++)
////////////            {
////////////                if(s.charAt(j)==pre)
////////////                    count++;         //相等即增加改数字数量
////////////                else{
////////////                    str.append(count).append(pre); //不相等的话字符串增加数字和个数
////////////                    pre=s.charAt(j);       ////修改初始判断为不同的数字
////////////                    count=1;                //数目重新为1
////////////                }
////////////            }
////////////            str.append(count).append(pre);  //将最后重复的数字和数量添加
////////////            s=str.toString();
////////////        }
////////////        return s;
////////////
////////////    }
////////////
////////////    public static void main(String[] args) {
////////////        Solution solution = new Solution();
////////////        solution.countAndSay(4);
////////////    }
////////////}
//////////class Solution {
//////////    public int[] merge(int[] A, int m, int[] B, int n) {
//////////        //因为B必定是放在最后的，
//////////        int a=0;
//////////        for(int i=0;i<m;i++) {
//////////            int tmp = 0;
//////////            for (int j = 0; j < n; j++) {
//////////                if (B[j] < A[i]) {
//////////                    tmp = A[i];
//////////                    A[i] = B[j];
//////////                    B[j] = tmp;
//////////                }
//////////            }
//////////
//////////        }
//////////        Arrays.sort(B);
//////////        for(int i=m;i<A.length;i++) {
//////////
////////////                Arrays.sort(B);
//////////            A[i] = B[a];
//////////            a++;
//////////        、、、
//////////
//////////
//////////        return A;
//////////    }
//////////
//////////    public static void main(String[] args) {
//////////        Solution solution = new Solution();
//////////        solution.merge(new int[]{1, 2, 3, 0, 0, 0, 0, 0},3,new int[]{3,4,5,6,7},5);
//////////
//////////    }
//////////}
//////////
//////////
////////class Solution {
////////    public int lengthOfLongestSubstring(String s) {
////////        int i=1;
////////        int total=0;
////////        ArrayList<Integer> ids=new ArrayList<Integer>();
////////        int j=0;
////////        while(i<s.length()){
////////            if(s.charAt(i-1)!=s.charAt(i)){
////////                total++;
////////            }else{
////////                ids.add(total);
////////                total=0;
////////            }
////////            i++;
////////        }
////////        Integer[] arr= ids.toArray(new Integer[ids.size()]);
////////           Arrays.sort(arr);
////////        return arr[arr.length-1];
////////    }
////////
////////    public static void main(String[] args) {
////////        Solution solution = new Solution();
////////        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
////////    }
////////}
//////class Solution {
//////    public int[][] findContinuousSequence(int target) {
//////        float a=0;
//////        float n=1;
//////        ArrayList<int []> ids=new ArrayList<>();
//////        while(n<target){
//////            a=((target/n)-(n-1)/2);
//////            if(a%1==0&&a!=target){
//////                if(a<1){
//////                    break;
//////                }
//////                int [] arr=new int[(int) n];
//////                for(int i=0;i<n;i++){
//////                    arr[i]=(int)a+i;
//////                }
//////                ids.add(arr);
//////            }
////////            if(a<1){
////////                break;
////////            }
//////            n++;
//////        }
//////        int[][] result=ids.toArray(new int[0][]);
//////        Collections.reverse(ids);
//////          return result;
//////
//////    }
//////
//////
//////    public static void main(String[] args) {
//////        Solution solution = new Solution();
//////        System.out.println(solution.findContinuousSequence(9));
//////    }
//////}
////class Solution {
////    public int climbStairs(int n) {
////        int stack[]=new int[100000];
////        return climbStairs(0,n,stack);
////    }
////    public int climbStairs(int i,int n,int stack[]){
////        if (i==n){
////            return 1;
////        }
////        if(i>n){
////            return 0;
////        }
////        int a=climbStairs(i+1,n,stack)+climbStairs(i+2,n,stack);
////        if (stack[i]>0){
////            return stack[i];
////        }
////        stack[i]=a;
////            return a;
////    }
////
////    public static void main(String[] args) {
////        Solution solution = new Solution();
////        System.out.println(solution.climbStairs(44));
////    }
////}
// class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
// }
////class Solution {
////    public ListNode deleteDuplicates(ListNode head) {
////        ListNode head1=head;
////        int [] stack=new int[1000];
////        int i=0;
////     while(head.next!=null){
////         if(head.val!=head.next.val){
////             stack[i]=head.val;
////             i++;
////         }
////         head=head.next;
////     }
////     head=head1;
////     for (int a:stack){
////          head1.next=new ListNode(a);
////          head1=head1.next;
////     }
////     return head;
////}
////
////}
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode cur=head;
//           while(cur!=null&&cur.next!=null){
//               if (cur.val==cur.next.val){
//                   cur.next=cur.next.next;
//               }
//               cur=cur.next;
//           }
//           return head;
//    }
//}
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
////                int [] arr=new int[m+n];//建立中间数组
//        int[] arr = new int[m];
//        System.arraycopy(nums1, 0, arr, 0, m);
//
//
//        int i=0;//一号指针
//        int j=0;//二号指针
//        int flag=0;//下标
//        while(i<m&&j<n){
//            if (arr[i]>nums2[j]){//一号节点大于二号节点,二号节点进入目标数组
//                nums1[flag]=nums2[j];
//                j++;
//            }else{//反之亦然
//                nums1[flag]=arr[i];
//                i++;
//            }
//           nums1[flag]=arr[i]>nums2[j]?nums2[j++]: arr[i++];
//            flag++;//先后运动
//        }
//        if (i<m){
//            while(i<m) {
//                nums1[flag] =arr[i];
//                flag++;
//                i++;
//            }
//        }
//        if (j<n){
//            while(j<n) {
//                nums1[flag] =nums2[j];
//                flag++;
//                j++;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//     solution.merge(new int[]{1,2,3,0,0,0},
//        3,
//         new int[] {2,5,6},
//        3);
//    }
//}
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
// }
//class Solution {
//    public int maxDepth(TreeNode root) {
//        if (0!= root.val){
//            int max=0;
//         return  max=1+Math.max(maxDepth(root.left),maxDepth(root.right));
//        }else {
//            return 0;
//        }
//
////       Math.max(maxDepth(root.left),maxDepth(root.right));
//    }
////    public int maxDepth(TreeNode right,TreeNode left){
////
////    }
//}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        // one of p and q is null
//        if (q == null || p == null) return false;
//        if (p.val != q.val) return false;
//
//       return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
//
//    }
//}
//class Solution {
//    List<List<Integer>> listtotal=new ArrayList<>();
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<Integer> list=new ArrayList<>();
//          if(root.right!=null){
//              list.add(root.right.val);
//          }
//          if (root.left!=null){
//              list.add(root.left.val);
//          }
//          listtotal.add(list)
//                  sout
//                  sout
//                  sout
//    }
//}sout
//class Solution {
//    public TreeNode sortedArrayToBST(int[] nums) {
//        Arrays.sort(nums);
//        return  sortedTree(nums);
//    }
//    int val=0;
//    public TreeNode sortedTree(int[] nums){
//        //root的操作
//        TreeNode root=new TreeNode(nums[val]);
//          val+=1;
//        root.left=sortedTree(nums);
//        root.right=sortedTree(nums);
//        return root;
//    }
//
//}
//class Solution {
//    int[] nums;
//
//    public TreeNode helper(int left, int right) {
//        if (left > right) return null;
//
//        // always choose left middle node as a root
//        int p = (left + right) / 2;
//
//        // inorder traversal: left -> node -> right
//        TreeNode root = new TreeNode(nums[p]);
//        root.left = helper(left, p - 1);
//        root.right = helper(p + 1, right);
//        return root;
//    }
//
//    public TreeNode sortedArrayToBST(int[] nums) {
//        this.nums = nums;
//        return helper(0, nums.length - 1);
//    }
//}
//class Solution {
//    int[] nums;
//    public TreeNode sortedArrayToBST(int[] nums) {
//        this.nums=nums;
//         return tree(0,nums.length-1);
//    }
//    public TreeNode tree(int left,int right){
//        if(left>right){
//          return null;
//        }//退出条件
//        int p=(left+right)/2;//找出中点,奇数是正好那个位置,偶数则是中点左边的位置.[1,2,3,4,5]中点是3,[1,2,3,4,5,6]值为2.5,因为/的特性,所以值为2
//        TreeNode root = new TreeNode(nums[p]);
//        root.left=tree(,p-1);
//        root.right=tree(p+1,nums.length-1);
//        return root;
//    }
//}
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//
//   if (root==null){return true;}
//
//        int a=isisBalanced1(root.left);//遍历左子树
//        int b=isisBalanced1(root.right);//遍历右子树
//        System.out.println(a);
//        System.out.println(b);
//        return Math.abs(a-b)<=1&&;
//    }
//
//    public int isisBalanced1(TreeNode root){
//        int left1=0;
//        int right1=0;
//            if (root==null)return -1;
//       left1=1+isisBalanced1(root.left);
//        System.out.println(root.val+","+left1);
//       right1=1+isisBalanced1(root.right);
//        System.out.println(root.val+","+right1);
//        return Math.max(left1,right1);
//    }
//
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left=new TreeNode(2);
//        treeNode.right=new TreeNode(2);
//        treeNode.left.left=new TreeNode(3);
//        treeNode.left.right=new TreeNode(3);
//        treeNode.left.left.left=new TreeNode(4);
//        treeNode.left.left.right=new TreeNode(4);
//        Solution solution = new Solution();
//        solution.isBalanced(treeNode);
//    }
//}
//class Solution {
//    public int minDepth(TreeNode root) {
//        if (root==null)return 0;
//       int a=1;
//       int b=1;
//         a+=minDepth(root.left);
//        b+=minDepth(root.right);
//        return Math.min(a,b);
//    }
//}
//class Solution {
//    int i=0;
//    public boolean hasPathSum(TreeNode root, int sum) {
//           i++;
//        if (root==null&&sum!=0){return false;}
//        if (i!=1) {
//            if (root == null && sum == 0) return true;
//        }
//
//
//        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
//
//
//    }
//}
//class Solution {
//    public boolean isBalanced(TreeNode root) {
//       if (root==null)return false;
//     return isBalanced1(root)<=1&&isBalanced(root.left)&&isBalanced(root.right);
//    }
//
//    private int isBalanced1(TreeNode root) {
//        int a=0;
//        int b=0;
//        if (root==null) return 0;
//            a=1+isBalanced1(root.left);
//            b=1+isBalanced1(root.right);
//            return Math.min(a,b);
//
//    }
//}
//
class Solution {
    int k=0;
    public int kthLargest(TreeNode root, int k) {
     this.k=k;
     return kthL1(root);
    }
    public int kthL1(TreeNode root){
        if (root==null)return 0;
        int a=kthL1(root.right);
        if (--k==0){return root.val;}
        int b=kthL1(root.left);//遍历的时候,到节点上面再减
        return a+b;
    }

}
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}

