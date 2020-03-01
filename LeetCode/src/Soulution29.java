class solution29 {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int flag=0;
        while(left<right){
            if(nums[left]==target){
                return left;
            }
            if(nums[right]==target){
                return nums.length-right+1;
            }
            if(nums[left]>target){
                flag=left;
                break;
            }
            if(nums[right]<target){
                flag=nums.length-right+1;
                break;
            }

            left++;
            right--;
        }
//        int i=0;
//        int num=nums[flag];
////        nums[flag]=target;
//        for (int j=nums.length;j>nums.length-flag;j--){
//           nums[j]=nums[nums.length-1-i];
//           i++;
//        }
//        nums[flag]=target;
        return flag;
    }

    public static void main(String[] args) {
        solution29 solution29 = new solution29();
        int[] nums ={1,3,5,6};
        System.out.println(solution29.searchInsert(nums,2));
    }
}