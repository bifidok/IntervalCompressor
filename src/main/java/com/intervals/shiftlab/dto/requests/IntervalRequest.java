package com.intervals.shiftlab.dto.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntervalRequest {
    private int [][] digitIntervals;
    private char [][] letterIntervals;
}
