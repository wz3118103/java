package software.mybatis.demo.mapper;

import org.apache.ibatis.annotations.Param;
import software.mybatis.demo.entity.TJobHistory;
import software.mybatis.demo.entity.TUser;

import java.util.List;

public interface TJobHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TJobHistory record);

    int insertSelective(TJobHistory record);

    TJobHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TJobHistory record);

    int updateByPrimaryKey(TJobHistory record);
    
    List<TJobHistory> selectByUserId(int userId);
    
    List<TUser> selectByEmailAndSex2(@Param("email") String email, @Param("sex") Byte sex);
}