package io.cm.cm_opencart.dto.out;

public class OrderHistoryListOutDTO {
    private Integer order_history_id;
    private Integer order_id;
    private Long time;
    private Byte order_status;
    private String comment;
    private Boolean customer_notified;

    public OrderHistoryListOutDTO(Integer order_history_id, Integer order_id, Long time, Byte order_status, String comment, Boolean customer_notified) {
        this.order_history_id = order_history_id;
        this.order_id = order_id;
        this.time = time;
        this.order_status = order_status;
        this.comment = comment;
        this.customer_notified = customer_notified;
    }

    public OrderHistoryListOutDTO() {
    }

    public Integer getOrder_history_id() {
        return order_history_id;
    }

    public void setOrder_history_id(Integer order_history_id) {
        this.order_history_id = order_history_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Byte getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Byte order_status) {
        this.order_status = order_status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getCustomer_notified() {
        return customer_notified;
    }

    public void setCustomer_notified(Boolean customer_notified) {
        this.customer_notified = customer_notified;
    }

    @Override
    public String toString() {
        return "OrderHistoryListOutDTO{" +
                "order_history_id=" + order_history_id +
                ", order_id=" + order_id +
                ", time=" + time +
                ", order_status=" + order_status +
                ", comment='" + comment + '\'' +
                ", customer_notified=" + customer_notified +
                '}';
    }
}
