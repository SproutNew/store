package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;

import cn.itcast.store.dao.UserDao;
import cn.itcast.store.domain.User;
import cn.itcast.store.service.UserService;
import cn.itcast.store.utils.BeanFactory;

public class UserServiceImp implements UserService {
	UserDao UserDao=(UserDao)BeanFactory.createObject("UserDao");
	
	@Override
	public User userLogin(User user01) throws SQLException {
		return UserDao.userLogin(user01);
	}
	
	@Override
	public User findUserByUsreName(String um) throws SQLException{

		return UserDao.findUserByUsreName(um);
		
	}

	@Override
	public void userRegist(User user01) throws SQLException{
		//3_调用业务层注册功能
		UserDao.userRegist(user01);	
	}

	@Override
	public User userActive(String code) throws SQLException {
		return UserDao.userActive(code);
		
	}

	@Override
	public void updateUser(User user01) throws SQLException {
		UserDao.updateUser(user01);
	}
	
}
