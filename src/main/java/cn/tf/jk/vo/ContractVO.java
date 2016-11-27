package cn.tf.jk.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.tf.jk.po.ContractProductC;

public class ContractVO {
	
	private String contractId;

	//货物的集合
	private List<ContractProductC>  contractProductCs;

    
    private String cpnum;
    private String extnum;
  
    
    private String offeror;

    private String contractNo;

    private Date signingDate;

    private String inputBy;

    private String checkBy;

    private String inspector;

    private BigDecimal totalAmount;

    private BigDecimal importNum;

    private String crequest;

    private String customName;

    private Date deliveryPeriod;

    private Date shipTime;

    private String tradeTerms;

    private String remark;

    private String printStyle;

    private BigDecimal oldState;

    private BigDecimal state;

    private BigDecimal outState;

    private String createBy;

    private String createDept;

    private Date createTime;
    
    
    

    public List<ContractProductC> getContractProductCs() {
		return contractProductCs;
	}

	public void setContractProductCs(List<ContractProductC> contractProductCs) {
		this.contractProductCs = contractProductCs;
	}

	public String getCpnum() {
		return cpnum;
	}

	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}

	public String getExtnum() {
		return extnum;
	}

	public void setExtnum(String extnum) {
		this.extnum = extnum;
	}

	public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getOfferor() {
        return offeror;
    }

    public void setOfferor(String offeror) {
        this.offeror = offeror == null ? null : offeror.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy == null ? null : inputBy.trim();
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy == null ? null : checkBy.trim();
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getImportNum() {
        return importNum;
    }

    public void setImportNum(BigDecimal importNum) {
        this.importNum = importNum;
    }

    public String getCrequest() {
        return crequest;
    }

    public void setCrequest(String crequest) {
        this.crequest = crequest == null ? null : crequest.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public Date getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(Date deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public String getTradeTerms() {
        return tradeTerms;
    }

    public void setTradeTerms(String tradeTerms) {
        this.tradeTerms = tradeTerms == null ? null : tradeTerms.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPrintStyle() {
        return printStyle;
    }

    public void setPrintStyle(String printStyle) {
        this.printStyle = printStyle == null ? null : printStyle.trim();
    }

    public BigDecimal getOldState() {
        return oldState;
    }

    public void setOldState(BigDecimal oldState) {
        this.oldState = oldState;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public BigDecimal getOutState() {
        return outState;
    }

    public void setOutState(BigDecimal outState) {
        this.outState = outState;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept == null ? null : createDept.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
