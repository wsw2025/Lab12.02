import java.util.ArrayList;
import java.lang.reflect.Method;

public class Store {
    private ArrayList<CISItem> items = new ArrayList<CISItem>();


    public void addBook(Book book){
        items.add(book);
    }

    public void addPhone(Phone phone){
        items.add(phone);
    }

    public void updatePhonesLocation(String location){
        for (int i = 0; i < items.size(); i++){
            if(items.get(i) instanceof Phone){
                items.get(i).setLocation(location);
            }
        }
    }

    public ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> phones = new ArrayList<Phone>();
        for (int i = 0; i < items.size(); i++){
            if(items.get(i) instanceof Phone){
                phones.add((Phone)items.get(i));
            }
        }
        return phones;
    }

    public ArrayList<CISItem> getItems(String item) {
        ArrayList<CISItem> allItems = new ArrayList<CISItem>();
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getClass().getSimpleName().equalsIgnoreCase(item)){
                allItems.add(items.get(i));
            }
        }
        return allItems;
    }
    public ArrayList<CISItem> getItems(){
        return items;
    }

    public void updateItems(String itemType, String property, String value){
        ArrayList<CISItem> toChange = getItems(itemType);
        for (CISItem item : toChange){
            try {
                Method getterMethod = item.getClass().getMethod("get" + property);
                Method setterMethod = item.getClass().getMethod("set" + property, getterMethod.getReturnType());

                Object currentValue = getterMethod.invoke(item);
                if (currentValue != null && currentValue.equals(value)) {
                    continue;
                }

                setterMethod.invoke(item, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showAllInfo(){
        for (CISItem item : items){
            System.out.println(item.getItemType() + " " + item.getLocation());
        }
    }
}
