enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private int level;

    DangerLevel(int danger) {
        this.level = danger;
    }

    int getLevel() {
        return level;
    }
}