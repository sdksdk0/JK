package cn.tf.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.dao.PackingListCDao;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.po.PackingListC;

@Repository
public class PackingListCDaolmpl extends BaseDaoImpl<PackingListC>  implements  PackingListCDao{

	public PackingListCDaolmpl(){
		super.setNs("cn.tf.jk.mapper.PackingListCMapper");
	}


	
	
}
