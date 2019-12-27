package software.mybatis.service;

import software.mybatis.entity.TUser;
import software.mybatis.mapper.TUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource(name="tUserMapper")
	private TUserMapper userMapper;

	@Override
	public TUser getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
}
