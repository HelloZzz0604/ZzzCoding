package com.zzzcoding.service;

import com.zzzcoding.model.Member;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: Member Service
 *
 * @Author: Wenjie ZHANG
 * @Date: 3/12/2023 9:28 pm
 */
public interface IMemberService {
    @Transactional
    void register(String email, String username, String password);
}
