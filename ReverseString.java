//344. Reverse String
public class ReverseString {
    public static String reverseString(String s) {
        char[] s_array = s.toCharArray();
        int len = s_array.length;
        char[] reversed_array = new char[len];        
        for (int i = len; i > 0; i--){
            reversed_array[len - i] =  s_array[i - 1];            
        }        
        return new String(reversed_array);
    }
    
    public static void main(String[] args){
        //unit test
        System.out.println(reverseString("Hello"));
        System.out.println(reverseString("what"));
    }

}