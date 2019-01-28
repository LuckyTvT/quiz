package top.karlo.quiz.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}