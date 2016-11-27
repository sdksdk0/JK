package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.FactoryCDao;
import cn.tf.jk.dao.OutProductDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.FactoryCService;
import cn.tf.jk.service.OutProductService;
import cn.tf.jk.vo.OutProductVO;

@Service
public class OutProductServiceImpl implements OutProductService{

	@Autowired
	private OutProductDao outProductDao;
	
	@Override
	public List<OutProductVO> find(String inputDate) {
		Map  paraMap=new HashMap<>();
		paraMap.put("inputDate", inputDate);
		return outProductDao.find(paraMap);
	}

	

}
