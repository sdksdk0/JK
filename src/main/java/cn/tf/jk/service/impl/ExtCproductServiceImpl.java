package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.service.ExtCproductService;
import cn.tf.jk.service.ExtCproductService;

@Service
public class ExtCproductServiceImpl implements ExtCproductService{

	@Autowired
	private ExtCproductDao  extCproductDao;
	
	@Override
	public List<ExtCproductC> findPage(Page page) {
		
		return null;
	}

	@Override
	public List<ExtCproductC> find(Map paraMap) {
		
		return extCproductDao.find(paraMap);
	}

	@Override
	public ExtCproductC get(Serializable id) {
		
		return extCproductDao.get(id);
	}

	@Override
	public void insert(ExtCproductC factory) {
		
		factory.setExtCproductId(UUID.randomUUID().toString());
		
		extCproductDao.insert(factory);
		
	}

	@Override
	public void update(ExtCproductC entity) {
		extCproductDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		extCproductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.delete(ids);
		
	}





}
