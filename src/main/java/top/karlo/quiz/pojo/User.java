package top.karlo.quiz.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * @Data注解能给pojo类添加set get equals hashCode toString 等方法
 */

@Data
public class User implements UserDetails {
    private Integer id;

    private String username;

    private String password;

    private String uniqueSalt;

    private String email;

    private String telephone;

    private String image;

    private String lastIp;

    private Date lastTime;

    private String extra1;

    private String extra2;

    private String extra3;

    private Set<GrantedAuthority> grantedAuthoritySet;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}