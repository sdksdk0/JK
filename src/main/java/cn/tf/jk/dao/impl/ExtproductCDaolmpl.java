package cn.tf.jk.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.FactoryC;

@Repository
public class ExtproductCDaolmpl extends BaseDaoImpl<ExtCproductC>  implements  ExtCproductDao{

	public ExtproductCDaolmpl(){
		super.setNs("cn.tf.jk.mapper.ExtCproductCMapper");
	}

	@Override
	public void deleteByContractProduct(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProduct",ids);
		
	}
	
	@Override
	public void deleteByContractId(Serializable[] contractIds) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractId",contractIds);
		
	}
	
}
