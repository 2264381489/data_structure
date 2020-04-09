package 算法;

//import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.List;


//
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Solution {
//    public String gcdOfStrings(String str1, String str2) {
//        //试一下滑窗
//        char[] arr1 = str1.toCharArray();
//        System.out.println(arr1[1]);
//        char[] arr2 = str2.toCharArray();
//        int i=1;
//        int j=0;
////        while(j<arr1.length&&j<arr2.length){
////            if(arr1[j]==arr2[j]){
////                j++;
////            }else{
////                return "";
////            }
////        }
//        if(!(str1+str2).equals(str2+str1)){
//            return "";
//        }
//        Queue<Character> queue = new LinkedList<Character>();
//        char a='a';
//        int n=0;
//        queue.offer(arr1[0]);
//        while(i<arr1.length){
//
//            if(arr1[i]==a){
//                n++;
//                i++;
//                continue;
//            }
//            a=arr1[i];
//            if(arr1[i]!=queue.peek()){
//                queue.offer(arr1[i]);
//                n++;
//            }else{
//                if (arr1[i+1]==queue.peek()){
//                    n++;
//                }
//                break;
//            }
//            i++;
//        }
//        return str1.substring(0,n+1);
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.gcdOfStrings("OBCNOOBCNO", "OBCNO"));
//    }
//}
////"OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO"
////        "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO"
//class Solution {
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[Math.round(nums.length/2)];
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
//    }
//}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//
//        return root==null?true:iscure(root.left,root.right);
//    }
//    public boolean iscure(TreeNode left,TreeNode right){
//        if (left==null&&right==null)return true;
//        if(left == null || right == null || left.val != right.val) return false;
//        return iscure(left.left,right.right)&&iscure(left.right,right.left);
//    }
//}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {


        levelOrder(root.left);
        levelOrder(root.right);

    }
}