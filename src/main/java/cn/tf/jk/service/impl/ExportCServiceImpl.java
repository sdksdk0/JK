package cn.tf.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tf.jk.dao.ContractCDao;
import cn.tf.jk.dao.ExportCDao;
import cn.tf.jk.dao.ExportCDao;
import cn.tf.jk.dao.ExportProductDao;
import cn.tf.jk.dao.ExtCproductDao;
import cn.tf.jk.dao.ExtEproductDao;
import cn.tf.jk.pagination.Page;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ExportC;
import cn.tf.jk.po.ExportProductC;
import cn.tf.jk.po.ExtEproductC;
import cn.tf.jk.service.ExportCService;
import cn.tf.jk.service.ExportCService;
import cn.tf.jk.util.UtilFuns;
import cn.tf.jk.vo.ContractProductVO;
import cn.tf.jk.vo.ContractVO;
import cn.tf.jk.vo.ExtCproductVO;

@Service
public class ExportCServiceImpl implements ExportCService{

	@Autowired
	private ExportCDao  exportCDao;
	
	@Autowired
	private  ContractCDao contractCDao;
	@Autowired
	private ExportProductDao exportProductDao;
	@Autowired
	private ExtEproductDao extEproductDao;

	
	
	@Override
	public List<ExportC> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExportC> find(Map paraMap) {
		
		return exportCDao.find(paraMap);
	}

	@Override
	public ExportC get(Serializable id) {
		
		return exportCDao.get(id);
	}

	@Override
	public void insert(String[] contractIds) {
		
		/*
		 * 步骤：
		 * 1、根据合同id获得合同对象，获取合同号
		 * 2、将合同下的货物信息搬家到报运下的货物表中
		 * 3、将合同下的附件信息搬家到报运下的附件表中
		 */
		
		//拼接合同号，报运号
		String contractNos = "";
		for(int i=0;i<contractIds.length;i++){
			ContractVO contract = contractCDao.view(contractIds[i]);
			contractNos += contract.getContractNo() + " ";				//以空格作为分隔符
		}
		contractNos = UtilFuns.delLastChar(contractNos);				//工具类，删除最后一个字符
		
		ExportC export = new ExportC();
		export.setExportId(UUID.randomUUID().toString());
		
		//x,y
		export.setContractIds(UtilFuns.joinStr(contractIds, ","));		//工具类，拼串
		export.setCustomerContract(contractNos);
		
													//0草稿
		
		exportCDao.insert(export);
		//处理货物信息
				for(int i=0;i<contractIds.length;i++){
					ContractVO contract = contractCDao.view(contractIds[i]);
					
					for(ContractProductVO cp : contract.getContractProductCs()){
					
						ExportProductC ep = new ExportProductC();
						ep.setExportProductId(UUID.randomUUID().toString());
						ep.setExportId(export.getExportId());					//绑定外键
						
						//数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
						ep.setFactoryId(cp.getFactoryC().getFactoryId());
						ep.setFactoryName(cp.getFactoryC().getFactoryName());
						ep.setProductNo(cp.getProductNo());
						ep.setPackingUnit(cp.getPackingUnit());
						ep.setCnumber(cp.getCnumber());
						ep.setBoxNum(cp.getBoxNum());
						ep.setPrice(cp.getPrice());
						
						exportProductDao.insert(ep);
						
						//处理附件信息
						for(ExtCproductVO extcp : cp.getExtCproductCs()){
							ExtEproductC extep = new ExtEproductC();
							
							//copyProperties spring
							BeanUtils.copyProperties(extcp, extep);		//spring工具类，数据的拷贝
							
							extep.setExtEproductId(UUID.randomUUID().toString());
							extep.setExportProductId(ep.getExportProductId());		//绑定外键
							
							extep.setFactoryId(extcp.getFactoryC().getFactoryId());
							extep.setFactoryName(extcp.getFactoryC().getFactoryName());
							
							extEproductDao.insert(extep);
						}
					}
				}
	
		
	}

	@Override
	public void update(ExportC export){
		exportCDao.update(export);
		
		
	}


	@Override
	public void deleteById(Serializable id) {
		exportCDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		exportCDao.delete(ids);
		
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map=new HashMap<>();
		map.put("state", 1);  //启用
		map.put("ids", ids);
		
		exportCDao.updateState(map);
		
	}

	@Override
	public void cancel(Serializable[] ids) {
		Map map=new HashMap<>();
		map.put("state", 0);  //停用
		map.put("ids", ids);
		exportCDao.updateState(map);
		
	}

	@Override
	public List<ContractC> getContractList() {
		Map paraMap=new HashMap<>();
		paraMap.put("state", 1);
		return  contractCDao.find(paraMap);
	}
	
	//拼接JS串
		//function addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
		public String getMrecordData(String exportId){
			Map paraMap = new HashMap();
			paraMap.put("exportId", exportId);
			
			List<ExportProductC> oList = exportProductDao.find(paraMap );
			
			StringBuffer sBuf = new StringBuffer();
			for(ExportProductC ep : oList){
				sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getExportProductId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
			}
			
			return sBuf.toString();
		}
	

	
}
