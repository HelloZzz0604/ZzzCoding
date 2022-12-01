package com.zzzcoding.config;

import com.zzzcoding.component.DynamicSecurityService;
import com.zzzcoding.model.Resource;
import com.zzzcoding.service.IResourceService;
import com.zzzcoding.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wenjie Zhang
 * @date 20/11/2022 7:56 pm
 */
@Configuration
public class CodingmoreSecurityConfig{

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> usersService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<Resource> resources = resourceService.list();
                resources.forEach(item->{
                    map.put(item.getUrl(), new SecurityConfig(item.getResourceId() + ":" + item.getName()));
                });
                return map;
            }
        };
    }
}

