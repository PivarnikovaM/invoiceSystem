package sk.upjs.invoicesystem;

import com.mongodb.DBCollection;
import java.util.List;

public class MongoCompaniesDao implements CompaniesDao {
    //sorry asi som zmazal daco v POM ta dopln pls dependency abo jaky fras
    private DBCollection mongo;
    public MongoCompaniesDao(DBCollection mongo) {
        this.mongo=mongo;
    }

    @Override
    public void addCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Company> getCompanies() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Company searchCompany(String companyName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Company searchCompany(String surName, String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
