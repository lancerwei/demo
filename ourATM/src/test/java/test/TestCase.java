package test;

import org.junit.Test;

import dao.UserInfoDao;
import user.UserInfo;

public class TestCase {
	@Test
	public void test1(){
		UserInfoDao dao = new UserInfoDao();
		UserInfo user = dao.findByCard1("88880001");
		System.out.println(user);
	}
}
