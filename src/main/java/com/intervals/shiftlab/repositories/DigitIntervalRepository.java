package com.intervals.shiftlab.repositories;

import com.intervals.shiftlab.models.DigitInterval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitIntervalRepository extends CrudRepository<DigitInterval, Integer> {
    @Query(
            value = "select * " +
                    "from digit_intervals " +
                    "where start = (select MIN(start) from digit_intervals) " +
                    "order by `end` " +
                    "limit 1",
            nativeQuery = true
    )
    DigitInterval getMin();
}
