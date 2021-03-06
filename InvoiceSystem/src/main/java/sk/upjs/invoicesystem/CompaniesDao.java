package sk.upjs.invoicesystem;

import java.util.List;
import org.bson.types.ObjectId;


public interface CompaniesDao {
    //pridam spolocnost
    public void addCompany(Company company);            
    //vymazem spolocnost
    public void deleteCompany(Company company);         
    //vrati mi list vsetkych spolocnosti
    public List<Company> getCompanies();                
    //vyhladam spolocnost podla mena
    public Company searchCompanyByCompanyName(String companyName);  
    //vyhladam spolocnost podla Id
    public Company searchCompanyById(Long id);
    
    public void updateCompany(Company company);
    
    public int size();
    
    public List<Company> searchCompaniesByName(String companyName);
  
}
