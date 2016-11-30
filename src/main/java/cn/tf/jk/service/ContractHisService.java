package cn.tf.jk.service;

import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.vo.ContractVO;




//合同的历史
public interface ContractHisService {
	//归档
	public List<ContractC> findPage(Page page);		//分页查询
	public List<ContractC> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ContractVO view(String contractId);		//关联对象的查询一个
	
	public void pigeinhole(String[] contractIds);		//归档
	public void pigeouthole(String[] contractIds);	
	

}
