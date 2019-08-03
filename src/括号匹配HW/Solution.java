package 括号匹配HW;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    /**
     *1.	给定一个字符串，里边可能包含“()”、“[]”、“{}”三种括号，
     * 请编写程序检查该字符串中的括号是否成对出现，且嵌套关系正确。
    * */
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (true){
            String str=scanner.next();
            System.out.println(check(str));
        }
    }
    public static boolean check(String str){
       // char[] array=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                stack.push(str.charAt(i));
            }else {
                char c=stack.peek();// 出栈  stack.peek()取栈顶值（不出栈）
                if(str.charAt(i)==')'&&c=='('){
                    stack.pop();
                    continue;
                }else if(str.charAt(i)==']'&&c=='['){
                    stack.pop();
                    continue;
                }else if(str.charAt(i)=='}'&&c=='{'){
                    stack.pop();
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
