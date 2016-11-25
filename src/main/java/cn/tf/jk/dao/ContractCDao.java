package cn.tf.jk.dao;

import java.util.Map;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.FactoryC;

public interface ContractCDao extends BaseDao<ContractC>{
	
	//修改状态
		public void updateState(Map map); 

}
