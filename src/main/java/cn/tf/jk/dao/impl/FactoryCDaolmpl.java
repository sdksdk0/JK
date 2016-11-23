package cn.tf.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.po.FactoryC;

@Repository
public class FactoryCDaolmpl extends BaseDaoImpl<FactoryC>  implements  FactoryCDao{

	public FactoryCDaolmpl(){
		super.setNs("cn.tf.jk.mapper.FactoryCMapper");
	}
	
	
	
}
