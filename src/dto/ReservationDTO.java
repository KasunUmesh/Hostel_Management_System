package dto;

import entity.Room;
import entity.Student;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDTO implements Serializable {
    private String res_ID;
    private LocalDate resDate;
    private Student studentID;
    private Room roomID;
    private String status;
}
