class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int cur=0;
        int rig=nums.length-1;
        while(cur<=rig){
            if(nums[cur]==0){
                int temp=nums[left];
                nums[left]=nums[cur];
                nums[cur]=temp;
                left++;
                cur++;
            }
            else if(nums[cur]==1){
                cur++;
            }
            else{
                int temp=nums[cur];
                nums[cur]=nums[rig];
                nums[rig]=temp;
                rig--;
            }
        }
    }
}