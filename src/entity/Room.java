package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Room implements SuperEntity{
    @Id
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;
}
