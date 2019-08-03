package 去除重复的字符串HW;

import java.util.*;

public class Solution {
    /**
     * 去掉重复的字符串并按ASSIC排序
     * a=97 A=65
     * */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        char[] array=str.toCharArray();
        Set<Character> list=new TreeSet<>();
        BitSet bitSet=new BitSet(str.length());
        List<Character> temp=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(!temp.contains(array[i])) {
                temp.add(array[i]);
            }else {
                list.add(array[i]);
                bitSet.set(array[i]);
            }
        }
        System.out.println(list);
        System.out.println(bitSet);

    }

}
