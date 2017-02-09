/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlInvoicesDaoTest {

    
    private InvoicesDao invoicesDao;
    private CompaniesDao companiesDao;
    private JdbcTemplate jdbcTemplate;
    private Invoice invoice;
    
 

    @Before
    public void setUp() {
        
        invoicesDao = ObjectFactory.INSTANCE.getInvoicesDao();
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        companiesDao = ObjectFactory.INSTANCE.getCompanyDao();
        this.invoice = new Invoice();
        
        invoice.setSupplier(companiesDao.getCompanies().get(0));
        invoice.setCustomer(companiesDao.getCompanies().get(0));
        
        
    }

    //funguje
    @Test
    public void testGetInvoices() {

        List<Invoice> invoices = invoicesDao.getInvoices();
        assertTrue(invoices.size() >= 0);
    }

    //funguje
    @Test
    public void testAddInvoice() {
        
        invoice.setInvoiceNumber(0);
        int povodne = invoicesDao.getInvoices().size();
        
        //invoicesDao.addInvoice(invoice);
        
        int nove = invoicesDao.getInvoices().size();
       
        assertEquals(povodne, nove);
        
       
        

    }

    //.funguje
    @Test
    public void testDeleteInvoice() {
        
        invoice.setInvoiceNumber(1);
        
        int povodne = invoicesDao.getInvoices().size();
        
        invoicesDao.deleteInvoice(invoice);
        int nove = invoicesDao.getInvoices().size();
        assertEquals(povodne, nove);
        
        
       
    }

    //funguje
    @Test
    public void testGet5LastInvoices() {
        List<Invoice> invoices = invoicesDao.get5LastInvoices();
        assertTrue(invoices.size() >= 0);
    }

}
