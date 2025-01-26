import java.util.Scanner;

public class Character {
    private String username;
    private Classes characterClass;
    private int level;
    private double health;
    private double damage;
    private double armor;
    private double speed;

    // Конструктор с параметрами
    public Character(String username, Classes characterClass, int level, double health, double damage, double armor, double speed) {
        this.username = username;
        this.characterClass = characterClass;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
    }

    // Вывод характеристик персонажа
    public void showStats() {
        System.out.println("Имя: " + username);
        System.out.println("Класс: " + characterClass.getClassName());
        System.out.println("Уровень: " + level);
        System.out.println("Здоровье: " + health);
        System.out.println("Урон: " + damage);
        System.out.println("Броня: " + armor);
        System.out.println("Скорость: " + speed);
    }

    // Повышение уровня (изменение характеристик)
    public void levelUp() {
        Scanner scanner = new Scanner(System.in);
        int levels = -1;
        while (levels < 0 || level + levels > 100) {
            try {
                System.out.print("Введите количество повышенных уровней: ");
                levels = scanner.nextInt();
                if (levels < 0 || level + levels > 100) {
                    throw new IllegalArgumentException("Недопустимое количество уровней.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Произошла ошибка ввода. Пожалуйста, попробуйте снова.");
                scanner.next();
            }
        }

        System.out.println("Распределите полученные очки навыков:");
        for (int i = 0; i < levels; i++) {
            int choice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    System.out.println("Оставшиеся очки: " + (levels - i));
                    System.out.println("1) Здоровье\n2) Урон\n3) Броня\n4) Скорость");
                    choice = scanner.nextInt();

                    if (choice < 1 || choice > 4) {
                        throw new IllegalArgumentException("Недопустимый выбор. Пожалуйста, выберите от 1 до 4.");
                    }

                    valid = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Произошла ошибка ввода. Пожалуйста, попробуйте снова.");
                    scanner.next();
                }
            }

            switch (choice) {
                case 1:
                    health += 5;
                    break;
                case 2:
                    damage++;
                    break;
                case 3:
                    armor++;
                    break;
                case 4:
                    speed++;
                    break;
            }
        }
        level += levels;
    }

    // Геттеры и сеттеры
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Classes getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(Classes characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}