package io.cm.cm_opencart.dto.out;

import java.util.List;

public class ProductShowOutDTO {

    private Integer productId;
    private String productCode;
    private String productName;
    private Double price;
    private Double discount;
    private Integer quantity;
    private Byte status;
    private String mainPicUrl;
    private Integer rewordPoints;
    private String description;
    private List<String> otherPicUrls;

    public ProductShowOutDTO() {
    }

    public ProductShowOutDTO(Integer productId, String productCode, String productName, Double price, Double discount, Integer quantity, Byte status, String mainPicUrl, Integer rewordPoints, String description, List<String> otherPicUrls) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.status = status;
        this.mainPicUrl = mainPicUrl;
        this.rewordPoints = rewordPoints;
        this.description = description;
        this.otherPicUrls = otherPicUrls;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }

    public Integer getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Integer rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOtherPicUrls() {
        return otherPicUrls;
    }

    public void setOtherPicUrls(List<String> otherPicUrls) {
        this.otherPicUrls = otherPicUrls;
    }

    @Override
    public String toString() {
        return "ProductShowOutDTO{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", status=" + status +
                ", mainPicUrl='" + mainPicUrl + '\'' +
                ", rewordPoints=" + rewordPoints +
                ", description='" + description + '\'' +
                ", otherPicUrls=" + otherPicUrls +
                '}';
    }
}
