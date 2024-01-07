package com.jason.linenotifyproject.service;

import com.jason.linenotifyproject.dto.SendNotifyRequest;
import com.jason.linenotifyproject.util.ResultResponse;

public interface LineNotifyService {
    ResultResponse<String> sendNotify(SendNotifyRequest sendNotifyRequest);
}
