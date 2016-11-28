package cn.tf.jk.vo;

import java.math.BigDecimal;
import java.util.List;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.FactoryC;

public class ContractProductVO {
    private String contractProductId;

   
    private ContractC  contractC;
    
    private List<ExtCproductVO>  extCproductCs;
    //和生产厂家是多对一的关系
    private FactoryC factoryC;
    
   
   

    private String productNo;

    private String productImage;

    private String productDesc;

    private BigDecimal cnumber;

    private BigDecimal outNumber;

    private String loadingRate;

    private BigDecimal boxNum;

    private String packingUnit;

    private BigDecimal price;

    private BigDecimal amount;

    private BigDecimal finished;

    private String exts;

    private BigDecimal orderNo;

    public String getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId == null ? null : contractProductId.trim();
    }

   
    public ContractC getContractC() {
		return contractC;
	}

	public void setContractC(ContractC contractC) {
		this.contractC = contractC;
	}

	public List<ExtCproductVO> getExtCproductCs() {
		return extCproductCs;
	}

	public void setExtCproductCs(List<ExtCproductVO> extCproductCs) {
		this.extCproductCs = extCproductCs;
	}

	public FactoryC getFactoryC() {
		return factoryC;
	}

	public void setFactoryC(FactoryC factoryC) {
		this.factoryC = factoryC;
	}

	public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public BigDecimal getCnumber() {
        return cnumber;
    }

    public void setCnumber(BigDecimal cnumber) {
        this.cnumber = cnumber;
    }

    public BigDecimal getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(BigDecimal outNumber) {
        this.outNumber = outNumber;
    }

    public String getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate == null ? null : loadingRate.trim();
    }

    public BigDecimal getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(BigDecimal boxNum) {
        this.boxNum = boxNum;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit == null ? null : packingUnit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFinished() {
        return finished;
    }

    public void setFinished(BigDecimal finished) {
        this.finished = finished;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts == null ? null : exts.trim();
    }

    public BigDecimal getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(BigDecimal orderNo) {
        this.orderNo = orderNo;
    }
}