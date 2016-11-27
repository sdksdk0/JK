package cn.tf.jk.dao;

import java.io.Serializable;
import java.util.Map;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ContractProductC;
import cn.tf.jk.po.FactoryC;

public interface ContractProductCDao extends BaseDao<ContractProductC>{
	
	public void deleteByContractId(Serializable[]  ids);
	
	

}
