package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.*;

import com.app.dao.AdminDao;
import com.app.dao.PersonDao;
import com.app.entity.Admin;
import com.app.entity.Person;

@Service
@Transactional
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Admin updateAdmin(Admin admin, Long id) {
		// TODO Auto-generated method stub
		Admin admin2 = mapper.map(admin,Admin.class);
		admin2.setId(id);
		Admin admin3 = admindao.save(admin2);
		return mapper.map(admin3, Admin.class);
	}
}
