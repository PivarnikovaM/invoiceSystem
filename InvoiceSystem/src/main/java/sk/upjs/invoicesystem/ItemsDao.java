package sk.upjs.invoicesystem;

import java.util.List;
import org.bson.types.ObjectId;

public interface ItemsDao {

    public List<Item> getItemsByInvoiceId(Long idInvoice);     //dostanem polozky ktore patria k fakture

    public void addItem(Item item);                         //pridam jednu polozku
    
    public void deleteItems(Long idInvoice);             //vymazem vsetky polozky podla id faktury
    
    public int size();
    
}
