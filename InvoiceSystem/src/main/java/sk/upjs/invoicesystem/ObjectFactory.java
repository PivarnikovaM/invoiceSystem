package sk.upjs.invoicesystem;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;



public enum ObjectFactory {
    INSTANCE;
    private JdbcTemplate jdbcTemplate;
    
    private CompaniesDao companiesDao; 
    
    private InvoicesDao invoicesDao;
    
    private ItemsDao itemsDao;
    
    private StatisticsDao statisticsDao;


    public JdbcTemplate getJdbcTemplate() {

        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/invoiceSystem?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
            dataSource.setUser("invoiceSystem");
            dataSource.setPassword("invoice");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;

    }
 

    public CompaniesDao getCompanyDao() {
        if (this.companiesDao == null) {
            this.companiesDao = new MysqlCompaniesDao();
        }
        return companiesDao;
    }
    
    public InvoicesDao getInvoicesDao(){
        if (this.invoicesDao == null) {
            this.invoicesDao = new MysqlInvoicesDao();
        }
        return invoicesDao;
    }
    
    public ItemsDao getItemsDao(){
        if (this.itemsDao == null) {
            this.itemsDao = new MysqlItemsDao();
        }
        return itemsDao;
    }
    
    public StatisticsDao getStatisticsDao() {
        if (this.statisticsDao == null) {
            this.statisticsDao = new MysqlStatisticsDao();
        }
        return statisticsDao;
    }

}
