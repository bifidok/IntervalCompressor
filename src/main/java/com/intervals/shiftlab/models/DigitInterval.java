package com.intervals.shiftlab.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "digit_intervals")
@NoArgsConstructor
@Data
public class DigitInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "start")
    private int start;
    @Column(name = "end")
    private int end;

    public DigitInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
