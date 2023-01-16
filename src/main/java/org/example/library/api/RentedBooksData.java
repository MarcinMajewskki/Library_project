package org.example.library.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class RentedBooksData {
    private String title;
    private Date rentDate;
    private Date returnUntil;
}
