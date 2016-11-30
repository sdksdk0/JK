package cn.tf.jk.dao;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.vo.ContractVO;


public interface ContractHisDao extends BaseDao<ContractC> {
	public ContractVO view(String contractId);	//查询某个合同
}
