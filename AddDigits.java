public class AddDigits{
    public static int addDigits(int num) {
        if (num / 10 == 0){
            return num;
        }else{
            int sum = 0;
            while(num > 0){
                sum = sum + num % 10;
                num = num / 10;                
            }  
            return addDigits(sum);
        }
    }
    
    public static void main(String[] args){
        //Unit test
        System.out.println("num = 38, result = " + addDigits(38));
        System.out.println("num = 9999, result = " + addDigits(9999));
    }
}