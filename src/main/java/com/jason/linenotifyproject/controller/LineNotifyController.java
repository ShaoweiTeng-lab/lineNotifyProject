package com.jason.linenotifyproject.controller;

import com.jason.linenotifyproject.dto.SendNotifyRequest;
import com.jason.linenotifyproject.service.LineNotifyService;
import com.jason.linenotifyproject.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LineNotify")
public class LineNotifyController {
    private  final LineNotifyService lineNotifyService;
    @Autowired
    public  LineNotifyController(LineNotifyService lineNotifyService){
        this.lineNotifyService=lineNotifyService;
    }
    @RequestMapping("/AuthorizeCode")
    public  String authorizeCode(){
        System.out.println( "get Line Notify");
        return  "success";
    }
    @PostMapping("/sendNotify")
    public ResultResponse<String>  sendNotify(@RequestBody SendNotifyRequest sendNotifyRequest){
        ResultResponse<String> rs =lineNotifyService.sendNotify(sendNotifyRequest);
        return  rs;
    }
}
