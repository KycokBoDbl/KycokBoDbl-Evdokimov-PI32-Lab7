import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Inventory<T extends Equipment> {
    private int slots;
    private List<T> equipments;

    public Inventory() {
        this.slots = 0;
        this.equipments = new ArrayList<>();
    }

    public void addItem(T item) {
        if (slots < 100) {
            equipments.add(item);
            slots++;
        } else {
            System.out.println("Инвентарь полон");
        }
    }

    public void showInventory() {
        System.out.println("Инвентарь:");
        for (T equipment : equipments) {
            equipment.showInfoWithBaseCall();
        }
    }

    public List<T> getEquipments() {
        return equipments;
    }

    // Метод сортировки инвентаря по стоимости
    public void sortInventoryByCost() {
        Collections.sort(equipments, Comparator.comparingInt(Equipment::getCost));
    }

    // Метод поиска предмета по имени
    public T findItemByName(String name) {
        Optional<T> foundItem = equipments.stream()
                .filter(equipment -> equipment.getName().equalsIgnoreCase(name))
                .findFirst();
        return foundItem.orElse(null);
    }
}