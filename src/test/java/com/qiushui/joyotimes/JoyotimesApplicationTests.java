package com.qiushui.joyotimes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qiushui.joyotimes.domain.dao.SystemConfigRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JoyotimesApplication.class})

public class JoyotimesApplicationTests {
	@Autowired
	SystemConfigRepository systemConfigRepository;
	@Test
	public void contextLoads() {
		System.out.println(systemConfigRepository.findAll());;
	}

}
