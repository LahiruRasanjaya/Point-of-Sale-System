package lk.ijse.dep11.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderItem")
public class OrderItem implements Serializable {

    @Column(name ="quantity", nullable = false, length = 100)
    private int qty;
    @Column(nullable = false,scale = 2,precision = 8)
    private BigDecimal unit_price;
    @Id
    @OneToOne
    @JoinColumn(name = "item_code", nullable = false, referencedColumnName = "id", unique = true)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
