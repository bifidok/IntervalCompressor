package com.intervals.shiftlab.services;

import com.intervals.shiftlab.dto.DigitIntervalResponse;
import com.intervals.shiftlab.dto.LetterIntervalResponse;
import com.intervals.shiftlab.exceptions.IntervalNotFoundException;
import com.intervals.shiftlab.models.DigitInterval;
import com.intervals.shiftlab.models.LetterInterval;
import com.intervals.shiftlab.repositories.DigitIntervalRepository;
import com.intervals.shiftlab.repositories.LetterIntervalRepository;
import com.intervals.shiftlab.utils.IntervalCompressor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntervalService {
    private final DigitIntervalRepository digitIntervalRepository;
    private final LetterIntervalRepository letterIntervalRepository;

    public IntervalService(DigitIntervalRepository digitIntervalRepository, LetterIntervalRepository letterIntervalRepository) {
        this.digitIntervalRepository = digitIntervalRepository;
        this.letterIntervalRepository = letterIntervalRepository;
    }

    @Transactional(readOnly = true)
    public DigitIntervalResponse getMinDigitInterval() {
        DigitInterval digitInterval = digitIntervalRepository.getMin();
        if (digitInterval == null) {
            throw new IntervalNotFoundException();
        }
        return new DigitIntervalResponse(digitInterval.getStart(), digitInterval.getEnd());
    }

    @Transactional(readOnly = true)
    public LetterIntervalResponse getMinLetterInterval() {
        LetterInterval letterInterval = letterIntervalRepository.getMin();
        if (letterInterval == null) {
            throw new IntervalNotFoundException();
        }
        return new LetterIntervalResponse(letterInterval.getStart(), letterInterval.getEnd());
    }

    @Transactional
    public boolean mergeDigitIntervals(int[][] intervals) {
        int[][] mergedIntervals = IntervalCompressor.mergeDigitIntervals(intervals);
        for (int i = 0; i < mergedIntervals.length; i++) {
            DigitInterval digitInterval = new DigitInterval(mergedIntervals[i][0], mergedIntervals[i][1]);
            digitIntervalRepository.save(digitInterval);
        }
        return true;
    }

    @Transactional
    public boolean mergeLetterIntervals(char[][] intervals) {
        char[][] mergedIntervals = IntervalCompressor.mergeLetterIntervals(intervals);
        for (int i = 0; i < mergedIntervals.length; i++) {
            LetterInterval letterInterval = new LetterInterval(mergedIntervals[i][0], mergedIntervals[i][1]);
            letterIntervalRepository.save(letterInterval);
        }
        return true;
    }
}
