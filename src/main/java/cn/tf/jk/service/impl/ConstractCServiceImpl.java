package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.ContractCDao;
import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.ContractCService;
import cn.tf.jk.service.FactoryCService;

@Service
public class ConstractCServiceImpl implements ContractCService{

	@Autowired
	private ContractCDao  contractCDao;
	
	
	@Override
	public List<ContractC> findPage(Page page) {
		
		return contractCDao.findPage(page);
	}

	@Override
	public List<ContractC> find(Map paraMap) {
		
		return contractCDao.find(paraMap);
	}

	@Override
	public ContractC get(Serializable id) {
	
		return contractCDao.get(id);
	}

	@Override
	public void insert(ContractC entity) {
		entity.setContractId(UUID.randomUUID().toString());
		//
		
		contractCDao.insert(entity);
		
	}

	@Override
	public void update(ContractC entity) {
		contractCDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		contractCDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		contractCDao.delete(ids);
		
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map=new HashMap<>();
		map.put("state", 1);  //已上报
		map.put("ids", ids);
		contractCDao.updateState(map);	
	}

	@Override
	public void cancel(Serializable[] ids) {
		
		Map map=new HashMap<>();
		map.put("state", 0);  //取消
		map.put("ids", ids);
		contractCDao.updateState(map);
	}

	
}
