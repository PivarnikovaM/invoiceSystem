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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MysqlInvoicesDao implements InvoicesDao {

    private JdbcTemplate jdbcTemplate;

    private StatisticsDao statisticsDao;

    public MysqlInvoicesDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        this.statisticsDao = ObjectFactory.INSTANCE.getStatisticsDao();
    }

    @Override
    public List<Invoice> getInvoices() {

        String sql = "SELECT * FROM invoices";
        return jdbcTemplate.query(sql, new InvoicesRowMapper());

        //invoice.setSupplier(ObjectFactory.INSTANCE.getCompanyDao().searchCompanyById(object));
        //invoice.setCustomer(ObjectFactory.INSTANCE.getCompanyDao().searchCompanyById((ObjectId) theone.get("customer")));
    }

    public Long getInvoiceIdByNumber(Integer invoiceNumber) {

        String sql = "SELECT id FROM invoices WHERE invoiceNumber = ?";
        return jdbcTemplate.queryForObject(sql, Long.class, invoiceNumber);

    }

    @Override
    public void addInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoices VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, null, invoice.getInvoiceNumber(), invoice.getSupplier().getId(),
                invoice.getCustomer().getId(), invoice.getVariableSymbol(), invoice.getConstantSymbol(),
                invoice.getExposureDate(), invoice.getPaymentDueDate(), invoice.getCurrency(),
                invoice.getPaymentsForm(), invoice.getNote(), invoice.getDrewUpBy(), null);

    }

    public void addPrice(Long invoiceId, double price) {
        String sql = "UPDATE invoices SET price = ? WHERE id = ?";
        jdbcTemplate.update(sql, price, invoiceId);

    }

    @Override
    public void updateInvoice(Invoice invoice) {
        String sql = "UPDATE invoices SET invoiceNumber = ?, supplier = ?, customer = ?, "
                + "variableSymbol = ?, constantSymbol = ?, exposureDate = ?, "
                + "paymentDueDate = ?, currency = ?, paymentForm = ?, note = ?, drewUpBy = ? WHERE id = ?";
        jdbcTemplate.update(sql, invoice.getInvoiceNumber(), invoice.getSupplier().getId(),
                invoice.getCustomer().getId(), invoice.getVariableSymbol(), invoice.getConstantSymbol(),
                invoice.getExposureDate(), invoice.getPaymentDueDate(), invoice.getCurrency(),
                invoice.getPaymentsForm(), invoice.getNote(), invoice.getDrewUpBy(), invoice.getId());
    }

    @Override
    public List<Invoice> get5LastInvoices() {
        String sql = "SELECT * FROM invoices ORDER BY exposureDate DESC LIMIT 0,5";
        return jdbcTemplate.query(sql, new InvoicesRowMapper());
    }

    @Override
    public int size() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM invoices", Integer.class);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        Connection c = null;
        Statement s = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/invoiceSystem?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", "invoiceSystem", "invoice");
            s = c.createStatement();
            s.addBatch("SET FOREIGN_KEY_CHECKS = 0");
            s.addBatch("SET SQL_SAFE_UPDATES = 0");
            s.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlInvoicesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "DELETE FROM invoices WHERE id = ?";
        jdbcTemplate.update(sql, invoice.getId());
    }

    private static class InvoicesRowMapper implements RowMapper<Invoice> {

        @Override
        public Invoice mapRow(ResultSet rs, int i) throws SQLException {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getLong("id"));
            invoice.setInvoiceNumber(rs.getInt("invoiceNumber"));
            Company searchCompanyById = ObjectFactory.INSTANCE.getCompanyDao().searchCompanyById(rs.getLong("supplierId"));
            invoice.setSupplier(searchCompanyById);
            Company searchCompanyById1 = ObjectFactory.INSTANCE.getCompanyDao().searchCompanyById(rs.getLong("customerId"));
            invoice.setCustomer(searchCompanyById1);
            invoice.setVariableSymbol(rs.getInt("variableSymbol"));
            invoice.setConstantSymbol(rs.getInt("constantSymbol"));
            invoice.setExposureDate(rs.getDate("exposureDate"));
            invoice.setPaymentDueDate(rs.getDate("paymentDueDate"));
            invoice.setCurrency(rs.getString("currency"));
            invoice.setPaymentsForm(rs.getString("paymentForm"));
            invoice.setNote(rs.getString("note"));
            invoice.setDrewUpBy(rs.getString("drewUpBy"));

            return invoice;
        }
    }

}
