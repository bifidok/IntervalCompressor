package com.intervals.shiftlab.exceptions;

public class IntervalNotFoundException extends RuntimeException {
    private final static String DESCRIPTION = "Interval not found";

    public IntervalNotFoundException() {
        super(DESCRIPTION);
    }
}
