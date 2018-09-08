import java.util.Arrays;
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine){
        char[] ransomNoteArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        Arrays.sort(ransomNoteArray);
        //printArray(ransomNoteArray);
        Arrays.sort(magazineArray);
        //printArray(magazineArray);
        
        int i = 0;
        int j = 0;
        int ransomNoteLength = ransomNoteArray.length;
        int magazineLength = magazineArray.length;
        if (ransomNoteLength > magazineLength){
            return false;
        }
        while(i < ransomNoteLength && j < magazineLength){
            
            if(ransomNoteArray[i] > magazineArray[j]){
                //System.out.println(">" + ransomNoteArray[i] + ", " +  magazineArray[j]);
                j++;
            }else if (ransomNoteArray[i] < magazineArray[j]){
                 //System.out.println("< " + ransomNoteArray[i] + ", " +  magazineArray[j]);
                return false;
            }else {
                //System.out.println("= " + ransomNoteArray[i] + ", " +  magazineArray[j]);
                i++;
                j++;
            }            

        }       

        if(i >= ransomNoteLength){
            return true;
        }else{
            return false;
        }    
    }
    
    public static void main(String[] args){
       System.out.println(canConstruct("badcfab", "ytrersa"));//false
       System.out.println(canConstruct("aa", "aab"));//true
       System.out.println(canConstruct("bcb", "cjjajdfaaeegig"));//false
       System.out.println(canConstruct("djfjfhjf", "aaigcbiafifghhdihcfdjjej"));//true
    }
    
    public static void printArray(char[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
         System.out.println();
    }
}