package cn.tf.jk.dao;

import java.util.Map;

import cn.tf.jk.po.ExportC;
import cn.tf.jk.po.FactoryC;

public interface ExportCDao extends BaseDao<ExportC>{
	
	//修改状态
	public void updateState(Map map); 

}
