package com.weirdo.demo.dao;

import com.weirdo.demo.dataobject.UserInfoDO;

public interface IUserInfoDAO {
    int deleteUserInfoByID(Long id);

    int insertUserInfo(UserInfoDO record);

    int insertUserInfoSelective(UserInfoDO record);

    UserInfoDO getUserInfoByID(Long id);

    int updateUserInfoByIDSelective(UserInfoDO record);

    int updateUserInfoByID(UserInfoDO record);
}