package edu.icet.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Member {
    @Id
    private String id;
    private String name;
    private String city;
    private String dob;
    private String nic;
}
