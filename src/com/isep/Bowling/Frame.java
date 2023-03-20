package com.isep.Bowling;

public class Frame {
    private int firstThrow;
    private int secondThrow;
    private int score;
    private boolean isStrike;
    private boolean isSpare;

    public Frame() {
        this.firstThrow = Utils.EMPTY;
        this.secondThrow = Utils.EMPTY;
        this.score = 0;
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

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
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