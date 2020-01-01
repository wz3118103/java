package software.mybatis.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.mybatis.spring.entity.TUser;
import software.mybatis.spring.mapper.TUserMapper;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private TUserMapper userMapper;

	@Override
	public TUser getUserById(Integer id) {
		logger.info("start");
		return userMapper.selectByPrimaryKey(id);
	}
}
