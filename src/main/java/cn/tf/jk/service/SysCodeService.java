package cn.tf.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.po.SysCodeB;

public interface SysCodeService {
	
	public List<SysCodeB> find(Map map);				//分页查询
	

}
