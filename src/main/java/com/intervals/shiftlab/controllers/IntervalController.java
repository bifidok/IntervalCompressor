package com.intervals.shiftlab.controllers;

import com.intervals.shiftlab.dto.requests.IntervalRequest;
import com.intervals.shiftlab.models.enums.Kind;
import com.intervals.shiftlab.services.IntervalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/intervals")
public class IntervalController {
    private final IntervalService intervalService;

    public IntervalController(IntervalService intervalService) {
        this.intervalService = intervalService;
    }

    @GetMapping("/min")
    public String getMin(@RequestParam("kind") Kind kind) {
        return switch (kind) {
            case digits -> intervalService.getMinDigitInterval().toString();
            case letters -> intervalService.getMinLetterInterval().toString();
        };
    }

    @PostMapping("/merge")
    public HttpStatus merge(@RequestBody IntervalRequest intervals, @RequestParam("kind") Kind kind) {
        switch (kind) {
            case digits -> intervalService.mergeDigitIntervals(intervals.getDigitIntervals());
            case letters -> intervalService.mergeLetterIntervals(intervals.getLetterIntervals());
        }
        return HttpStatus.OK;
    }
}
