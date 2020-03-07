//class Solutio {
//    public int removeDuplicates(int[] nums) {
//        int number = Integer.MAX_VALUE;
//        int flag = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != number) {
//                number = nums[i];
//                nums[flag] = nums[i];
//                flag++;
//            }
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) {
//        Solution solutio = new Solution();
//        System.out.println(solution.removeDuplicates(new int[]{-1, 0, 0, 0, 0, 3, 3}));
//    }
//
////官方题解（比你这个简洁一百倍！！！）
//    public int removeDuplicates1(int[] nums) {
//
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }
//}
//
class Solution {
    public int maxSubArray(int[] nums) {
        int i=0;
        int total=0;
        int ans=0;
        while(i<nums.length){
            //如果大于0就是sum加上下一个元素就是递增，如果小于0则递减
            //如果出现递减的情况，则没有必要加入，将其作为新一个子串的开始
            //继续运行
            if(total>=0){
                total+=nums[i];
            }else{
                total=nums[i];
            }
//这里这个比较大小的地方可以轻松的完成比较。
            ans=Math.max(ans,total);
            i++;
        }
        return ans;
    }
}