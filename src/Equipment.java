public abstract class Equipment implements Showable {
    protected String name;
    protected int cost;

    public Equipment(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void showInfo() {
        System.out.println("Название: " + name + ", Стоимость: " + cost);
    }
}
