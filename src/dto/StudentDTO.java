package dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO implements Serializable {
    private String student_ID;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
