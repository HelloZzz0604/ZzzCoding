package com.zzzcoding.service;

import com.zzzcoding.model.Resource;
import com.zzzcoding.model.Users;

import java.util.List;

/**
 * @author Wenjie Zhang
 * @date 2/10/2022 11:47 pm
 */
public interface IUsersCacheService {
    /**
     * delete admin user
     * @param userId
     */
    void delAdminUserByUserId(Long userId);

    /**
     * delete by user
     * @param usersId
     */
    void delResourceListByUserId(Long usersId);

    /**
     * delete by role
     * @param roleId
     */
    void delResourceListByRoleId(Long roleId);

    /**
     * delete by role ids
     * @param roleIds
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * delete by resource id
     * @param resourceId
     */
    void delResourceListByResourceId(Long resourceId);

    /**
     * delete by username
     * @param username
     * @return
     */
    Users getAdminUserByUsername(String username);

    /**
     * set admin
     * @param users
     */
    void setAdminUser(Users users);

    /**
     * get resource list
     * @param usersId
     * @return
     */
    List<Resource> getResourceListByUserId(Long usersId);

    /**
     * set resource list
     * @param adminId
     * @param resourceList
     */
    void setResourceList(Long adminId, List<Resource> resourceList);
}
