package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.dao.SysCodeDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.SysCodeB;
import cn.tf.jk.service.ExtCproductService;
import cn.tf.jk.service.ExtCproductService;
import cn.tf.jk.util.UtilFuns;


@Service
public class ExtCproductServiceImpl implements ExtCproductService{

	@Autowired
	private ExtCproductDao  extCproductDao;
	@Autowired
	private SysCodeDao  sysCodeDao;
	
	
	
	@Override
	public List<ExtCproductC> findPage(Page page) {
		
		return null;
	}

	@Override
	public List<ExtCproductC> find(Map paraMap) {
		
		return extCproductDao.find(paraMap);
	}

	@Override
	public ExtCproductC get(Serializable id) {
		
		return extCproductDao.get(id);
	}

	@Override
	public void insert(ExtCproductC entity) {
		
		entity.setExtCproductId(UUID.randomUUID().toString());
		//自动计算总金额
				if(UtilFuns.isNotEmpty(entity.getCnumber())){
					if(UtilFuns.isNotEmpty(entity.getPrice())){
						entity.setAmount(entity.getCnumber().multiply(entity.getPrice()));
					}
				}
		extCproductDao.insert(entity);
		
	}

	@Override
	public void update(ExtCproductC entity) {
		
		//自动计算总金额
		if(UtilFuns.isNotEmpty(entity.getCnumber())){
			if(UtilFuns.isNotEmpty(entity.getPrice())){
				entity.setAmount(entity.getCnumber().multiply(entity.getPrice()));
			}
		}
		extCproductDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		extCproductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.delete(ids);
		
	}

	@Override
	public List<SysCodeB> getCtypeList() {
		Map paraMap=new HashMap();
		paraMap.put("parentId", "0104");  //syscode_b表的附件类型
		return sysCodeDao.find(paraMap);
	}





}
