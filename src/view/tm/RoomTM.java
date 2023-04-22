package view.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomTM implements Comparable<RoomTM>{
    private String room_type_id;
    private String room_type;
    private double key_money;
    private int qty;

    @Override
    public int compareTo(RoomTM o) {
        return 0;
    }
}
