package com.zzzcoding.service.impl;

import com.zzzcoding.model.Menu;
import com.zzzcoding.mapper.MenuMapper;
import com.zzzcoding.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台菜单表 服务实现类
 * </p>
 *
 * @author Wenjie Zhang
 * @since 2022-12-04
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
