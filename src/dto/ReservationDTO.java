package dto;

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
    private String studentID;
    private String roomID;
    private String status;
}
