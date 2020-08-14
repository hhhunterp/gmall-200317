package com.atguigu.utils;

/**
 * @Author: HunterP
 * @Date: 2020/8/14 18:12
 * @DESC:
 */
public class RanOpt<T>{
    T value ;
    int weight;

    public RanOpt ( T value, int weight ){
        this.value=value ;
        this.weight=weight;
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
