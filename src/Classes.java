public enum Classes {
    SWORDSMAN("Мечник"),
    ARCHER("Лучник"),
    SPEARMAN("Копейщик"),
    THIEF("Вор"),
    HAMMERER("Молотоборец"),
    SHIELDBEARER("Щитоносец");

    private final String className;
    Classes(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }
}
