package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.PackingListC;

public interface PackingListCService {
	
	public List<PackingListC> findPage(Page page);				//分页查询
	public List<PackingListC> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public PackingListC get(Serializable id);					//只查询一个，常用于修改
	public void insert(PackingListC entity);					//插入，用实体作为参数
	public void update(PackingListC entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);	
	
	public String getDivDate(String[]  exportIds);
	

}
