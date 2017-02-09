package sk.upjs.invoicesystem;

import java.util.Date;
import java.util.*;
import org.bson.types.ObjectId;

public class Invoice {

    private Long id;
    private Company supplier;
    private Company customer;
    private Integer invoiceNumber;
    private Integer variableSymbol;
    private Integer constantSymbol;
    private Date exposureDate;
    private Date deliveryDate;
    private Date paymentDueDate;
    private String currency;
    private String paymentsForm;
    private String note;
    private String drewUpBy;
    private List<Item> products = new ArrayList<Item>();

    public Invoice() {
        this.supplier = supplier;
        this.customer = customer;
        this.invoiceNumber = invoiceNumber;
        this.variableSymbol = variableSymbol;
        this.constantSymbol = constantSymbol;
        this.exposureDate = exposureDate;
        this.deliveryDate = deliveryDate;
        this.paymentDueDate = paymentDueDate;
        this.currency = currency;
        this.paymentsForm = paymentsForm;
        this.note = note;
        this.drewUpBy = drewUpBy;
    }
    
    public void setProducts(List<Item> products) {
        this.products = products;
    }

    public List<Item> getProducts() {
        return products;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setVariableSymbol(Integer variableSymbol) {
        this.variableSymbol = variableSymbol;
    }

    public void setConstantSymbol(Integer constantSymbol) {
        this.constantSymbol = constantSymbol;
    }

    public void setExposureDate(Date exposureDate) {
        this.exposureDate = exposureDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setFormOfPayments(String formOfPayments) {
        this.paymentsForm = formOfPayments;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDrewUpBy(String drewUpBy) {
        this.drewUpBy = drewUpBy;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public Integer getVariableSymbol() {
        return variableSymbol;
    }

    public Integer getConstantSymbol() {
        return constantSymbol;
    }

    public Date getExposureDate() {
        return exposureDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFormOfPayments() {
        return paymentsForm;
    }

    public String getNote() {
        return note;
    }

    public String getDrewUpBy() {
        return drewUpBy;
    }

    public void setSupplier(Company supplier) {
        this.supplier = supplier;
    }

    public void setCustomer(Company customer) {
        this.customer = customer;
    }

    public void setPaymentsForm(String paymentsForm) {
        this.paymentsForm = paymentsForm;
    }

    public Company getSupplier() {
        return supplier;
    }

    public Company getCustomer() {
        return customer;
    }

    public String getPaymentsForm() {
        return paymentsForm;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    /*public void addProduct(String name, Integer count, Double pricePerPiece, String unitOfQuantity) {
        Item product = new Item(name, count, pricePerPiece, unitOfQuantity);
        products.add(product);

    }*/
}
