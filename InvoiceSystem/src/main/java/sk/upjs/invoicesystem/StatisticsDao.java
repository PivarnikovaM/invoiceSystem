package sk.upjs.invoicesystem;

import java.util.List;

public interface StatisticsDao {
    
    List<Statistics> getStatistics();
    void addStatistics(Long supplierId, int month);
    int getMonth(Long invoiceId);
    double calculateEarnings(Long supplierId, int month);
    boolean isThere(Long supplierId, int month);
}
