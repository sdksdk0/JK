package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.tf.jk.dao.ContractProductCDao;
import cn.tf.jk.dao.ExtCproductDao;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractProductC;

import cn.tf.jk.service.ContractProductCService;
import cn.tf.jk.util.UtilFuns;


@Service
public class ConstractProductCServiceImpl implements ContractProductCService{

	@Autowired
	private ContractProductCDao  ContractProductCDao;
	@Autowired
	private ExtCproductDao  extCproductDao;
	
	@Override
	public List<ContractProductC> findPage(Page page) {
		
		return ContractProductCDao.findPage(page);
	}

	@Override
	public List<ContractProductC> find(Map paraMap) {
		
		return ContractProductCDao.find(paraMap);
	}

	@Override
	public ContractProductC get(Serializable id) {
	
		return ContractProductCDao.get(id);
	}

	@Override
	public void insert(ContractProductC entity) {
		entity.setContractProductId(UUID.randomUUID().toString());
		//
		//自动计算总金额
		if(UtilFuns.isNotEmpty(entity.getCnumber())){
			if(UtilFuns.isNotEmpty(entity.getPrice())){
				entity.setAmount(entity.getCnumber().multiply(entity.getPrice()));
			}
		}
		
		ContractProductCDao.insert(entity);
		
	}

	@Override
	public void update(ContractProductC entity) {
		
		//自动计算总金额
		if(UtilFuns.isNotEmpty(entity.getCnumber())){
			if(UtilFuns.isNotEmpty(entity.getPrice())){
				entity.setAmount(entity.getCnumber().multiply(entity.getPrice()));
			}
		}
		
		ContractProductCDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids={id};
		//删除附件
		extCproductDao.deleteByContractProduct(ids);
		
		ContractProductCDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		//删除附件
		extCproductDao.deleteByContractProduct(ids);
		//删除自身的
		ContractProductCDao.delete(ids);
		
		
	}



	
}
