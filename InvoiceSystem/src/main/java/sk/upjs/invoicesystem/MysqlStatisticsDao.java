package sk.upjs.invoicesystem;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlStatisticsDao implements StatisticsDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlStatisticsDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Statistics> getStatistics() {

        String sql = "SELECT * FROM statistics";
        BeanPropertyRowMapper<Statistics> mapper = BeanPropertyRowMapper.newInstance(Statistics.class);
        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public void addStatistics(Long supplierId, int month) {

        if (isThere(supplierId, month)) {
            String sql = "UPDATE statistics SET earnings = ? WHERE supplierId = ? and month = ?";
            jdbcTemplate.update(sql,calculateEarnings(supplierId, month),supplierId,month); 
        } else {
            String sql = "INSERT INTO statistics VALUES(?,?,?,?)";
            jdbcTemplate.update(sql, null, supplierId, calculateEarnings(supplierId,month), month);
        }
    }
    
    @Override
    public int getMonth(Long invoiceId) {
        String sql = "SELECT month(paymentDueDate) FROM invoices WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, invoiceId);
    }

    public boolean isThere(Long supplierId, int month) {
        String sql = "SELECT COUNT(*) FROM statistics WHERE supplierId = ? and month = ?";
        return (jdbcTemplate.queryForObject(sql, Integer.class, supplierId, month) != 0);
    }

    @Override
    public double calculateEarnings(Long supplierId, int month) {
        String sql = "SELECT sum(price) FROM invoices WHERE month(paymentDueDate) = ? AND supplierId = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, month, supplierId);
    }
   
}
