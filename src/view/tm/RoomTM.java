package view.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomTM {
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;
}
