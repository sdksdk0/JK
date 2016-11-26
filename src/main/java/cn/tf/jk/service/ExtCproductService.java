package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.SysCodeB;

public interface ExtCproductService {
	
	public List<ExtCproductC> findPage(Page page);				//分页查询
	public List<ExtCproductC> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ExtCproductC get(Serializable id);					//只查询一个，常用于修改
	public void insert(ExtCproductC entity);					//插入，用实体作为参数
	public void update(ExtCproductC entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);	
	
	//获取分类列表
	public List<SysCodeB> getCtypeList();
	

}
