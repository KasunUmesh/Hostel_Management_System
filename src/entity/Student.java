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
public class Student {
    @Id
    private String student_ID;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
}
