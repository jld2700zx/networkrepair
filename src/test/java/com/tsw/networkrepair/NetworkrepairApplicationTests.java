package com.tsw.networkrepair;

import com.tsw.networkrepair.problem_list.dao.ProblemDao;
import com.tsw.networkrepair.user.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NetworkrepairApplicationTests {
	@Autowired
	LoginService loginService;
	@Autowired
	ProblemDao problemDao;
	@Test
	public void contextLoads()  {
		System.out.println(problemDao.select(4));
	}


}
