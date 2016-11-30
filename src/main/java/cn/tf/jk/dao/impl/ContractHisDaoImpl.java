package cn.tf.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.ContractHisDao;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.vo.ContractVO;


@Repository
public class ContractHisDaoImpl extends BaseDaoImpl<ContractC> implements ContractHisDao{
	public ContractHisDaoImpl() {
		//设置命名空间
		super.setNs("cn.tf.jk.mapper.ContractHisCMapper");
	}

	public ContractVO view(String contractId) {
		return super.getSqlSession().selectOne(super.getNs()+".view", contractId);
	}
}
