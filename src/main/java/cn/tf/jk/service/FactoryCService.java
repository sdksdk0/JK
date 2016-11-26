package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;

public interface FactoryCService {
	
	public List<FactoryC> findPage(Page page);				//分页查询
	public List<FactoryC> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public FactoryC get(Serializable id);					//只查询一个，常用于修改
	public void insert(FactoryC entity);					//插入，用实体作为参数
	public void update(FactoryC entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);	
	
	//启用
	public void start(Serializable[] ids);
	
	//停用
	public void stop(Serializable[] ids);
	
	//获取生产厂家的下拉列表，默认state为1
	public List<FactoryC>  getFactoryList();

}
