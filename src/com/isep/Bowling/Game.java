package com.isep.Bowling;

public class Game {
    private final Frame[] frames = new Frame[10];
    private int currentRoll = 0;

    private boolean isValidRoll(int pins, int currentRoll) {
        boolean isGoodAmountOfPins;
        boolean isGoodAmountOfRolls = currentRoll <= Utils.MAX_ROLLS;
        if (currentRoll % 2 == 0) {
            isGoodAmountOfPins = pins <= Utils.MAX_PINS;
        }
        else {
            int pinsLeft = Utils.MAX_PINS - frames[currentRoll / 2].getFirstThrow();
            System.out.println("Pins left: " + pinsLeft + "Pins: " + pins);
            isGoodAmountOfPins = pins <= pinsLeft;
        }
        System.out.println("Is good amount of pins: " + isGoodAmountOfPins);
        System.out.println("Is good amount of rolls: " + isGoodAmountOfRolls);
        return (isGoodAmountOfPins && isGoodAmountOfRolls);
    }

    private boolean isStrike(int currentRoll) {
        currentRoll = currentRoll + 1;
        return frames[currentRoll / 2].getFirstThrow() == Utils.STRIKE;
    }

    private boolean isSpare(int currentRoll) {
        return frames[currentRoll / 2].getFirstThrow() + frames[currentRoll / 2].getSecondThrow() == Utils.SPARE;
    }

    public boolean isFinished() {
        return currentRoll == Utils.MAX_ROLLS;
    }

    public void roll(int pins) {
        if (isValidRoll(pins, currentRoll)) {
            if (currentRoll % 2 == 0) {
                frames[currentRoll / 2].setFirstThrow(pins);
                frames[currentRoll / 2].setScore(pins);
                if (isStrike(currentRoll)) {
                    frames[currentRoll / 2].setIsStrike(true);
                }
            } else {
                frames[currentRoll / 2].setSecondThrow(pins);
                frames[currentRoll / 2].setScore(frames[currentRoll / 2].getScore() + pins);
                if (isSpare(currentRoll)) {
                    frames[currentRoll / 2].setIsSpare(true);
                }
            }
            System.out.println("Frame "+ (currentRoll /2+1) +": " + frames[currentRoll / 2].getFirstThrow() + " " + frames[currentRoll / 2].getSecondThrow() + " " + frames[currentRoll / 2].getScore());
            System.out.println("Current roll: " + currentRoll);
            this.currentRoll = currentRoll + 1;
        }
        else {
            System.out.println("Invalid roll");
        }
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < Utils.MAX_FRAMES; i++) {
            System.out.println(totalScore);
            Frame currentFrame = frames[i];
            totalScore += currentFrame.getScore();
            if (currentFrame.isStrike() && i < Utils.MAX_FRAMES - 1) {
                // Add the next two rolls to the current frame score
                Frame nextFrame = frames[i + 1];
                totalScore += nextFrame.getFirstThrow();
                if (nextFrame.isStrike() && i < Utils.MAX_FRAMES - 2) {
                    // If the next frame is also a strike, add the next roll to the current frame score
                    totalScore += frames[i + 2].getFirstThrow();
                } else {
                    totalScore += nextFrame.getSecondThrow();
                }
            } else if (currentFrame.isSpare() && i < Utils.MAX_FRAMES - 1) {
                // Add the next roll to the current frame score
                totalScore += frames[i + 1].getFirstThrow();
            }
        }
        return totalScore;
    }


    public Game() {
        for (int i = 0; i < 10; i++) {
            frames[i] = new Frame();
        }
    }

}
