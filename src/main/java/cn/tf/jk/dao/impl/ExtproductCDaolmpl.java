package cn.tf.jk.dao.impl;

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


	
	
	
}
