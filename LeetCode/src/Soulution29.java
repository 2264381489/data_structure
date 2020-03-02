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
                return right;
            }
            if(nums[left]>target){
                flag=left;
                return flag;
            }
            if(nums[right]<target){
                flag=right+1;
                return flag;
            }

            left++;
            right--;
        }
        if(right<=left){flag=right+1;}
        return flag;
    }

    public static void main(String[] args) {
        solution29 solution29 = new solution29();
        int[] nums ={1,3};
        System.out.println(solution29.searchInsert(nums,2));
    }
}