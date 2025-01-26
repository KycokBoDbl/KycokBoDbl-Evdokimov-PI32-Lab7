import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int playerCount = 0;
    private static List<Player> allPlayers = new ArrayList<>();
    private Character character;
    private Inventory<Equipment> inventory;

    // создание нового персонажа
    public Player(Character character) {
        this.character = character;
        this.inventory = new Inventory<>();
        playerCount++;
        allPlayers.add(this);
        setInventory();
    }

    public void setInventory() {
        Weapon weapon;
        Armor armor;
        Item item;
        item = new Item("Зелье лечения", "Восстанавливает 30 здоровья", 10);
        inventory.addItem(item);
        item = new Item("Телепортирующее зеркало", "Позволяет вернуться в стартовый город", 30);
        inventory.addItem(item);
        Classes characterClass = character.getCharacterClass();
        switch (characterClass) {
            case SWORDSMAN:
                weapon = new Weapon("Меч новичка", Classes.SWORDSMAN, 1, 20, 4);
                inventory.addItem(weapon);
                armor = new Armor("Броня мечника", Classes.SWORDSMAN, 1, 15, 3);
                inventory.addItem(armor);
                break;
            case ARCHER:
                weapon = new Weapon("Лук новичка", Classes.ARCHER, 1, 20, 3);
                inventory.addItem(weapon);
                armor = new Armor("Доспехи лучника", Classes.ARCHER, 1, 15, 2);
                inventory.addItem(armor);
                break;
            case SPEARMAN:
                weapon = new Weapon("Копьё новичка", Classes.SPEARMAN, 1, 25, 5);
                inventory.addItem(weapon);
                armor = new Armor("Броня копейщика", Classes.SPEARMAN, 1, 18, 3);
                inventory.addItem(armor);
                break;
            case THIEF:
                weapon = new Weapon("Кинжалы новичка", Classes.THIEF, 1, 15, 3);
                inventory.addItem(weapon);
                armor = new Armor("Лёгкая броня вора", Classes.THIEF, 1, 10, 1);
                inventory.addItem(armor);
                break;
            case HAMMERER:
                weapon = new Weapon("Молот новичка", Classes.HAMMERER, 1, 30, 6);
                inventory.addItem(weapon);
                armor = new Armor("Тяжёлая броня молотоборца", Classes.HAMMERER, 1, 20, 4);
                inventory.addItem(armor);
                break;
            default:
                weapon = new Weapon("Щит новичка", Classes.SHIELDBEARER, 1, 20, 2);
                inventory.addItem(weapon);
                armor = new Armor("Броня щитоносца", Classes.SHIELDBEARER, 1, 17, 5);
                inventory.addItem(armor);
                break;
        }
    }

    public void showStats() {
        character.showStats();
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Inventory<Equipment> getInventory() {
        return inventory;
    }

    public void setInventory(Inventory<Equipment> inventory) {
        this.inventory = inventory;
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public static List<Player> getAllPlayers() {
        return allPlayers;
    }
}