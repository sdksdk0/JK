package cn.tf.jk.dao;

import java.io.Serializable;
import java.util.Map;

import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.FactoryC;

public interface ExtCproductDao extends BaseDao<ExtCproductC>{


	public void deleteByContractProduct(Serializable[] ids);
	public void deleteByContractId(Serializable[] contractIds);
	

}
