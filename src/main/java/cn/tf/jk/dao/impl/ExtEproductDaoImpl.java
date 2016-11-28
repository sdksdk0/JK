package cn.tf.jk.dao.impl;

import org.springframework.stereotype.Repository;


import cn.tf.jk.dao.ExtEproductDao;
import cn.tf.jk.po.ExtEproductC;


@Repository
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproductC> implements ExtEproductDao{
	public ExtEproductDaoImpl() {
		//设置命名空间
		super.setNs("cn.tf.jk.mapper.ExtEproductCMapper");
	}
}
