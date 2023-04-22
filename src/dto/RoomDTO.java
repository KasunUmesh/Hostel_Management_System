package dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO implements Serializable {
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;
}
