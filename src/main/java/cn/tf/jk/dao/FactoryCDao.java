package cn.tf.jk.dao;

import java.util.Map;

import cn.tf.jk.po.FactoryC;

public interface FactoryCDao extends BaseDao<FactoryC>{
	
	//修改状态
	public void updateState(Map map); 

}
