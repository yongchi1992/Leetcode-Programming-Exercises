/**
 * Created by yongchizhang on 17/6/20.
 */
public class LoopinLinkedList {
    public int findDuplicate(int[] nums) {
        int slow = nums.length;
        int fast = nums.length;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow!=fast);
        slow = nums.length;
        while(slow!=fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
