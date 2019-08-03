package 打印机队列优先级HW;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(9);
        queue.add(3);
        queue.add(5);
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        for (Integer k:queue){
            map.put(k,i);
            i++;
        }
        for(int m=9;m>0;m--){
            if(queue.contains(m)){
                System.out.print(map.get(m)+",");
            }
        }
    }
}
