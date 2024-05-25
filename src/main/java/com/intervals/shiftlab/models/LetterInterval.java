package com.intervals.shiftlab.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "letter_intervals")
@NoArgsConstructor
@Data
public class LetterInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "start")
    private char start;
    @Column(name = "end")
    private char end;

    public LetterInterval(char start, char end) {
        this.start = start;
        this.end = end;
    }
}
