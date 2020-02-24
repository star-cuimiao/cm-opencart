package io.cm.cm_opencart.dto.out;

public class OrderListOutDTO {

    private Integer order_id;
    private Integer customers_id;
    private String customer_name;
    private Byte status;
    private Double total_price;
    private Integer reword_points ;
    private Long create_time;

    public OrderListOutDTO(Integer order_id, Integer customers_id, String customer_name, Byte status, Double total_price, Long create_time, Long update_time) {
        this.order_id = order_id;
        this.customers_id = customers_id;
        this.customer_name = customer_name;
        this.status = status;
        this.total_price = total_price;
        this.reword_points = reword_points;
        this.create_time = create_time;
    }

    public OrderListOutDTO() {
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(Integer customers_id) {
        this.customers_id = customers_id;
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

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getReword_points() {
        return reword_points;
    }

    public void setReword_points(Integer reword_points) {
        this.reword_points = reword_points;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "OrderListOutDTO{" +
                "order_id=" + order_id +
                ", customers_id=" + customers_id +
                ", customer_name='" + customer_name + '\'' +
                ", status=" + status +
                ", total_price=" + total_price +
                ", reword_points=" + reword_points +
                ", create_time=" + create_time +
                '}';
    }
}
