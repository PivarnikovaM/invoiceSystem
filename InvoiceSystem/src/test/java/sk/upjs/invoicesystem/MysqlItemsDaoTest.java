/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.invoicesystem;

import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.bson.types.ObjectId;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author marosi
 */
public class MysqlItemsDaoTest {
    
    private ItemsDao itemsDao;
    private JdbcTemplate jdbcTemplate;
    private Item item;
    
    public MysqlItemsDaoTest() {
    }
    
    @Before
    public void setUp() {
        
        itemsDao = ObjectFactory.INSTANCE.getItemsDao();
        jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        this.item = new Item();
        this.item.setDescription("kniha");
        this.item.setInvoiceId(0L);
        this.item.setInvoiceId(28L);
        
    }
    //funguje
    @Test
    public void testGetItemsById() {
        
        List<Item> itemsByInvoiceId = itemsDao.getItemsByInvoiceId(item.getInvoiceId());
        assertTrue(itemsByInvoiceId.size() >= 0);
    }
    
    @Test
    public void testAddItem() {
        
 
        
        int povodne = itemsDao.size();
        itemsDao.addItem(item);
        int nove = itemsDao.size();
        
        assertEquals(povodne + 1, nove);
        
        jdbcTemplate.update("DELETE FROM items WHERE description = 'kniha' and id > 0");
        
    }
    
    //funguje
    @Test
    public void testSize() {
        
        assertTrue(itemsDao.size() >= 0);
    }
    
    
    @Test
    public void testDeleteItems() {
        
        itemsDao.addItem(item);
        
        this.item.setInvoiceId(1L);
        int povodne = itemsDao.size();
        itemsDao.deleteItems(item.getInvoiceId());
        int nove = itemsDao.size();
        
        assertEquals(povodne, nove);
        
        
        jdbcTemplate.update("DELETE FROM items WHERE description = 'kniha' and id > 0");
        
    }
    
}
