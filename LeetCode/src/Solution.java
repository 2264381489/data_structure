//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
////class Solutio {
////    public int removeDuplicates(int[] nums) {
////        int number = Integer.MAX_VALUE;
////        int flag = 0;
////        for (int i = 0; i < nums.length; i++) {
////            if (nums[i] != number) {
////                number = nums[i];
////                nums[flag] = nums[i];
////                flag++;
////            }
////        }
////        return flag;
////    }
////
////    public static void main(String[] args) {
////        Solution solutio = new Solution();
////        System.out.println(solution.removeDuplicates(new int[]{-1, 0, 0, 0, 0, 3, 3}));
////    }
////
//////官方题解（比你这个简洁一百倍！！！）
////    public int removeDuplicates1(int[] nums) {
////
////        int i = 0;
////        for (int j = 1; j < nums.length; j++) {
////            if (nums[j] != nums[i]) {
////                i++;
////                nums[i] = nums[j];
////            }
////        }
////        return i + 1;
////    }
////}
////
////class Solution {
////    public int maxSubArray(int[] nums) {
////        int i=0;
////        int total=0;
////        int ans=0;
////        while(i<nums.length){
////            //如果大于0就是sum加上下一个元素就是递增，如果小于0则递减
////            //如果出现递减的情况，则没有必要加入，将其作为新一个子串的开始
////            //继续运行
////            if(total>=0){
////                total+=nums[i];
////            }else{
////                total=nums[i];
////            }
//////这里这个比较大小的地方可以轻松的完成比较。
////            ans=Math.max(ans,total);
////            i++;
////        }
////        return ans;
////    }
////}
////class Solution {
////
////        public int lengthOfLastWord(String s) {
////            if(s.length()==0){return 0;}
////            boolean flag=true;
////            int num=s.length()-1;
////            if (s.charAt(num)==' '){
////                flag=false;
////            }
////            for(int i=s.length()-1;i>=0;i--){
////                if(s.charAt(i)!=' '&&!flag){
////                    flag=true;
////                    num=i;
////                }
////                if (s.charAt(i)==' '&&flag){
////                    return num-i==0?1:num-i;
////                }
////            }
//////            return s.charAt(s.length()-1)==' '?0:s.length();
////            return flag?num+1:0;
////        }
////
////
////    public static void main(String[] args) {
////        Solution solution = new Solution();
////        System.out.println( solution.lengthOfLastWord("Hello World"));
////    }
////}
////class Solution {
////    public int[] getLeastNumbers(int[] arr, int k) {
////        Arrays.sort(arr);
////        return Arrays.copyOfRange(arr, 0, k);
////    }
////}
//class Solution {
//    public int minIncrementForUnique(int[] A) {
//        int[] arr=new int[8000];//最坏情况
//        //构建一个数组内元素在数轴上的分布
//        for(int x:A)arr[x]++;
//
//        ///(要改变成的状体)-(不改变的状态)
//        int taken=0;//确定找到每一个位置了
//        int back=0;
//        for(int i=0;i<8000;i++){
//            if(arr[i]>=2){
//                taken+=arr[i]-1;
//                back-=i*(arr[i]-1);
//            }
//            else if (taken > 0 && arr[i] == 0) {
//                taken--;
//                back += i;
//
//            }
//        }
//                 return back;
//    }
//}
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int flag = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = 0;
            sum += (i > 0 ? a.charAt(i)-'0' : 0);
            sum += (j > 0 ? b.charAt(i)-'0' : 0);
            System.out.println(sum);
            ans.append(sum % 2);
            flag = sum / 2;
        }
        ans.append(flag == 1 ? flag : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
        int i='1'-'0';
        System.out.println(i);
    }
}


