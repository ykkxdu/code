package 华为机考;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str_A=scanner.nextLine();
        String str_B=scanner.nextLine();
        List<String> list=new ArrayList<>();
        list.add(str_A);
        list.add(str_B);
        for(int i=0;i<list.size();i++){
            System.out.println(get(list.get(i)));
        }
    }
    public  static String get(String str){
        String data="";
        if(str.length()<8) {
            int n = 8 - str.length();
            for (int j = 0; j < n; j++) {
                data += "0";
            }
            data=str+data;
        }else {
            System.out.println(str.substring(0,8));
            return get(str.substring(8,str.length()-1));
        }
          return data;
    }
}
