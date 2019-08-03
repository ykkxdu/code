package 拼多多笔试;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        //String[] data=str.split(" ");
        //System.out.println(isLink(data));
        char[] array=str.toCharArray();
        List<Character> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(i==0||i==array.length-1){
                list.add(array[i]);
            }
            if(array[i]==' '){
                list.add(array[i-1]);
                list.add(array[i+1]);
            }
        }
        for(int i=0;i<list.size();){
            if(i==0&&list.get(i)!=list.get(list.size()-1)){
                System.out.println(false);
                break;
            }else {
                if(i==0) {
                    i++;
                }
            }
            if(list.get(i)!=list.get(i+1)){
                System.out.println(false);
                break;
            }else {
                if(i+2<list.size()-1){
                    i=i+2;
                    continue;
                }else {
                    System.out.println(true);
                    break;
                }
            }

        }
    }
    public static boolean isLink(String[] s){
        StringBuffer sb=new StringBuffer();
        for(String str:s){
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length()-1));
        }
        List<String> list=listAll(Arrays.asList(sb.toString().split("")),"");
        for(String str:list){
            if(check(str)){
                return true;
            }
        }
        return false;
    }
    public static  boolean check(String str){
        for(int i=1;i<=str.length()-3;i=i+2){
            if(str.charAt(i)!=str.charAt(i+1)){
                return false;
            }
        }
        return  true;
    }

    public  static List<String> listAll(List<String> data,String prefix){
        List<String> list=new ArrayList<>();
        if(data.isEmpty()){
            list.add(prefix);
        }else {
            for(int i=0;i<data.size();i++){
                List temp=new LinkedList(data);
                List<String> results=listAll(temp,prefix+temp.remove(i));
                for(String s:results){
                    list.add(s);
                }
            }
        }
        return list;
    }
}
