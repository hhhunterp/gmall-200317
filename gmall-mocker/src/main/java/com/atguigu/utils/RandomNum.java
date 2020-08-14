package com.atguigu.utils;

import java.util.Random;
/**
 * @Author: HunterP
 * @Date: 2020/8/14 18:13
 * @DESC:
 */

public class RandomNum {
    public static int getRandInt(int fromNum,int toNum){
        return   fromNum+ new Random().nextInt(toNum-fromNum+1);
    }
}
