package com.lang.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class OssConstant {

    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String endpoint;
}

