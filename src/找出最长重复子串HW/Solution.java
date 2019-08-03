package 找出最长重复子串HW;

import java.util.*;

public class Solution {
    /**
     * 2.	给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，
     * 如果最长的串有多个，请输出字符ASCII码最小的那一串。
     * 例如：输入aaabbbbbcccccccczzzzzzzz，输出cccccccc。
    * */
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        Map<Character,Integer> map=new TreeMap<>();
        char[] array=str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int value=map.get(array[i]);
                map.put(array[i],value+1);
            }
        }
        int count=-1;
         String result="";
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>count){
                count=entry.getValue();
                result=entry.getKey().toString();
            }
        }
        for(int i=0;i<count;i++){
            System.out.print(result);
        }
    }
}
