package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.ExportCDao;
import cn.tf.jk.dao.ExportProductDao;
import cn.tf.jk.dao.PackingListCDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ExportC;
import cn.tf.jk.po.PackingListC;
import cn.tf.jk.service.PackingListCService;

@Service
public class PackingListCServiceImpl implements PackingListCService{

	@Autowired
	private PackingListCDao  packingListCDao;
	@Autowired
	private ExportCDao exportCDao;
	
	
	
	@Override
	public List<PackingListC> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackingListC> find(Map paraMap) {
		
		return packingListCDao.find(paraMap);
	}

	@Override
	public PackingListC get(Serializable id) {
		
		return packingListCDao.get(id);
	}

	@Override
	public void insert(PackingListC factory) {
		
		factory.setPackingListId(UUID.randomUUID().toString());
		
		packingListCDao.insert(factory);
		
	}

	@Override
	public void update(PackingListC entity) {
		packingListCDao.update(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		packingListCDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		packingListCDao.delete(ids);
		
	}
	
	//拼接一个html片段
	public String getDivDate(String[]  exportIds){
		StringBuffer  buffer=new StringBuffer();
		for(int i=0;i<exportIds.length;i++){
			ExportC export = exportCDao.get(exportIds[i]);
			buffer.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(export.getCustomerContract()).append("\" class=\"input\"/>");
			
			buffer.append(export.getCustomerContract());
		}
		return buffer.toString();
	}





}
