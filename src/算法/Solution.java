package 算法;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //试一下滑窗
        char[] arr1 = str1.toCharArray();
        System.out.println(arr1[1]);
        char[] arr2 = str2.toCharArray();
        int i=1;
        int j=0;
        while(j<arr1.length&&j<arr2.length){
            if(arr1[j]==arr2[j]){
                j++;
            }else{
                return "";
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        char a='a';
        int n=0;
        queue.offer(arr1[0]);
        while(i<arr1.length){

            if(arr1[i]==a){
                n++;
                continue;
            }
            a=arr1[i];
            if(arr1[i]!=queue.peek()){
                queue.offer(arr1[i]);
                n++;
            }else{
                break;
            }
            i++;
        }
        return str1.substring(0,n+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("LEET",
                "CODE"));
    }
}