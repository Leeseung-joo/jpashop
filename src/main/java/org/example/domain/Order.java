package org.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERS") //데이터베이스에 ORDER라는 예약어가 있어서 보통 ORDERS로 테이블 명을 바꿈
public class Order {
    @Id@GeneratedValue
    private Long id;
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID") //객체의 참조와 테이블의 외래 키를 매핑, ORDER의 MEMBER와 오더테이블에 멤버 id를 매핑
    private Member member;

    @OneToOne(fetch = LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID") //외래키 컬럼의 이름을 DELIVERT_ID로 지정
    private Delivery delivery;

    @OneToMany(mappedBy = "Order")
    private List<OrderItem> orderItems= new ArrayList<>();

    private LocalDateTime orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING) //enum타입 매핑
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

}
