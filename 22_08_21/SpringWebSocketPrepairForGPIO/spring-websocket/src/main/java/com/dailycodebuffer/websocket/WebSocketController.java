package com.dailycodebuffer.websocket;

import java.security.Principal;
import java.util.Date;

import org.apache.logging.log4j.message.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class WebSocketController {
	
 @GetMapping("/")
 
   public String test() {
    	return "index.html";
    }


}
