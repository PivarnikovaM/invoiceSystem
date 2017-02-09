package sk.upjs.invoicesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlItemsDao implements ItemsDao {
    
    private JdbcTemplate jdbcTemplate;
    
     public MysqlItemsDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public List<Item> getItemsByInvoiceId(Long idInvoice) {
          String sql = "SELECT * FROM items WHERE invoiceId = ?";
        return jdbcTemplate.query(sql, new ItemsRowMapper(), idInvoice);
    }

    @Override
    public void addItem(Item item) {
        jdbcTemplate.update("INSERT INTO items VALUES (?,?,?,?,?)", null, 
                item.getDescription(), item.getAmount(), item.getPricePerPiece(), item.getInvoiceId());
    }

    @Override
    public int size() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM items", Integer.class);
    }

    @Override
    public void deleteItems(Long invoiceId) {
        
        Connection c = null;
        Statement s = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/invoiceSystem?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8","invoiceSystem", "invoice");
            s = c.createStatement();
            s.addBatch("SET FOREIGN_KEY_CHECKS = 0");
            s.addBatch("SET SQL_SAFE_UPDATES = 0");
            s.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlItemsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "DELETE FROM items WHERE invoiceId = ?";
        jdbcTemplate.update(sql,invoiceId);
       
    }

    private static class ItemsRowMapper implements RowMapper<Item> {
        
        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setDescription(rs.getString("description"));
            item.setAmount(rs.getInt("amount"));
            item.setPricePerPiece(rs.getLong("pricePerPiece"));
            item.setInvoiceId(rs.getLong("invoiceId"));
            
            
            return item;
        }
    }

}
