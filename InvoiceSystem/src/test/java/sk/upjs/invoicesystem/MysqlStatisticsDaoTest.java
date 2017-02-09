package sk.upjs.invoicesystem;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlStatisticsDaoTest {
    
    StatisticsDao statisticsDao;
    private JdbcTemplate jdbcTemplate;
    

     @Before
    public void setUp() {
        
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        statisticsDao = ObjectFactory.INSTANCE.getStatisticsDao();
    }
    
    //funguje
    @Test
    public void testGetStatistics() {
        
        List<Statistics> statistics = statisticsDao.getStatistics();
        assertTrue(statistics.size() >= 0);
        
    }

  
    @Test
    public void testGetMonth() {
        int month = statisticsDao.getMonth(28L);
        assertTrue(month > 0);
    }

    @Test
    public void testIsThere() {
        
        boolean there = statisticsDao.isThere(12L, 2);
        assertTrue(there);
    }

    //funguje
    @Test
    public void testCalculateEarnings() {
        
        double calculateEarnings = statisticsDao.calculateEarnings(12L, 2);
        assertTrue(calculateEarnings >= 0);
    }
    
}
