package com.badao.ssm.ssmTemplate.main;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.badao.ssm.ssmTemplate.mapper.UserMapper;
import com.badao.ssm.ssmTemplate.pojo.User;
import com.badao.ssm.ssmTemplate.utils.SqlSessionFactoryUtils;
public class MybatisMain {

	public static void main(String[] args) {
		testUserMapper();
		
		
	}
	private static void testUserMapper() {
		Logger log = Logger.getLogger(MybatisMain.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//测试查询
			/*Role role = roleMapper.getRole(1l);
			log.info(role.getRoleName());*/
			//测试更新
			/*Role role3 = new Role();
			role3.setId(1l);
			role3.setRoleName("YSH");
			role3.setNote("测试更新");
			int updateResult = roleMapper.updateRole(role3);*/
			
			//测试插入
			/*testInsert();
			User user =new User();
			user.setUserName("霸道");
			user.setRemark("测试");
			int insertResult = userMapper.insertUser(user);
			if(insertResult == 0) {
				System.out.println("插入失败");
				log.info("插入失败");
			}else {
				System.out.println("插入成功");
				log.info("插入成功");
			}*/
			
			//测试查询
			/*User user2 = userMapper.getUser(1);
			log.info("查询到的用户名为："+user2.getUserName());*/
			
			//测试更新
			/*User user3 = new User();
			user3.setId(1);
			user3.setUserName("霸道------");
			user3.setRemark("更新成功了");
			int updateResult = userMapper.updateUser(user3);
			if(updateResult == 0) {
				System.out.println("更新失败");
				log.info("更新失败");
			}else {
				System.out.println("更新成功");
				log.info("更新成功");
			}*/
			
			//测试删除
			/*int deleteResule = userMapper.deleteUser(1);
			if(deleteResule == 0) {
				System.out.println("删除失败");
				log.info("删除失败");
			}else {
				System.out.println("删除成功");
				log.info("删除成功");
			}*/
			
			//测试模糊查询
			/*List<User> userList = userMapper.findUsers("霸");
			for (User user : userList) {
				System.out.println(user.getUserName());
			}*/
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	private static void testInsert() {
		// TODO Auto-generated method stub
		
	}
	
}