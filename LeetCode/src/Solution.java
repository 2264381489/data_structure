class Solution {
    public int removeDuplicates(int[] nums) {
        int number = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != number) {
                number = nums[i];
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{-1, 0, 0, 0, 0, 3, 3}));
    }

//官方题解（比你这个简洁一百倍！！！）
    public int removeDuplicates1(int[] nums) {
      
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

