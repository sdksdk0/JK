package cn.tf.jk.vo;

import java.math.BigDecimal;

import cn.tf.jk.po.ContractProductC;
import cn.tf.jk.po.FactoryC;

public class ExtCproductVO {
    private String extCproductId;
    
    
    private ContractProductC  contractProductC;
    private FactoryC factoryC;
    
    

    private BigDecimal ctype;

    private String productNo;

    private String productImage;

    private String productDesc;

    private BigDecimal cnumber;

    private String packingUnit;

    private BigDecimal price;

    private BigDecimal amount;

    private String productRequest;

    private BigDecimal orderNo;

    public String getExtCproductId() {
        return extCproductId;
    }

    public void setExtCproductId(String extCproductId) {
        this.extCproductId = extCproductId == null ? null : extCproductId.trim();
    }

   

    public ContractProductC getContractProductC() {
		return contractProductC;
	}

	public void setContractProductC(ContractProductC contractProductC) {
		this.contractProductC = contractProductC;
	}

	public FactoryC getFactoryC() {
		return factoryC;
	}

	public void setFactoryC(FactoryC factoryC) {
		this.factoryC = factoryC;
	}

	public BigDecimal getCtype() {
        return ctype;
    }

    public void setCtype(BigDecimal ctype) {
        this.ctype = ctype;
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

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest == null ? null : productRequest.trim();
    }

    public BigDecimal getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(BigDecimal orderNo) {
        this.orderNo = orderNo;
    }
}