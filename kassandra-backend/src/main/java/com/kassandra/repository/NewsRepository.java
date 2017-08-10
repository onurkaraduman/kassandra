package com.kassandra.repository;

import com.kassandra.repository.domain.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Database operations for {@Link News}
 *
 * @author Onur Karaduman
 * @since 13.07.17
 */
@Repository
public interface NewsRepository extends com.kassandra.repository.Repository<News, Long> {

    public List<News> findByDate(Date date);

    public List<News> findByDateBetween(Date startDate, Date endDate);

    public News findByNewsId(String id);

    @Query("select Max(n.date) from News n order by n.date desc ")
    public Date getLastNewsDate();
}
