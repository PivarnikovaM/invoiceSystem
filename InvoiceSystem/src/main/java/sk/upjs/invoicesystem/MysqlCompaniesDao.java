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

public class MysqlCompaniesDao implements CompaniesDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlCompaniesDao() {
        this.jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
    }

    @Override
    public int size() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM companies", Integer.class);
    }

    @Override
    public void addCompany(Company company) {
        String sql = "INSERT INTO companies VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, null, company.getCompanyName(), company.getStreet(), company.getCity(),
                company.getPostalCode(), company.getCountry(), company.getICO(), company.getDIC(),
                company.getICDPH(), company.getEmail(), company.getTelephoneNumber(),
                company.getIBAN());

    }

    @Override
    public void updateCompany(Company company) {
        String sql = "UPDATE companies SET companyName = ?, street = ?, city = ?, "
                + "postalCode = ?, country = ?, ico = ?, "
                + "dic = ?, dph = ?, email = ?, telNumber = ?, iban = ? WHERE id = ?";
        jdbcTemplate.update(sql, company.getCompanyName(), company.getStreet(), company.getCity(),
                company.getPostalCode(), company.getCountry(), company.getICO(), company.getDIC(),
                company.getICDPH(), company.getEmail(), company.getTelephoneNumber(),
                company.getIBAN(), company.getId());
    }

    @Override
    public void deleteCompany(Company company) {
        
        Connection c = null;
        Statement s = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/invoiceSystem?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8","invoiceSystem", "invoice");
            s = c.createStatement();
            s.addBatch("SET FOREIGN_KEY_CHECKS = 0");
            s.addBatch("SET SQL_SAFE_UPDATES = 0");
            s.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlCompaniesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "DELETE FROM companies WHERE id = ?";
        jdbcTemplate.update(sql, company.getId());

    }

    @Override
    public List<Company> getCompanies() {

        String sql = "SELECT * FROM companies";
        return jdbcTemplate.query(sql, new CompaniesRowMapper());
    }

    @Override
    public Company searchCompanyByCompanyName(String companyName) { //najde prvu company s tymto nazvom

        String sql = "SELECT * FROM companies WHERE companyName = ? LIMIT 1,1";
        return jdbcTemplate.queryForObject(sql, new CompaniesRowMapper(), companyName);

    }

    public List<Company> searchCompaniesByName(String companyName) {
        String sql = "SELECT * FROM companies WHERE companyName = ?";
        return jdbcTemplate.query(sql, new CompaniesRowMapper(), companyName);
    }

    @Override
    public Company searchCompanyById(Long id) {
        String sql = "SELECT * FROM companies WHERE id = ?";
        Company company = jdbcTemplate.queryForObject(sql, new CompaniesRowMapper(), id);
        
        return company;
    }

    private static class CompaniesRowMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet rs, int i) throws SQLException {
            Company company = new Company();
            
            company.setId(rs.getLong("id"));
            company.setCompanyName(rs.getString("companyName"));
            company.setStreet(rs.getString("street"));
            company.setCity(rs.getString("city"));
            company.setPostalCode(rs.getInt("postalCode"));
            company.setCountry(rs.getString("country"));
            company.setICO(rs.getLong("ico"));
            company.setDIC(rs.getLong("dic"));
            company.setICDPH(rs.getLong("dph"));
            company.setTelephoneNumber(rs.getString("telNumber"));
            company.setEmail(rs.getString("email"));
            company.setIBAN(rs.getString("iban"));

            return company;
        }
    }

}
