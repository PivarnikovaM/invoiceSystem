package sk.upjs.invoicesystem;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class CompanyComboBoxModel extends DefaultComboBoxModel<Company>{
    
     private CompaniesDao companiesDao = ObjectFactory.INSTANCE.getCompanyDao();
    
    List<Company> companies;

    

    public CompanyComboBoxModel() {
    refresh();
    }
    
    public void refresh(){
        removeAllElements();
        
        companies = companiesDao.getCompanies();
        
       
        for (Company company : companies) {
            addElement(company);
            
        }
    }
}
