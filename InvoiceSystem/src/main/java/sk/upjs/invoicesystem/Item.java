package sk.upjs.invoicesystem;

import org.bson.types.ObjectId;

public class Item {

    private Long id;
    private String description;
    private Integer amount;
    private Double pricePerPiece;
    private Long invoiceId;
    private String unitOfAmount;

    public Item() {
        
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.pricePerPiece = pricePerPiece;
        this.invoiceId = invoiceId;
        this.unitOfAmount = unitOfAmount;
    }


    
    public String getUnitOfAmount() {    
        return unitOfAmount;
    }

    /*public Item(String description, Integer amount, double pricePerPiece, String unitOfQuantity) {
    this.description = description;
    this.amount = amount;
    this.pricePerPiece = pricePerPiece;
    this.unitOfAmount = unitOfQuantity;
    }*/
    public void setUnitOfAmount(String unitOfAmount) {
        this.unitOfAmount = unitOfAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

}
