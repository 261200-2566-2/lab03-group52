
public class Main {
    public static void main(String[] args) {

        RPGcharacter player = new RPGcharacter("kyungsoo", "feeeeeeMale");

        // Display initial stats
        System.out.println("Initial Stats:");
        player.showStat(player);

        // Level up the character
        player.characterlevelup();
        System.out.println("\nAfter Level Up:");
        player.showStat(player);

        // Equip a sword
        player.equip("sword");
        System.out.println("\nAfter Equipping Sword:");
        player.showStat(player);

        // Level up the sword
        player.swordLevelup();
        System.out.println("\nAfter Sword Level Up:");
        player.showStat(player);

        // Unequip the sword
        player.unequip("sword");
        System.out.println("\nAfter Unequipping Sword:");
        player.showStat(player);

        // Equip a shield
        player.equip("shield");
        System.out.println("\nAfter Equipping Shield:");
        player.showStat(player);

        // Level up the shield
        player.shieldLevelup();
        System.out.println("\nAfter Shield Level Up:");
        player.showStat(player);

        player.equip("affs");
        player.equip("shield");
        player.equip("sword");
        player.showStat(player);

        RPGcharacter.showStatGM(player);
    }
}