package com.colorfulword.smallbluewhale.security;

import com.colorfulword.smallbluewhale.dao.UserDao;
import com.colorfulword.smallbluewhale.domain.Role;
import com.colorfulword.smallbluewhale.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userDao.findByUserNumber(username);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        System.out.println(user.getRole().getRoleName());
        return new org.springframework.security.core.userdetails.User(user.getUserNumber(),
                user.getCode(), authorities);

    }

}
