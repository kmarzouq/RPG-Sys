public class Warrior{
private String name;
private int level;
private int maxHealth;
private int health;
private int attack;
private int defense;
private int magicAttack;
private int magicDefense;
private int agility;
private int wisdom;
private int exp;

    public Warrior(String n){
        name = n;
        level=1;
        maxHealth = 20;
        health=maxHealth;
        attack = 10;
        defense = 8;
        magicAttack = 0;
        magicDefense = 4;
        agility = 7;
        wisdom = 2;
    }
    
    public Warrior(String n, int lev){
        name = n;
        level = lev;
        maxHealth = 20*lev;
        health=maxHealth;
        attack = 10*lev;
        defense = 8*lev;
        magicAttack = 0*lev;
        magicDefense = 4*lev;
        agility = 7*lev;
        wisdom = 2*lev;
        exp=0;
    }
    public void levelUp(){
        level++;
        maxHealth+=20;
        health+=20;
        attack+=10;
        defense += 8;
        magicDefense += 4;
        agility +=7;
        wisdom +=2;
        exp=0;
    }
    
    public void gainExp (int expGain) {
		if(expGain > 1000)
			expGain = 1000;
		exp += expGain;
		if(exp >= 1000) {
			exp -= 1000;
			levelUp();
		}
	}
	
	public int attack(int targetDef, int targetAgi){
	    boolean hit = hitCheck(targetAgi);
	    if(hit){
	        return calcDamage(targetDef);}
	    else 
	        return 0;
	}
	
	private boolean hitCheck(int targetAgi){
	    double probability = (double)agility/targetAgi;
	    if(Math.random()<probability){
	        System.out.println("Hit!");
	        return true;}
	    else{
	        System.out.println("Miss!");
	        return false;}
	}
	
	private int calcDamage(int targetDef){
	    int damage = (int)(1.36*attack*Math.pow(2.72, -(double)targetDef/attack) + 0.5);
	    System.out.println(damage + " damage");
	    return damage;
	}
    
    public String toString(){
        String str = "";
        str += "Name: " + name + "\n";
        str += "Level " + level + " Warrior\n";
        str += "Current EXP: " + exp + "\n";
        str += health + "/" + " Health\n";
        str += "Attack: " + attack + "  Defense: " + defense + "\n";
        str += "Magic Attack: " + magicAttack + "  Magic Defense: " + magicDefense + "\n";
        str += "Agility: " + agility + "  Wisdom: " + wisdom + "\n\n";
        return str;
    }
}