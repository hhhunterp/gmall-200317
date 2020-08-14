package com.atguigu.gmalllogger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: HunterP
 * @Date: 2020/8/14 18:57
 * @DESC:
 */
@RestController
@Slf4j
//@RestController =@Controller+方法上的@ResponseBody
public class LoggerController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("t1")
    public String test1(){
        System.out.println("******************");
        return "hello demo";
    }

    @RequestMapping("t2")
    public String test2(@RequestParam("name") String nn,@RequestParam("age") int age ){
        System.out.println(nn + ":" + age);
        return "hello demo";
    }

    @RequestMapping("log")
    public String getLogger(@RequestParam("logString") String logString) {

        //添加时间戳
        JSONObject jsonObject = JSON.parseObject(logString);
        jsonObject.put("ts",System.currentTimeMillis());

        //写入日志
        log.info(logString);

        //写入kafka
        if("startup".equals(jsonObject.getString("type"))){
            //写入启动日志主题
            kafkaTemplate.send("TOPIC_START",jsonObject.toString());
        }else{
            //写入事件日志主题
            kafkaTemplate.send("TOPIC_EVENT",jsonObject.toString());
        }

        return "success";
    }

}
