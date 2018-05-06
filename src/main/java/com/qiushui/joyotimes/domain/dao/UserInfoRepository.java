package com.qiushui.joyotimes.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qiushui.joyotimes.domain.entity.UserInfo;

@Repository
@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	UserInfo findByUsername(String username);

}
