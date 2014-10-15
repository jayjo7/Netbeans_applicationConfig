package entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RelationshipTable {

    private static List<Relationship> relationships = new LinkedList<Relationship>();

    static {
        for (Relationship x : new Relationship[]{
            new Relationship("1","1"), // Fred - Floor
            new Relationship("1", "3"), // Fred - Garden
            new Relationship("2","2"), // Jim - Bullseye
            new Relationship("3","3"), // Bill - Garden
            new Relationship( "3","4"), // Bill - SCCS
            new Relationship("3", "2"), // Bill - Bullseye
            new Relationship("3", "1"), // Bill - Floor
            new Relationship("4", "1"), // Sheila - Floor
            new Relationship("4", "3"), // Sheila - Garden
            new Relationship("5", "4"), // Ella - SCCS
            new Relationship("7",  "2"), // Christine - Bullseye
            new Relationship("7", "4") // Christine - SCCS
        }) {
            relationships.add(x);
        }
    }

    public static List<Relationship> getAll() {
        return Collections.unmodifiableList(relationships);
    }

    public static List<Supplier> findSuppliersOfCustomer(String custPk) {
        List<Supplier> rv = new LinkedList<Supplier>();
        for (Relationship r : relationships) {
            if (r.getCustomer().equals(custPk)) {
                rv.add(SupplierTable.findByPrimaryKey(r.getSupplier()));
            }
        }
        return rv;
    }

    public static List<Customer> findCustomersOfSupplier(String supplierPk) {
        List<Customer> rv = new LinkedList<Customer>();
        for (Relationship r : relationships) {
            if (r.getSupplier().equals(supplierPk)) {
                rv.add(CustomerTable.findByPrimaryKey(r.getCustomer()));
            }
        }
        return rv;
    }
}
