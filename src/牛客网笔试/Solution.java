package 牛客网笔试;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        String data=scanner.next();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        for(int i=data.length()-1;i>=0;i--){
            if(!stack.empty()){
                if(data.charAt(i)=='.'){
                    stack.pop();
                }
                char c=stack.peek();
                if(c=='*'&&data.charAt(i)!='.'){
                    continue;
                }else if(c=='?'){
                    stack.pop();
                    continue;
                }else if(c==data.charAt(i)) {
                    stack.pop();
                    continue;
                }else {
                    System.out.println(false);
                    break;
                }
            }else {
                System.out.println(true);
            }
        }
        System.out.println(true);
    }
}
