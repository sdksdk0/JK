package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ExportC;

public interface ExportCService {
	
	public List<ExportC> findPage(Page page);				//分页查询
	public List<ExportC> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ExportC get(Serializable id);					//只查询一个，常用于修改
	public void insert(String[] contractIds);					//插入，用实体作为参数
	public void update(ExportC entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);	
	
	//启用
	public void submit(Serializable[] ids);
	
	//停用
	public void cancel(Serializable[] ids);
	

	//获得购销合同列表
	public List<ContractC>  getContractList();
	
	

}
