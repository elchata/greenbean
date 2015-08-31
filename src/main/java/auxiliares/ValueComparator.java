package auxiliares;

import java.util.Comparator;
import java.util.Map;

import beans.Producto;

public class ValueComparator implements Comparator<Producto> {

    Map<Producto, Integer> base;
    public ValueComparator(Map<Producto, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    

	@Override
	public int compare(Producto a, Producto b) {
		if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
	}
}
