package cn.tf.jk.dao;

import java.util.Map;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.vo.ContractVO;

public interface ContractCDao extends BaseDao<ContractC>{
	
	//修改状态
		public void updateState(Map map); 

		//查询合同明细
		public ContractVO  view(String contractId);
		
		
}
