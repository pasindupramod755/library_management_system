package edu.icet.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Book {
    @Id
    private String id;
    private String isbm;
    private String writer;
    private int rackNo;
    private String category;
    private double price;

}
