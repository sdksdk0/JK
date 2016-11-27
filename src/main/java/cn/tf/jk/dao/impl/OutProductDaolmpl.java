package cn.tf.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.dao.OutProductDao;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.vo.OutProductVO;

@Repository
public class OutProductDaolmpl extends BaseDaoImpl<OutProductVO>  implements  OutProductDao{

	public OutProductDaolmpl(){
		super.setNs("cn.tf.jk.mapper.OutProductMapper");
	}

	
	
	
	
}
