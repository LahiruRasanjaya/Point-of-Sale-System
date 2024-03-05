package lk.ijse.dep11.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @Column(nullable= false,length = 100)
    private String id;
    @Column(nullable=false)
    private Date date; //sql

    @ManyToOne
    @JoinTable(name = "customer_order",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false))
    private Customer customer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItemSet;

    public Order(String id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public void setOrderItem(OrderItem orderItem) {
        orderItemSet.add(orderItem);
        orderItem.setOrder(this);
    }
    public void removeOrderItem(OrderItem orderItem){
        throw new RuntimeException("Unsupported Operation");
    }

}
