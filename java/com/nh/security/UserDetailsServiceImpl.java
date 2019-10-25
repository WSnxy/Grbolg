package com.nh.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nh.pojo.Role;
import com.nh.pojo.User;
import com.nh.service.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("用户名为空!");
		}
		User user = userService.getUserByName(username);
		if(Objects.isNull(user)) {
			throw new UsernameNotFoundException("用户不存在!");
		}
//		加入角色权限
		List<GrantedAuthority> authorities=new ArrayList<>();
		for (Role role:user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

}
