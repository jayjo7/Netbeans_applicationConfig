package entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SupplierTable {

    private static Map<String, Supplier> data = new HashMap<String, Supplier>();

    static {
        for (Supplier x : new Supplier[]{
            new Supplier("1", "Floor Mart"),
            new Supplier("2", "Bullseye"),
            new Supplier("3", "Garden Depot"),
            new Supplier("4", "SCCS")
        }) {
            data.put(x.getId(), x);
        }
    }

    public static List<Supplier> getAll() {
        List<Supplier> rv = new LinkedList<Supplier>();
        for (Map.Entry<String, Supplier> e : data.entrySet()) {
            rv.add(e.getValue());
        }
        return rv;
    }

    public static Supplier findByPrimaryKey(String pk) {
        return data.get(pk);
    }
}
