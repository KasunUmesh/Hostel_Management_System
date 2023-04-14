package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;
}
