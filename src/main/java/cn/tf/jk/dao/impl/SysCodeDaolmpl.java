package cn.tf.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.dao.SysCodeDao;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.po.SysCodeB;

@Repository
public class SysCodeDaolmpl extends BaseDaoImpl<SysCodeB>  implements  	SysCodeDao{

	public SysCodeDaolmpl(){
		super.setNs("cn.tf.jk.mapper.SysCodeBMapper");
	}

	
	
	
}
