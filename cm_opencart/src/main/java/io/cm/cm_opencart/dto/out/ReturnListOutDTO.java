package io.cm.cm_opencart.dto.out;

public class ReturnListOutDTO {

    private Integer return_id;
    private Integer order_id;
    private String customer_name;
    private Byte status;
    private Long create_time;

    public ReturnListOutDTO() {
    }

    public ReturnListOutDTO(Integer return_id, Integer order_id, String customer_name, Byte status, Long create_time) {
        this.return_id = return_id;
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.status = status;
        this.create_time = create_time;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "ReturnListOutDTO{" +
                "return_id=" + return_id +
                ", order_id=" + order_id +
                ", customer_name='" + customer_name + '\'' +
                ", status=" + status +
                ", create_time=" + create_time +
                '}';
    }
}
