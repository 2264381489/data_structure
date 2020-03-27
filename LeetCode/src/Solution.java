import java.util.HashMap;

//////import java.lang.reflect.Array;
//////import java.util.ArrayList;
//////import java.util.Arrays;
//////import java.util.HashMap;
//////import java.util.Map;
//////
////////class Solutio {
////////    public int removeDuplicates(int[] nums) {
////////        int number = Integer.MAX_VALUE;
////////        int flag = 0;
////////        for (int i = 0; i < nums.length; i++) {
////////            if (nums[i] != number) {
////////                number = nums[i];
////////                nums[flag] = nums[i];
////////                flag++;
////////            }
////////        }
////////        return flag;
////////    }
////////
////////    public static void main(String[] args) {
////////        Solution solutio = new Solution();
////////        System.out.println(solution.removeDuplicates(new int[]{-1, 0, 0, 0, 0, 3, 3}));
////////    }
////////
//////////官方题解（比你这个简洁一百倍！！！）
////////    public int removeDuplicates1(int[] nums) {
////////
////////        int i = 0;
////////        for (int j = 1; j < nums.length; j++) {
////////            if (nums[j] != nums[i]) {
////////                i++;
////////                nums[i] = nums[j];
////////            }
////////        }
////////        return i + 1;
////////    }
////////}
////////
////////class Solution {
////////    public int maxSubArray(int[] nums) {
////////        int i=0;
////////        int total=0;
////////        int ans=0;
////////        while(i<nums.length){
////////            //如果大于0就是sum加上下一个元素就是递增，如果小于0则递减
////////            //如果出现递减的情况，则没有必要加入，将其作为新一个子串的开始
////////            //继续运行
////////            if(total>=0){
////////                total+=nums[i];
////////            }else{
////////                total=nums[i];
////////            }
//////////这里这个比较大小的地方可以轻松的完成比较。
////////            ans=Math.max(ans,total);
////////            i++;
////////        }
////////        return ans;
////////    }
////////}
////////class Solution {
////////
////////        public int lengthOfLastWord(String s) {
////////            if(s.length()==0){return 0;}
////////            boolean flag=true;
////////            int num=s.length()-1;
////////            if (s.charAt(num)==' '){
////////                flag=false;
////////            }
////////            for(int i=s.length()-1;i>=0;i--){
////////                if(s.charAt(i)!=' '&&!flag){
////////                    flag=true;
////////                    num=i;
////////                }
////////                if (s.charAt(i)==' '&&flag){
////////                    return num-i==0?1:num-i;
////////                }
////////            }
//////////            return s.charAt(s.length()-1)==' '?0:s.length();
////////            return flag?num+1:0;
////////        }
////////
////////
////////    public static void main(String[] args) {
////////        Solution solution = new Solution();
////////        System.out.println( solution.lengthOfLastWord("Hello World"));
////////    }
////////}
////////class Solution {
////////    public int[] getLeastNumbers(int[] arr, int k) {
////////        Arrays.sort(arr);
////////        return Arrays.copyOfRange(arr, 0, k);
////////    }
////////}
//////class Solution {
//////    public int minIncrementForUnique(int[] A) {
//////        int[] arr=new int[8000];//最坏情况
//////        //构建一个数组内元素在数轴上的分布
//////        for(int x:A)arr[x]++;
//////
//////        ///(要改变成的状体)-(不改变的状态)
//////        int taken=0;//确定找到每一个位置了
//////        int back=0;
//////        for(int i=0;i<8000;i++){
//////            if(arr[i]>=2){
//////                taken+=arr[i]-1;
//////                back-=i*(arr[i]-1);
//////            }
//////            else if (taken > 0 && arr[i] == 0) {
//////                taken--;
//////                back += i;
//////
//////            }
//////        }
//////                 return back;
//////    }
//////}
////class Solution {
////    public String addBinary(String a, String b) {
////        StringBuilder ans = new StringBuilder();
////
////        int flag = 0;
////        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
////            int sum = 0;
////            sum += (i > 0 ? a.charAt(i)-'0' : 0);
////            sum += (j > 0 ? b.charAt(i)-'0' : 0);
////            System.out.println(sum);
////            ans.append(sum % 2);
////            flag = sum / 2;
////        }
////        ans.append(flag == 1 ? flag : "");
////        return ans.reverse().toString();
////    }
////
////    public static void main(String[] args) {
//////        Solution solution = new Solution();
////        int i='1'-'0';
////        System.out.println(i);
////    }
////}
////
////
//
//class Solution {
//    public int mySqrt(int x) {
//        if(x<2)return x;
//        long num;
//       int left=2;
//       int right=x/2;
//       int pricot;
//       while(right>=left){
//           pricot=left+(right-left)/2;
//           num=(long)pricot*pricot;
//           if (num>x) right=pricot-1;
//           else if(num<x) left=pricot+1;
//           else return pricot;
//       }
//
//       return right;
//    }
//
//    public static void main(String[] args) {
//
//        Solution solution = new Solution();
//        System.out.println( solution.mySqrt(2147395599));
//    }
//}
//class Solution {
//    public int massage(int[] nums) {
//        if(nums.length==0)return 0;
//        if (nums.length==1)return nums[0];
//        //动态规划,这个采用了分类讨论的思想
//        //[2,7,9,3,1]为例
//        //如果你在7的位置上.有两种情况1.工作2.不工作
//        //于是用数组表示就是len[i][1]与len[i][0]
//        //这个二维数组的值记录经过的路径的总值
//        int [][] len=new int[nums.length][2];
//        len[0][0]=0;
//        len[0][1]=nums[0];
//        //遍历这个数组,用二维数组的值作为记录
//        for(int i=1;i<=nums.length-1;i++){
//            //假如你在9位置上
//            //len[i][0]代表你不工作
//            //有两种可能1.昨天你工作了2.昨天你不工作
//            //那么我们只要找出两种可能中最大的一种就可以
//            len[i][0]=Math.max(len[i-1][0],len[i-1][1]);
//            //如果jin'tian'gong
//            len[i][1]=len[i-1][0]+nums[i];
//        }
//        return Math.max(len[nums.length-1][0],len[nums.length-1][1]);
//    }
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.massage(new int[]{2,7,9,3,1}));
//    }
// }
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> HashMap = new HashMap<>();

        for (int i1 : deck) {
            if (!HashMap.containsKey(i1)) {
                int value=1;
                HashMap.put(i1,value);
            }else{
                HashMap.put(i1,HashMap.get(i1)+1);
            }
        }
        int flag=HashMap.get(deck[0]);
        for(int i2 :deck){
            flag=gcd(flag,HashMap.get(i2));
            if (flag==1)return false;

        }
        return  flag>=2;
    }
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.hasGroupsSizeX(new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3}));
    }
}