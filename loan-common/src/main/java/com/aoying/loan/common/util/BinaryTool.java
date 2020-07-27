package com.aoying.loan.common.util;

/**
 * Created by llfc on 2018/1/11.
 */
public class BinaryTool {

    //求解正数的二进制表示法中的 1 的位数
    public static int countBit(int num){
        int count = 0;
        for(; num > 0; count++)
        {
            num &= (num - 1);
        }
        return count;
    }

    //获取 整数 num 的第 i 位的值
    public static boolean getBit(int num, int i)
    {
        return ((num & (1 << i)) != 0);//true 表示第i位为1,否则为0
    }

    //将 整数 num 的第 i 位的值 置为 1
    public static int setIntegerBit(int num, int i)
    {
        return (num | (1 << i));
    }

    //将 整数 num 的第 i 位的值 置为 0
    public static int getZeroBit(int num, int i)
    {
        int mask = ~(1 << i);//000100
        return (num & (mask));//111011
    }
}
