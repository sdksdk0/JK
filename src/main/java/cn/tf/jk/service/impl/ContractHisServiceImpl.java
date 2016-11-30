package cn.tf.jk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.common.springdao.SqlDao;
import cn.tf.jk.dao.ContractHisDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.service.ContractHisService;
import cn.tf.jk.util.UtilFuns;
import cn.tf.jk.vo.ContractVO;

//合同的历史
@Service
public class ContractHisServiceImpl  implements  ContractHisService {

	@Autowired
	private SqlDao sqlDao;
	@Autowired
	ContractHisDao contractHisDao;
	
	public void pigeinhole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "", "_his"));		//批量执行
	}

	public void pigeouthole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "_his", ""));
	}
	
	//处理数据：有源表向目标表复制数据，将源表数据删除
	public String[] doData(String[] contractIds, String source, String target){
		StringBuffer sBuf = new StringBuffer();
		String inStr = UtilFuns.joinStr(contractIds, "'", "'", ",");			//合同的id串 x,y ，构造成in子查询串 'x','y'
		
		sBuf.append("insert into contract").append(target).append("_c (select * from contract").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into contract_product").append(target).append("_c (select * from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into ext_cproduct").append(target).append("_c (select * from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(")));");
		
		sBuf.append("delete from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("delete from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(");");
		sBuf.append("delete from contract").append(source).append("_c where contract_id in (").append(inStr).append(");");
		
		return sBuf.toString().split(";");
	}

	public List<ContractC> findPage(Page page) {
		return contractHisDao.findPage(page);
	}

	public List<ContractC> find(Map paraMap) {
		return contractHisDao.find(paraMap);
	}

	public ContractVO view(String contractId) {
		return contractHisDao.view(contractId);
	}

	
	

}
