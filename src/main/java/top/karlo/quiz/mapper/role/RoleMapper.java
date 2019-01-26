package top.karlo.quiz.mapper.role;

import org.apache.ibatis.annotations.Mapper;
import top.karlo.quiz.pojo.Role;

import java.util.List;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/18 14:08
 */

@Mapper
public interface RoleMapper {

    List<Role> getRoleByUserId(String userId);

}
