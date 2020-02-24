package io.cm.cm_opencart.dto.out;

public class ProductReturnListOutDTO {

    private Integer return_id;
    private Integer order_id;
    private String customer_name;
    private String mobile;
    private Byte status;
    private String product_name;
    private Long create_time;
    private Long update_time;

    public ProductReturnListOutDTO() {
    }

    public ProductReturnListOutDTO(Integer return_id, Integer order_id, String customer_name, String mobile, Byte status, String product_name, Long create_time, Long update_time) {
        this.return_id = return_id;
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.mobile = mobile;
        this.status = status;
        this.product_name = product_name;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public Integer getReturn_id() {
        return return_id;
    }

    public void setReturn_id(Integer return_id) {
        this.return_id = return_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "ProductReturnListOutDTO{" +
                "return_id=" + return_id +
                ", order_id=" + order_id +
                ", customer_name='" + customer_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", product_name='" + product_name + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
