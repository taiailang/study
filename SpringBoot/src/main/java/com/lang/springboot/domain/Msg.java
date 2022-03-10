package com.lang.springboot.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Msg {
    private int code;
    private double acc;
    private String msg;
    private String base64;
}
