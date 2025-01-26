public class Item extends Equipment {
    private String description;

    public Item(String name, String description, int cost) {
        super(name, cost);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void showInfoWithBaseCall() {
        super.showInfo();
        System.out.println("Описание: " + description);
    }
}