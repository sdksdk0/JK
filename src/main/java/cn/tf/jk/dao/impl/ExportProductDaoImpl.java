package cn.tf.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.tf.jk.dao.ExportProductDao;
import cn.tf.jk.po.ExportProductC;




@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProductC> implements ExportProductDao{
	public ExportProductDaoImpl() {
		//设置命名空间
		super.setNs("cn.tf.jk.mapper.ExportProductCMapper");
	}
}
