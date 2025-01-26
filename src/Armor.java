public class Armor extends Equipment implements Cloneable {
    private Classes armorClass;
    private int level;
    private double defense;

    public Armor(String name, Classes armorClass, int level, int cost, double defense) {
        super(name, cost);
        this.armorClass = armorClass;
        this.level = level;
        this.defense = defense;
    }

    public Classes getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Classes armorClass) {
        this.armorClass = armorClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public void showInfoWithBaseCall() {
        super.showInfo();
        System.out.println("Класс: " + armorClass.getClassName()
                + ", Уровень: " + level
                + ", Защита: " + defense);
    }

    @Override
    public Armor clone() {
        try {
            Armor cloned = (Armor) super.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
