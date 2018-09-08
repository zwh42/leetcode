//leetcode 283. Move Zeroes
public class MoveZeros{    
    public static void moveZeros(int[] nums){
        int length = nums.length;
        int i = 0;
        int zeroCount = 0;;
        int filledIndex = 0;        
        while(i < length){
            if(nums[i] != 0){
                nums[filledIndex] = nums[i];
                filledIndex++;
            }else{
                zeroCount++;
            }
            i++;
        }        
        while(zeroCount > 0){
            nums[length - zeroCount] = 0;
            zeroCount--;
        }
    }
    
    public static void printArray(int[] nums){
        for (int i =0; i < nums.length; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        int[] nums = {0, 1, 0,0,0 ,3,5,4,0, 12};
        printArray(nums);
        System.out.println();        
        moveZeros(nums);
        printArray(nums);        
    }
}