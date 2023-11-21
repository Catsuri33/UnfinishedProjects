package fr.catsuri33.insifactions.core;

public class Mines {

    private String name;
    private int timer;
    private final int x1;
    private final int y1;
    private final int z1;
    private final int x2;
    private final int y2;
    private final int z2;
    private final int coalAmount;
    private final int ironAmount;
    private final int goldAmount;
    private final int redstoneAmount;
    private final int lapizAmount;
    private final int emeraldAmount;
    private final int diamondAmount;

    public Mines(String name, int timer, int x1, int y1, int z1, int x2, int y2, int z2, int coalAmount, int ironAmount, int goldAmount, int redstoneAmount, int lapizAmount, int emeraldAmount, int diamondAmount){

        this.timer = timer;
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.coalAmount = coalAmount;
        this.ironAmount = ironAmount;
        this.goldAmount = goldAmount;
        this.redstoneAmount = redstoneAmount;
        this.lapizAmount = lapizAmount;
        this.emeraldAmount = emeraldAmount;
        this.diamondAmount = diamondAmount;

    }

    public String getName() {

        return name;

    }

    public int getTimer() {

        return timer;

    }

    public int getX1() {

        return x1;

    }

    public int getY1() {

        return y1;

    }

    public int getZ1() {

        return z1;

    }

    public int getX2() {

        return x2;

    }

    public int getY2() {

        return y2;

    }

    public int getZ2() {

        return z2;

    }

    public int removeOneSecondTimer(){

        return timer--;

    }

    public void setTimer(int timer) {

        this.timer = timer;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getCoalAmount() {

        return coalAmount;

    }

    public int getIronAmount() {

        return ironAmount;

    }

    public int getGoldAmount() {

        return goldAmount;

    }

    public int getRedstoneAmount() {

        return redstoneAmount;

    }

    public int getLapizAmount() {

        return lapizAmount;

    }

    public int getEmeraldAmount() {

        return emeraldAmount;

    }

    public int getDiamondAmount() {

        return diamondAmount;

    }

}
