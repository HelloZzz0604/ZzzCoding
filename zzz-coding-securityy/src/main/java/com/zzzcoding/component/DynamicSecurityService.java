package com.zzzcoding.component;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Wenjie Zhang
 * @date 3/10/2022 10:57 pm
 */
public interface DynamicSecurityService {

    /**
     * 加载数据
     * @return
     */
    Map<String, ConfigAttribute> loadDataSource();

}

