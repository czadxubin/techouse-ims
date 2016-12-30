package cn.techouse.ims.group.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.techouse.ims.group.service.interf.UserGroupService;
import cn.techouse.ims.repositories.UserGroupRepository;

@Service
public class UserGroupServiceImpl implements UserGroupService{
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	
	
}
