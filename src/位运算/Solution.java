package 位运算;

import java.util.BitSet;

public class Solution {
    public static void main(String[] args) {
        final int size=10;
        int A[]={23,44,1,2,34,56,11,7,9,25};
        bitSort(A);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
    }
    public static void bitSort(int[]A)
    {
        int size=A.length;
        final int number_range=6000000;//这个数的大小必须大于数组A中元素的最大值，否则数组A中的后面部分元素不会改变，关键点在下面循环内代码  A[j++]=i 处
        BitSet bits=new BitSet(number_range);
        for(int i=0;i<size;i++)
        {
            bits.set(A[i]);
        }
        for(int i=0,j=0;i<number_range;i++)
        {
            if(bits.get(i))
            {
                A[j++]=i;
            }
        }
        System.out.println("bits的内存："+bits.size());
        //bits增长内存的方式：64,128,192，256,320.。。  即64bits=8bytes的倍数
        //解释：操作系统分配内存时以字节为单位，也就是说分配的内存必须是byte的整数倍，按照这个思路，
        // 似乎只需要7byte =56bit就够了，那为什么又是8byte呢?
        //这又是因为标准库在实现bitset时以一个字为基本单位分配内存的(不是字节)，
        // 也就是说分配的内存大小必定是4byte的整数倍。这里我们虽然浪费了十几个bit的空间，
        //但是比起之前用int类型的数组或者char类型的数组来作为标记，这个程序节约了很多内存的(50个int数据消耗内存200byte，
        // 而50个char数据消耗内存50byte)。
    }
}
