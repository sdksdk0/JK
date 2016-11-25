package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.FactoryCService;

@Service
public class FactoryCServiceImpl implements FactoryCService{

	@Autowired
	private FactoryCDao  factoryCDao;
	
	
	
	
	@Override
	public List<FactoryC> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FactoryC> find(Map paraMap) {
		
		return factoryCDao.find(paraMap);
	}

	@Override
	public FactoryC get(Serializable id) {
		
		return factoryCDao.get(id);
	}

	@Override
	public void insert(FactoryC factory) {
		
		factory.setFactoryId(UUID.randomUUID().toString());
		factory.setState("1");   //启用生产厂家
		factoryCDao.insert(factory);
		
	}

	@Override
	public void update(FactoryC entity) {
		factoryCDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		factoryCDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryCDao.delete(ids);
		
	}

	@Override
	public void start(Serializable[] ids) {
		Map map=new HashMap<>();
		map.put("state", 1);  //启用
		map.put("ids", ids);
		
		factoryCDao.updateState(map);
		
	}

	@Override
	public void stop(Serializable[] ids) {
		Map map=new HashMap<>();
		map.put("state", 0);  //停用
		map.put("ids", ids);
		
		factoryCDao.updateState(map);
		
	}

}
