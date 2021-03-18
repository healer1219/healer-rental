package com.healer.entity.order;

import com.healer.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderNo;
    private Double orderAmount;
    private String consignee;
    private String address;
    private String phone;
    private Integer status;
    private String userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer itemId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "order_no", nullable = true, length = 100)
//    public String getOrderNo() {
//        return orderNo;
//    }
//
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }
//
//    @Basic
//    @Column(name = "order_amount", nullable = true, precision = 2)
//    public Double getOrderAmount() {
//        return orderAmount;
//    }
//
//    public void setOrderAmount(Double orderAmount) {
//        this.orderAmount = orderAmount;
//    }
//
//    @Basic
//    @Column(name = "consignee", nullable = true, length = 255)
//    public String getConsignee() {
//        return consignee;
//    }
//
//    public void setConsignee(String consignee) {
//        this.consignee = consignee;
//    }
//
//    @Basic
//    @Column(name = "address", nullable = true, length = 255)
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    @Basic
//    @Column(name = "phone", nullable = true, length = 255)
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    @Basic
//    @Column(name = "status", nullable = true)
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    @Basic
//    @Column(name = "user_id", nullable = true)
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    @Basic
//    @Column(name = "create_time", nullable = true)
//    public Timestamp getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Timestamp createTime) {
//        this.createTime = createTime;
//    }
//
//    @Basic
//    @Column(name = "update_time", nullable = true)
//    public Timestamp getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Timestamp updateTime) {
//        this.updateTime = updateTime;
//    }
//
//
}
