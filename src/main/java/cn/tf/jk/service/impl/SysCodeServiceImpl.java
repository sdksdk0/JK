package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.dao.SysCodeDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.po.SysCodeB;
import cn.tf.jk.service.FactoryCService;
import cn.tf.jk.service.SysCodeService;

@Service
public class SysCodeServiceImpl implements SysCodeService{

	@Autowired
	private SysCodeDao  sysCodeDao;

	@Override
	public List<SysCodeB> find(Map map) {
		
		return sysCodeDao.find(map);
	}
	
	
	
	

}
