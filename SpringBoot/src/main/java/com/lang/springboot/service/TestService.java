package com.lang.springboot.service;

import com.lang.springboot.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 浪浪
 * @date 2022/2/25
 *
 * Transactional 开通事务
 */

//@Transactional
@Service
public interface TestService {

    String test();

    String testAnnotation();
}
