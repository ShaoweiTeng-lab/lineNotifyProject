package com.jason.linenotifyproject.dto;

import lombok.Data;

@Data
public class SendNotifyRequest {
    //訊息
    private  String message;
    private  String stickerPackageId;
    //貼紙ID
    private  String stickerId;
}
