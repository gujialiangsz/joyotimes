package com.qiushui.joyotimes.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qiushui.joyotimes.domain.entity.SystemConfig;

@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfig, Integer>{

	public void deleteAll();
}
