import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character = CharacterFactory.createCharacter();
        Player player = new Player(character);
        Character[][] charactersByClass = new Character[Classes.values().length][10];
        charactersByClass[character.getCharacterClass().ordinal()][0] = character;
        int choice = 0;

        Weapon originalWeapon = new Weapon("Excalibur", Classes.SWORDSMAN, 80, 10000, 500);
        try {
            Weapon clonedWeapon = originalWeapon.clone();
            System.out.println("Оружие:");
            originalWeapon.showInfoWithBaseCall();
            System.out.println("Клонированное оружие:");
            clonedWeapon.showInfoWithBaseCall();
            player.getInventory().addItem(originalWeapon);
        } catch (CloneNotSupportedException e) {
            System.err.println("Ошибка клонирования: " + e.getMessage());
        }

        Armor originalArmor = new Armor("Armor of pure", Classes.SWORDSMAN, 80, 7500, 100);
        Armor clonedArmor = originalArmor.clone();
        System.out.println("Броня:");
        originalArmor.showInfoWithBaseCall();
        System.out.println("Клонированная броня:");
        clonedArmor.showInfoWithBaseCall();
        player.getInventory().addItem(clonedArmor);

        do {
            System.out.println("Список действий:");
            System.out.println("1) Посмотреть инвентарь");
            System.out.println("2) Посмотреть характеристики");
            System.out.println("3) Создать нового персонажа");
            System.out.println("4) Повысить уровень персонажу");
            System.out.println("5) Посмотреть количество созданных игроков");
            System.out.println("6) Просмотреть всех игроков");
            System.out.println("7) Просмотреть персонажей по классам");
            System.out.println("8) Сортировка инвентаря по стоимости");
            System.out.println("9) Поиск предмета в инвентаре по имени");
            System.out.println("10) Завершение работы");

            boolean validChoice = false;
            while (!validChoice) {
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 10) {
                        throw new IllegalArgumentException("Недопустимый выбор. Пожалуйста, выберите от 1 до 10.");
                    }
                    validChoice = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Произошла ошибка ввода. Пожалуйста, попробуйте снова.");
                    scanner.next(); // Сбрасываем некорректный ввод
                }
            }
            switch (choice) {
                case 1:
                    player.getInventory().showInventory();
                    break;
                case 2:
                    player.showStats();
                    break;
                case 3: {
                    Character newCharacter = CharacterFactory.createCharacter();
                    Player newPlayer = new Player(newCharacter);
                    for (int i = 0; i < charactersByClass[newCharacter.getCharacterClass().ordinal()].length; i++) {
                        if (charactersByClass[newCharacter.getCharacterClass().ordinal()][i] == null) {
                            charactersByClass[newCharacter.getCharacterClass().ordinal()][i] = newCharacter;
                            break;
                        }
                    }
                    System.out.println("Новый персонаж создан");
                    break;
                }
                case 4:
                    player.getCharacter().levelUp();
                    break;
                case 5:
                    System.out.println("Количество созданных игроков: " + PlayerCount.getPlayerCount());
                    break;
                case 6:
                    List<Player> allPlayers = Player.getAllPlayers();
                    for (Player p : allPlayers) {
                        p.showStats();
                    }
                    break;
                case 7:
                    System.out.println("Выберите класс персонажа для просмотра:");
                    for (int i = 0; i < Classes.values().length; i++) {
                        System.out.println((i + 1) + ") " + Classes.values()[i].getClassName());
                    }
                    int classChoice = scanner.nextInt() - 1;
                    if (classChoice >= 0 && classChoice < Classes.values().length) {
                        for (Character c : charactersByClass[classChoice]) {
                            if (c != null) {
                                c.showStats();
                            }
                        }
                    } else {
                        System.err.println("Недопустимый выбор класса.");
                    }
                    break;
                case 8:
                    // Сортировка инвентаря по стоимости
                    player.getInventory().sortInventoryByCost();
                    System.out.println("Инвентарь отсортирован по стоимости.");
                    break;
                case 9:
                    // Поиск предмета в инвентаре по имени
                    System.out.println("Введите имя предмета для поиска:");
                    scanner.nextLine(); // Consume newline
                    String searchName = scanner.nextLine();
                    Equipment foundItem = player.getInventory().findItemByName(searchName);
                    if (foundItem != null) {
                        System.out.println("Найденный предмет:");
                        foundItem.showInfoWithBaseCall();
                    } else {
                        System.out.println("Предмет с именем " + searchName + " не найден.");
                    }
                    break;
                default:
                    System.out.println("Завершение работы...");
                    break;
            }
        } while (choice != 10);
    }
}