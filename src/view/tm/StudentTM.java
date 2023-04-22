package view.tm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentTM implements Comparable<StudentTM>{
    private String student_ID;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;

    @Override
    public int compareTo(StudentTM o) {
        return 0;
    }
}
