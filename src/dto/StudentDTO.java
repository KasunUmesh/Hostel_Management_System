package dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
    private String student_ID;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
