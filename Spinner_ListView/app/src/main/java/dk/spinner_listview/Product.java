package dk.spinner_listview;

/**
 * Created by kienm on 22/11/2016.
 */

public class Product extends Goods {
    //Lấy tham chiếu để lập trình cho lẹ
    private Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String ma, String name, Catalog dmuc) {
        super(ma, name);
        Dmuc = dmuc;
    }

    public Product(String ma, String name) {
        super(ma, name);
    }

    public Product() {
        super();
    }
}
