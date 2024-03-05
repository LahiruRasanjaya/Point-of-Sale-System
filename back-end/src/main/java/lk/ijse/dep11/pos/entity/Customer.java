package lk.ijse.dep11.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false, length = 100)
    private String cadeNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;

    public Customer(int id, String cadeNumber) {
        this.id = id;
        this.cadeNumber = cadeNumber;
    }

    public void setOrder(Order order) {
        orderSet.add(order);
        order.setCustomer(this);
    }
    public void removeOrder(Order order){
        throw new RuntimeException("Unsupported Operation");
    }


}
