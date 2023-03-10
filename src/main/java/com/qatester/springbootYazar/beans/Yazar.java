package com.qatester.springbootYazar.beans;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Yazar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yazarID;
    @NonNull
    private String yazarAdi;
    @NonNull
    private String yazarSoyadi;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dogumTarihi;

}
