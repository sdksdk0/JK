package cn.tf.jk.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExportC implements Serializable{
    private String exportId;
    
    private  String  epnum;
    private String extnum;
    
    

    private Date inputDate;

    private String contractIds;   //打断设计，合同的id集合

    private String customerContract;

    private String lcno;

    private String consignee;

    private String marks;

    private String remark;

    private String shipmentPort;

    private String destinationPort;

    private String transportMode;

    private String priceCondition;

    private BigDecimal state;

    private BigDecimal grossWeight;

    private BigDecimal netWeight;

    private BigDecimal measurement;

    private String createBy;

    private String createDept;

    private Date createTime;

    
    
    
    
    
    public String getEpnum() {
		return epnum;
	}

	public void setEpnum(String epnum) {
		this.epnum = epnum;
	}

	public String getExtnum() {
		return extnum;
	}

	public void setExtnum(String extnum) {
		this.extnum = extnum;
	}

	public String getExportId() {
        return exportId;
    }

    public void setExportId(String exportId) {
        this.exportId = exportId == null ? null : exportId.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getContractIds() {
        return contractIds;
    }

    public void setContractIds(String contractIds) {
        this.contractIds = contractIds == null ? null : contractIds.trim();
    }

    public String getCustomerContract() {
        return customerContract;
    }

    public void setCustomerContract(String customerContract) {
        this.customerContract = customerContract == null ? null : customerContract.trim();
    }

    public String getLcno() {
        return lcno;
    }

    public void setLcno(String lcno) {
        this.lcno = lcno == null ? null : lcno.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks == null ? null : marks.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getShipmentPort() {
        return shipmentPort;
    }

    public void setShipmentPort(String shipmentPort) {
        this.shipmentPort = shipmentPort == null ? null : shipmentPort.trim();
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort == null ? null : destinationPort.trim();
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode == null ? null : transportMode.trim();
    }

    public String getPriceCondition() {
        return priceCondition;
    }

    public void setPriceCondition(String priceCondition) {
        this.priceCondition = priceCondition == null ? null : priceCondition.trim();
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(BigDecimal grossWeight) {
        this.grossWeight = grossWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getMeasurement() {
        return measurement;
    }

    public void setMeasurement(BigDecimal measurement) {
        this.measurement = measurement;
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