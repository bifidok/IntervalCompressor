package com.intervals.shiftlab.repositories;

import com.intervals.shiftlab.models.LetterInterval;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterIntervalRepository extends CrudRepository<LetterInterval, Integer> {
    @Query(
            value = "select * " +
                    "from letter_intervals " +
                    "where start = (select MIN(start) from letter_intervals) " +
                    "order by `end` " +
                    "limit 1",
            nativeQuery = true
    )
    LetterInterval getMin();
}
