package com.easymemo.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class KaptchaController {

    private final Producer captchaProducer;

    public KaptchaController(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @GetMapping("/verify")
    public void verify(HttpServletResponse response, HttpSession session) throws IOException {
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String captchaProducerText = captchaProducer.createText();
        System.out.println("verify====>captchaProducerText:"+captchaProducerText);

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, captchaProducerText);

        // create the image with the text
        BufferedImage bufferedImage = captchaProducer.createImage(captchaProducerText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bufferedImage, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
