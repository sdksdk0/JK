package cn.tf.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.ContractCDao;
import cn.tf.jk.dao.ContractProductCDao;
import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ContractProductC;
import cn.tf.jk.po.FactoryC;

@Repository
public class ContractProductCDaolmpl extends BaseDaoImpl<ContractProductC>  implements  ContractProductCDao{

	public ContractProductCDaolmpl(){
		super.setNs("cn.tf.jk.mapper.ContractProductCMapper");
	}


	
	
	
}
