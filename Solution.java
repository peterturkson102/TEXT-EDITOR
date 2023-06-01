import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner input = new Scanner(System.in);
        
    Editor editor = new Editor();    
    int numberOfOperations = input.nextInt();
    
    for(int counting  = 0; counting<numberOfOperations;counting++){
        
        int operation = input.nextInt();
        switch(operation){
            case 1:
            String W = input.next();
            editor.append(W);
            break;

            case 2:
            int k = input.nextInt();
            editor.delete(k);
            break;

            case 3:
            int K = input.nextInt();
            editor.print(K);
            break;

            case 4:
            editor.undo();
            break;
            
            default:
            System.out.println("Error Input");
            
        }
    
    }
    
    input.close();    
    
    }
}

class Editor{
    //using stringbuilder because of performance as some of the tests will not pass because of the time limit
    StringBuilder S = new StringBuilder();
    List<String> cache = new ArrayList<>();
    int counter  = -1;
    
    public Editor(){
    }
    
    public  void append(String W){
        S.append(W);
        counter++;
        cache.add(S.toString());
        
    }
    
    public void delete(int k){
       int newSize = S.length()-k;
       
       //note that only the start index is included when using substrings. the endindex is not included so no need for -1 to end index
        S = S.delete(newSize, S.length()); 
        counter++;
        cache.add(S.toString());
    }
    
    public void print(int k){
        if(S.length()>0)
        System.out.println(S.charAt(k-1));
    }
    
    public void undo(){
       cache.remove(counter);
       counter--;
       if(counter<0){
        S.setLength(0);
       }else{
           S.setLength(0);
       S.append(cache.get(counter)) ;  
       }
    }
    
}

 
