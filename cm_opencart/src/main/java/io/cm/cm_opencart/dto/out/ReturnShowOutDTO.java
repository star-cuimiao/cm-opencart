package io.cm.cm_opencart.dto.out;

public class ReturnShowOutDTO {

    private Integer return_id;
    private Integer order_id;
    private Long order_time;
    private String customer_name;
    private String mobile;
    private String email;
    private Byte status;
    private Byte return_action;
    private String product_code;
    private String product_name;
    private Integer quantity;
    private String reason;
    private Boolean opened;
    private String comment;
    private Long create_time;
    private Long update_time;

    public ReturnShowOutDTO() {
    }

    public ReturnShowOutDTO(Integer return_id, Integer order_id, Long order_time, String customer_name, String mobile, String email, Byte status, Byte return_action, String product_code, String product_name, Integer quantity, String reason, Boolean opened, String comment, Long create_time, Long update_time) {
        this.return_id = return_id;
        this.order_id = order_id;
        this.order_time = order_time;
        this.customer_name = customer_name;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
        this.return_action = return_action;
        this.product_code = product_code;
        this.product_name = product_name;
        this.quantity = quantity;
        this.reason = reason;
        this.opened = opened;
        this.comment = comment;
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

    public Long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Long order_time) {
        this.order_time = order_time;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getReturn_action() {
        return return_action;
    }

    public void setReturn_action(Byte return_action) {
        this.return_action = return_action;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "ReturnShowOutDTO{" +
                "return_id=" + return_id +
                ", order_id=" + order_id +
                ", order_time=" + order_time +
                ", customer_name='" + customer_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", return_action=" + return_action +
                ", product_code='" + product_code + '\'' +
                ", product_name='" + product_name + '\'' +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                ", opened=" + opened +
                ", comment='" + comment + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
