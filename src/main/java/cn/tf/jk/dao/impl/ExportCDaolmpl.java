package cn.tf.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.ExportCDao;
import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.po.ExportC;
import cn.tf.jk.po.FactoryC;

@Repository
public class ExportCDaolmpl extends BaseDaoImpl<ExportC>  implements  ExportCDao{

	public ExportCDaolmpl(){
		super.setNs("cn.tf.jk.mapper.ExportCMapper");
	}

	@Override
	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState",map);
		
	}
	
	
	
}
