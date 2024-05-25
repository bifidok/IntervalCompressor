package com.intervals.shiftlab.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalCompressor {
    public static int[][] mergeDigitIntervals(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(i1,i2) -> i1[0] - i2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                result.add(new int[]{start, end});
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static char[][] mergeLetterIntervals(char[][] intervals) {
        if (intervals.length == 0) return intervals;
        List<char[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1,i2) -> (i1[0] - 'a') - (i2[0] - 'a'));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new char[]{(char) start, (char) end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                result.add(new char[]{(char) start, (char) end});
            }
        }
        return result.toArray(new char[0][0]);
    }
}
