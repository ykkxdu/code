package 拼多多笔试.拼多多笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<Integer> list_A=new ArrayList<>();
        List<Integer> list_B=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        String[] str_A=scanner.nextLine().split(" ");
        String[] str_B=scanner.nextLine().split(" ");
        for(String s:str_A){
            list_A.add(Integer.valueOf(s));
        }
        for(String s:str_B){
            list_B.add(Integer.valueOf(s));
        }
        int m=-1;
        //找出不符合的位置
        for(int i=0;i<list_A.size()-1;i++){
            if(list_A.get(i)<list_A.get(i+1)){
                continue;
            }else {
                m=i;
                list.add(i);
                list.add(i+1);
                if(i+2<list_A.size()){
                    list.add(i+1);
                }
                break;
            }

        }
        int[] data=new int[100];
        for(int i=0;i<list_B.size();i++){
            data[i]=list_B.get(i);
        }
        int num=-1;
        Arrays.sort(data);
        if(list.size()==3){
             num=maxNum(list_A.get(m),data,list_A.get(m+2));
            if(num==-1){
                int s=minNum(list_A.get(m+1),data);
                if(s!=-1){
                    list_A.set(m,num);
                }else {
                    num=-1;
                }
            }else {
                list_A.set(m+1,num);
            }
        }else {
             num=maxNum(list_A.get(m),data);
             if(num==-1){
                 int s=minNum(list_A.get(m+1),data,list_A.get(m-1));
                 if(s!=-1){
                     list_A.set(m,num);
                 }else {
                     num=-1;
                 }
             }else {
                 list_A.set(m+1,num);
             }
        }
        if(num==-1){
            System.out.println(false);
        }else {
            for (int i = 0; i < list_A.size(); i++) {
                System.out.print(list_A.get(i) + " ");
            }
        }
    }

    public static int minNum(int s,int[] data){
        int num=-1;
        for(int i=0;i<data.length;i++){
            if(s>data[i]){
                num=data[i];
            }
        }
        return num;
    }
    public static int minNum(int s,int[] data,int n){
        int num=-1;
        for(int i=0;i<data.length;i++){
            if(s>data[i]&&data[i]>n){
                num=data[i];

            }
        }
        return num;
    }
    public static int maxNum(int s,int[] data,int n){
        int num=-1;
        for(int i=0;i<data.length;i++){
            if(s<data[i]&&data[i]<n){
                num=data[i];
            }
        }
        return num;
    }
    public static int maxNum(int s,int[] data){
        int num=-1;
        for(int i=0;i<data.length;i++){
            if(s<data[i]){
                num=data[i];
            }
        }
        return num;
    }
}
