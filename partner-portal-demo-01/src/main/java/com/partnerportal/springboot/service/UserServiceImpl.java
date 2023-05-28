package com.partnerportal.springboot.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.partnerportal.springboot.bean.UserBean;
import com.partnerportal.springboot.dao.RoleRepository;
import com.partnerportal.springboot.dao.UserDao;
import com.partnerportal.springboot.dao.UserRolesRepository;
import com.partnerportal.springboot.dao.ViewRelProjectUserDao;
import com.partnerportal.springboot.entity.Role;
import com.partnerportal.springboot.entity.User;
import com.partnerportal.springboot.entity.UsersRoles;
import com.partnerportal.springboot.user.CrmUser;
import com.partnerportal.springboot.utility.EntityConverter;

@Service
public class UserServiceImpl implements UserService
{

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private ViewRelProjectUserDao viewPartnerDao;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName)
	{
		// check the database if the user already exists
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public Integer save(CrmUser crmUser)
	{
		User user = new User();

		// assign user details to the user object
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());

		// save user in the database
		return userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		User user = userDao.findByUserName(userName);

		if(user == null)
		{
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		List<Integer> userRolesList = userRolesRepository.findUserRolesIds(user.getId());
		Collection<Role> roles = roleRepository.findByRoleIds(userRolesList);

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(roles));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles)
	{
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<UserBean> findUsersAssociatedToProject(int idProject)
	{
		return EntityConverter.generateRelUserProjectBeanList(viewPartnerDao.findUserAssociatedToProject(idProject));
	}

	public User getLoggedUser()
	{
		return userDao.getLoggedUser();
	}

	@Override
	@Transactional
	public void updateUser(User user)
	{
		userDao.save(user);
	}

	@Override
	public void assignRoleToUser(Integer idUser, Integer idRole)
	{
		UsersRoles usersRoles = new UsersRoles(idUser, idRole);

		userRolesRepository.save(usersRoles);

	}
}
