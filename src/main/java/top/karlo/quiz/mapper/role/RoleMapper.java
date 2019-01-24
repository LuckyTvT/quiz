package top.karlo.quiz.mapper.role;

import top.karlo.quiz.annotation.DataSource;
import top.karlo.quiz.pojo.Role;

import java.util.List;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/18 14:08
 */

@DataSource("quziUser")
public interface RoleMapper {

    List<Role> getRoleByUserId(String userId);

}
