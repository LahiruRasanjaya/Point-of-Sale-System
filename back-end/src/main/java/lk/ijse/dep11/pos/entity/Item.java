package lk.ijse.dep11.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @Column(nullable = false, unique = true, length = 100)
    private String code;
    @Column(name="quantity", length = 100)
    private int qty;
    @Column(nullable = false,scale = 2,precision = 8)
    private BigDecimal unitPrice;

    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "item")
    private OrderItem orderItem;

    public Item(String code, int qty, BigDecimal unitPrice) {
        this.code = code;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public void setOrderItem(OrderItem orderItem) {
       this.orderItem=orderItem;
        orderItem.setItem(this);
    }
    public void removeOrder(Order order){
        throw new RuntimeException("Unsupported Operation");
    }
}
