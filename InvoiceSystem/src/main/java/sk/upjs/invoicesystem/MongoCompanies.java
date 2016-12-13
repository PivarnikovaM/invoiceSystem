package sk.upjs.invoicesystem;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author marosi
 */
public class MongoCompanies implements CompaniesDao {

    private DBCollection mongo;

    public MongoCompanies(DBCollection mongo) {
        this.mongo = mongo;
    }

    @Override
    public long size() {

        return mongo.getCount();
    }

    @Override
    public void addCompany(Company company) {

        BasicDBObject doc = new BasicDBObject("companyName", company.getCompanyName())
                .append("street", company.getStreet())
                .append("city", company.getCity())
                .append("postalCode", company.getPostalCode())
                .append("country", company.getCountry())
                .append("ico", company.getICO())
                .append("dic", company.getDIC())
                .append("dph", company.getICDPH())
                .append("telephoneNumber", company.getTelephoneNumber())
                .append("email", company.getEmail())
                .append("iban", company.getIBAN());
        mongo.insert(doc);

    }

    @Override
    public void updateCompany(Company company) {
        BasicDBObject doc = new BasicDBObject();

        doc.append("$set", new BasicDBObject().append("companyName", company.getCompanyName()))
                .append("$set", new BasicDBObject().append("street", company.getStreet()))
                .append("$set", new BasicDBObject().append("city", company.getCity()))
                .append("$set", new BasicDBObject().append("postalCode", company.getPostalCode()))
                .append("$set", new BasicDBObject().append("country", company.getCountry()))
                .append("$set", new BasicDBObject().append("ico", company.getICO()))
                .append("$set", new BasicDBObject().append("dic", company.getDIC()))
                .append("$set", new BasicDBObject().append("dph", company.getICDPH()))
                .append("$set", new BasicDBObject().append("telephoneNumber", company.getTelephoneNumber()))
                .append("$set", new BasicDBObject().append("email", company.getEmail()))
                .append("$set", new BasicDBObject().append("iban", company.getIBAN()));
        BasicDBObject searchQuery = new BasicDBObject().append("_id", company.getIdCompany());
        mongo.update(searchQuery, doc);

    }

    @Override
    public void deleteCompany(Company company) {
        ObjectId objectId = company.getIdCompany();
        BasicDBObject query = new BasicDBObject("_id", objectId);
        DBObject theone = mongo.findOne(query);
        mongo.remove(theone);

    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<Company>();
        DBCursor cursor = mongo.find();

        while (cursor.hasNext()) {
            Company company = new Company();
            DBObject theone = cursor.next();
            company.setIdCompany((ObjectId) theone.get("_id"));
            company.setCompanyName((String) theone.get("companyName"));
            company.setStreet((String) theone.get("street"));
            company.setCity((String) theone.get("city"));
            company.setPostalCode((int) theone.get("postalCode"));
            company.setCountry((String) theone.get("country"));
            company.setICO((Long) theone.get("ico"));
            company.setDIC((Long) theone.get("dic"));
            company.setICDPH((Long) theone.get("dph"));
            company.setTelephoneNumber((String) theone.get("telephoneNumber"));
            company.setEmail((String) theone.get("email"));
            company.setIBAN((String) theone.get("iban"));
            companies.add(company);
        }
        return companies;
    }

    @Override
    public Company searchCompanyByCompanyName(String companyName) {
        Company company = new Company();
        List<Company> companies = getCompanies();
        DBCursor cursor = mongo.find();

        while (cursor.hasNext()) {
            DBObject theone = cursor.next();
            if (theone.get("companyName") != null) {
                if (theone.get("companyName").equals(companyName)) {

                    company.setIdCompany((ObjectId) theone.get("_id"));
                    company.setCompanyName((String) theone.get("companyName"));
                    company.setStreet((String) theone.get("street"));
                    company.setCity((String) theone.get("city"));
                    company.setPostalCode((int) theone.get("postalCode"));
                    company.setCountry((String) theone.get("country"));
                    company.setICO((Long) theone.get("ico"));
                    company.setDIC((Long) theone.get("dic"));
                    company.setICDPH((Long) theone.get("dph"));
                    company.setTelephoneNumber((String) theone.get("telephoneNumber"));
                    company.setEmail((String) theone.get("email"));
                    company.setIBAN((String) theone.get("iban"));
                }
            }

        }
        return company;
    }

    public List<Company> searchCompanyByNameInList(String companyName) {
        List<Company> companies = getCompanies();
        List<Company> searched = new ArrayList<Company>();
        if (companyName != null && !companyName.equals("")) {
            for (Company companyFromAll : companies) {
                String name = companyFromAll.getCompanyName();
                int shorter = Math.min(name.length(), companyName.length());
                boolean isInList = true;
                for (int i = 0; i < shorter; i++) {
                    if (name.charAt(i) != companyName.charAt(i)) {
                        isInList = false;
                        break;
                    }
                }
                if (isInList) {
                    searched.add(companyFromAll);
                }
            }
            return searched;
        }
        return companies;
    }

    @Override
    public Company searchCompanyById(ObjectId objectId) {
        Company company = new Company();

        List<Company> companies = getCompanies();
        DBCursor cursor = mongo.find();

        while (cursor.hasNext()) {
            DBObject theone = cursor.next();
            if (theone.get("_id") != null) {
                if (theone.get("_id").equals(objectId)) {
                    company.setIdCompany((ObjectId) theone.get("_id"));
                    company.setCompanyName((String) theone.get("companyName"));
                    company.setStreet((String) theone.get("street"));
                    company.setCity((String) theone.get("city"));
                    company.setPostalCode((int) theone.get("postalCode"));
                    company.setCountry((String) theone.get("country"));
                    company.setICO((Long) theone.get("ico"));
                    company.setDIC((Long) theone.get("dic"));
                    company.setICDPH((Long) theone.get("dph"));
                    company.setTelephoneNumber((String) theone.get("telephoneNumber"));
                    company.setEmail((String) theone.get("email"));
                    company.setIBAN((String) theone.get("iban"));
                }

            }
        }
        return company;
    }

}
