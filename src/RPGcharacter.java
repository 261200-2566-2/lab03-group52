public class RPGcharacter {
    String name;
    String gender;
    double attack;
    double mana;
    double defense;
    double health;
    double movement_speed;
    int level=1;
    String weapon;
    int levelsword;
    int levelshield;
    int valuesword;
    int valueshield;
    double swordATK=5;
    double shieldDEF=3;
    double swordSPD;
    double shieldSPD;
    int valueweapon;
    String [] arrweaponlist=new String[2];


    // Constructor
    public RPGcharacter(String name, String gender) {
        this.name = name;
        this.gender = gender;
        DefaultStats();
    }//เป็นฟังก์ชันที่จะรับinputเป็นชื่อและเพศ แล้วสร้างตัวละครชื่อนั้นๆ จากนั้นจะไปเรียกDefaultStats()เพื่อเซ็ทstatเริ่มต้น
    void DefaultStats() {
        attack = 20;
        defense = 10;
        health = 100;
        mana = 10;
        movement_speed = 20;
    }//เป็นฟังก์ชันที่ไม่มีinput เอาไว้เซ็ทค่าstatเริ่มต้น


    void characterlevelup() {
        attack +=4*level;
        defense +=5*level;
        health +=5*level;
        mana +=2*level;
        movement_speed += (0.1+0.03*level);
        level++;
        System.out.println("Levelup+++");
    }//เป็นฟังก์ชันที่ไม่มีinput เอาไว้เปลี่ยนค่าstatเมื่อตัวละครlevel up

    void equip(String weapon) {
        String checkweapon = weapon.toLowerCase();
        if (valueweapon < arrweaponlist.length) {
            if (checkweapon.equals("sword")) {
                swordATK = 5;
                swordSPD = 5 * (0.1 + 0.04);
                System.out.println("You have equipped the sword.");
                attack += swordATK;
                movement_speed -= swordSPD;
                levelsword++;
                arrweaponlist[valueweapon] = "sword";
                valuesword++;
                valueweapon++;
            } else if (checkweapon.equals("shield")) {
                shieldDEF = 3;
                shieldSPD = 5 * (0.1 + 0.08);
                System.out.println("You have equipped the shield.");
                defense += shieldDEF;
                movement_speed -= shieldSPD;
                levelshield++;
                arrweaponlist[valueweapon] = "shield";
                valueshield++;
                valueweapon++;
            } else {
                System.out.println("You can only choose weapons shield and swords.");
            }
        } else {
            System.out.println("Your hands are full of weapons. You can no longer equip weapons.");
        }
    }
//ฟังก์ชันนี้จะรับinputเป็นอาวุธ ใช้ในการใส่อาวุธลงไปในตัวละคร โดยมีการตรวจสอบว่ามีที่ว่างในอาวุธหรือไม่ และตรวจสอบว่าอาวุธที่ใส่เข้ามาเป็น "sword" หรือ "shield" เท่านั้น

    void swordLevelup(){
        swordATK+=10 * (1 + 0.1*levelsword);
        swordSPD+=5*(0.1+0.04*levelsword);
        attack += swordATK;
        movement_speed -= swordSPD;
        levelsword++;
        System.out.println("Your sword has been upgraded.");
    }
    //เป็นฟังก์ชันที่ไม่มีinput ใช้ในการเพิ่มระดับของ "sword" ซึ่งจะเพิ่มพลังโจมตีและความเร็วในการใช้ "sword" ของตัวละคร
    void shieldLevelup(){
        shieldDEF+= 10 * (1 + 0.05 * levelshield);
        shieldSPD+=5*(0.1+0.08*levelshield);
        defense += shieldDEF;
        movement_speed -= shieldSPD;
        levelshield++;
        System.out.println("Your shield has been upgraded.");
    }
    //เป็นฟังก์ชันที่ไม่มีinput ใช้ในการเพิ่มระดับของ"shield" ซึ่งจะเพิ่มความป้องกันและความเร็วในการใช้ "shield" ของตัวละคร
    void unequip(String weapon){
        String checkweapon=weapon.toLowerCase();
        if(arrweaponlist[0].equals("sword")||arrweaponlist[1].equals("sword")&&checkweapon.equals("sword")) {
            if(valuesword>0){
                System.out.println("You have unequip the sword.");
                attack -= swordATK;
                movement_speed += swordSPD;
                valuesword--;
                valueweapon--;
            }
        }else if(arrweaponlist[0].equals("shield")||arrweaponlist[1].equals("shield")&&checkweapon.equals("shield")) {
            if(valueshield>0){
                System.out.println("You have unequip the shield.");
                defense -= shieldDEF;
                movement_speed += shieldSPD;
                valueshield--;
                valueweapon--;
            }
        }else{
            System.out.println("You don't have this weapon anymore.");
        }
    }
    // ฟังก์ชันนี้จะรับinputเป็นอาวุธใช้ในการถอดอาวุธออกจากตัวละคร โดยมีการตรวจสอบว่าตัวละครมี "sword" หรือ "shield" อยู่หรือไม่ และถ้ามีจะทำการถอดออก
    void showStat(RPGcharacter character) {
        System.out.println("Name: " + character.name);
        System.out.println("Gender: " + character.gender);
        System.out.println("Level: " + character.level);
        System.out.println("Attack: " + character.attack);
        System.out.println("Defense: " + character.defense);
        System.out.println("Health: " + character.health);
        System.out.println("Mana: " + character.mana);
        if(movement_speed>0){
            System.out.println("Movement Speed: " + character.movement_speed);
        }else{
            System.out.println("Movement Speed: 0");
        }
        if(valueweapon==0){
            System.out.println("You have 0 weapons.");
        }else if(valueweapon==1){
            System.out.println("You have "+arrweaponlist[0]+".");
        }else{
            System.out.println("You have "+arrweaponlist[0]+" and "+arrweaponlist[1]+".");
        }
    }
    //ฟังก์ชันนี้จะรับinputเป็นตัวละครที่สร้างขึ้นมา ใช้ในการแสดงข้อมูลสถานะของตัวละคร เช่น ชื่อ, เพศ, ระดับ, พลังโจมตี, ความป้องกัน, สุขภาพ, และอื่นๆ
    static void showStatGM(RPGcharacter character) {
        System.out.println("Name: " + character.name);
        System.out.println("Gender: " + character.gender);
        System.out.println("Level: " + character.level);
        System.out.println("Attack: " + character.attack);
        System.out.println("Defense: " + character.defense);
        System.out.println("Health: " + character.health);
        System.out.println("Mana: " + character.mana);
        System.out.println("Movement Speed: " + character.movement_speed);
        System.out.println("Weapon: " + character.weapon);
        System.out.println("Sword Level: " + character.levelsword);
        System.out.println("Shield Level: " + character.levelshield);
        System.out.println("Value of Weapon: " + character.valueweapon);
        System.out.println("Sword Attack: " + character.swordATK);
        System.out.println("Shield Defense: " + character.shieldDEF);
        System.out.println("Sword Speed: " + character.swordSPD);
        System.out.println("Shield Speed: " + character.shieldSPD);
    }
    // ฟังก์ชันนี้จะรับinputเป็นตัวละครที่สร้างขึ้นมา เป็นstatic function ใช้ในการแสดงข้อมูลสถานะของตัวละครสำหรับGM โดยรวมถึงข้อมูลเพิ่มเติมเกี่ยวกับ "sword" และ "shield"

}
