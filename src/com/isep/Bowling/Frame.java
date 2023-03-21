package com.isep.Bowling;

public class Frame {
    private int firstThrow;
    private int secondThrow;
    private int thirdThrow;
    private int score;
    private int bonus;
    private boolean isStrike;
    private boolean isSpare;

    public Frame() {
        this.firstThrow = Utils.EMPTY;
        this.secondThrow = Utils.EMPTY;
        this.thirdThrow = Utils.EMPTY;
        this.score = 0;
        this.bonus = 0;
        this.isStrike = false;
        this.isSpare = false;
    }

    public void setFirstThrow(int firstThrow) {
        this.firstThrow = firstThrow;
    }

    public int getFirstThrow() {
        return firstThrow;
    }

    public void setSecondThrow(int secondThrow) {
        this.secondThrow = secondThrow;
    }

    public int getSecondThrow() {
        return secondThrow;
    }

    public void setThirdThrow(int thirdThrow) {
        this.thirdThrow = thirdThrow;
    }

    public int getThirdThrow() {
        return thirdThrow;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setIsStrike(boolean isStrike) {
        this.isStrike = isStrike;
    }

    public void setIsSpare(boolean isSpare) {
        this.isSpare = isSpare;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }
}
