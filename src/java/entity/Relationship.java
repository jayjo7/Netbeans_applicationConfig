package entity;

import java.util.Objects;

public class Relationship {

    private String customer;
    private String supplier;

    public String getCustomer() {
        return customer;
    }

    public String getSupplier() {
        return supplier;
    }

    public Relationship(String customer, String supplier) {
        this.customer = customer;
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Relationship other = (Relationship) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Relationship{" + "customer=" + customer + ", supplier=" + supplier + '}';
    }
}
