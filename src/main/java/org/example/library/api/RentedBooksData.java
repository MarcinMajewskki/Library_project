package org.example.library.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class RentedBooksData {
    private String title;
    private LocalDate rentDate;
    private LocalDate returnUntil;
}
