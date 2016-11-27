package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.vo.OutProductVO;

public interface OutProductService {
	
	public List<OutProductVO> find(String inputDate);				//分页查询
	

}
