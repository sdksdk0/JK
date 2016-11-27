package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.vo.ContractVO;

public interface ContractCService {
	
	public List<ContractC> findPage(Page page);				//分页查询
	public List<ContractC> find(Map paraMap);				//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ContractC get(Serializable id);					//只查询一个，常用于修改
	public void insert(ContractC entity);					//插入，用实体作为参数
	public void update(ContractC entity);					//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);	
	
	//上报
	public void submit(Serializable[] ids);
	
	//取消
	public void cancel(Serializable[] ids);
	
	
	//查询合同明细
	public ContractVO  view(String contractId);

}
