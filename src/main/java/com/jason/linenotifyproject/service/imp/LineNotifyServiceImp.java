package com.jason.linenotifyproject.service.imp;

import com.jason.linenotifyproject.dto.SendNotifyRequest;
import com.jason.linenotifyproject.service.LineNotifyService;
import com.jason.linenotifyproject.util.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;


@Service
public class LineNotifyServiceImp implements LineNotifyService {
    @Value("${line.notify.token}")
    private String lineNotifyToken;

    private final RestTemplate restTemplate;
    @Autowired
    private  LineNotifyServiceImp (RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public ResultResponse<String> sendNotify(SendNotifyRequest sendNotifyRequest) {
        ResultResponse<String> rs = new ResultResponse<>();
        String url = "https://notify-api.line.me/api/notify";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + lineNotifyToken);
        headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));

        try {
            String message = URLEncoder.encode(sendNotifyRequest.getMessage(), StandardCharsets.UTF_8.toString());//設定編碼 防止中文亂碼
            String requestBody = "message=" + message;
            if(!sendNotifyRequest.getStickerPackageId().trim().isEmpty() &&!sendNotifyRequest.getStickerId().trim().isEmpty()){
                requestBody+="&stickerPackageId="+sendNotifyRequest.getStickerPackageId();
                requestBody+="&stickerId="+sendNotifyRequest.getStickerId();
            }

            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                rs.setCode(200);
                rs.setData("送出成功");
            } else {
                rs.setCode(responseEntity.getStatusCodeValue());
                rs.setData("失敗");
            }
        } catch (UnsupportedEncodingException e) {
            // 處理編碼異常
            rs.setCode(500); // 500 表示服务器内部錯誤
            rs.setData("送出異常");
        }

        return rs;

    }
}
