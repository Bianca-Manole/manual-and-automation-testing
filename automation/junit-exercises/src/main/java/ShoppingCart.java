import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

        List<String> items = new ArrayList<>();


    public void addItem(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        items.add(item);
    }

    public void removeItem(String item) {
        if(item == null){
            throw new NullPointerException();
        }
        if(!items.contains(item)){
            throw new IllegalArgumentException("Produsul nu exista in cos.");
        }
        items.remove(item);
    }

    public int getItemCount() {
        return items.size();
    }
}
