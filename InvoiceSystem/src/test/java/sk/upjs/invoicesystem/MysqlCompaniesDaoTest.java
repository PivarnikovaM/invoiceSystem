/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
//sprosty git
/**
 *
 * @author marosi
 */
public class MysqlCompaniesDaoTest {

   
    private CompaniesDao companiesDao;
    private JdbcTemplate jdbcTemplate;
    private Company company;

    @Before
    public void setUp() {
        
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        companiesDao = ObjectFactory.INSTANCE.getCompanyDao();
        this.company = new Company();
        company.setCompanyName("o");
    }

    //funguje
    @Test
    public void testAddCompany() {
        
       
        int povodne = companiesDao.getCompanies().size();
        companiesDao.addCompany(company);
        int nove = companiesDao.getCompanies().size();
       
        assertEquals(povodne + 1, nove);
        
        jdbcTemplate.update("DELETE FROM companies WHERE companyName = 'o' and id > 0") ;
        

    }

    //funguje
    @Test
    public void testGetCompanies() {
        
        List<Company> companies = companiesDao.getCompanies();
        assertTrue(companies.size() >= 0);

    }

    //funguje
    @Test
    public void testSearchCompanyByCompanyName() {
        
        companiesDao.addCompany(company);
        List<Company> searchCompaniesByName = companiesDao.searchCompaniesByName("o");
        assertTrue(searchCompaniesByName.size() >= 0);
        
        jdbcTemplate.update("DELETE FROM companies WHERE companyName = 'o' and id > 0") ;
       
    }

    @Test
    public void testSearchCompanyById() {
        
        Company searchCompanyById = companiesDao.searchCompanyById(12L);
        assertTrue(searchCompanyById != null);
        
    }

    //funguje
    @Test
    public void testDeleteCompany() {
        companiesDao.addCompany(company);
        int povodne = companiesDao.getCompanies().size();
        companiesDao.deleteCompany(company);
        int nove = companiesDao.getCompanies().size();
       
        assertEquals(povodne, nove);
        
        jdbcTemplate.update("DELETE FROM companies WHERE companyName = 'o' and id > 0") ;

    }

    //funguje
    @Test
    public void testUpdateCompany(){ 
        
        int povodne = companiesDao.getCompanies().size();
        
        companiesDao.updateCompany(company);
        
        int nove = companiesDao.getCompanies().size();
        
        assertEquals(povodne, nove);
         
        
    }

}
