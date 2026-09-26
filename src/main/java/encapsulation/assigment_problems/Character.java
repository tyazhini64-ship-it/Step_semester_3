public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.currentHealth -= amount;
            if (this.currentHealth < 0) {
                this.currentHealth = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.currentHealth += amount;
            if (this.currentHealth > this.maxHealth) {
                this.currentHealth = this.maxHealth;
            }
        }
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
}