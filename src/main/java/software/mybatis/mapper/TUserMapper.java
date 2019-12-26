package software.mybatis.mapper;

import software.mybatis.entity.TUser;

public interface TUserMapper {

    TUser selectByPrimaryKey(Integer id);

}
