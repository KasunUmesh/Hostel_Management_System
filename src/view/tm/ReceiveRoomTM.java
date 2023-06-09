package view.tm;

import entity.Room;
import entity.Student;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReceiveRoomTM implements Comparable<ReceiveRoomTM>{
    private String res_ID;
    private LocalDate resDate;
    private String studentID;
    private String studentName;
    private String roomID;
    private String roomTypeName;
    private String status;

    @Override
    public int compareTo(ReceiveRoomTM o) {
        return 0;
    }
}
