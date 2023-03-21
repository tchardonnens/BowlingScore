package com.isep.Bowling;

public class Game {
    private final Frame[] frames = new Frame[Utils.MAX_FRAMES];
    private int currentRoll = 0;

    private boolean isValidRoll(int pins, int currentRoll) {
        boolean isGoodAmountOfPins = false;
        boolean isGoodAmountOfRolls = currentRoll <= Utils.MAX_ROLLS;

        if (currentRoll % 2 == 0 || frames[9].getBonus() > 0) {
            isGoodAmountOfPins = pins <= Utils.MAX_PINS;

        }
        if (currentRoll % 2 == 1) {
            int pinsLeft = Utils.MAX_PINS - frames[currentRoll / 2].getFirstThrow();
            System.out.println("Pins left: " + pinsLeft + ", Pins: " + pins);
            isGoodAmountOfPins = pins <= pinsLeft;
        }

        System.out.println("score " + score());
        System.out.println("Is good amount of pins: " + isGoodAmountOfPins);
        System.out.println("Is good amount of rolls: " + isGoodAmountOfRolls);
        return (isGoodAmountOfPins && isGoodAmountOfRolls);
    }

    private boolean isStrike(int currentRoll) {
        boolean isStrike = frames[currentRoll / 2].getFirstThrow() == Utils.STRIKE;
        return isStrike;
    }

    private boolean isSpare(int currentRoll) {
        return frames[currentRoll / 2].getFirstThrow() + frames[currentRoll / 2].getSecondThrow() == Utils.SPARE;
    }

    public void roll(int pins) {
        if (isValidRoll(pins, currentRoll)) {
            if (currentRoll % 2 == 0) {
                frames[currentRoll / 2].setFirstThrow(pins);
                frames[currentRoll / 2].setScore(pins);
                if (isStrike(currentRoll)) {
                    frames[currentRoll / 2].setIsStrike(true);
                    if (currentRoll < Utils.MAX_ROLLS - 2) {
                        currentRoll = currentRoll + 1;
                    }
                    if (currentRoll == Utils.MAX_ROLLS - 3) {
                        frames[9].setBonus(2);
                    }
                }
            }

            if (currentRoll % 2 == 1) {
                frames[currentRoll / 2].setSecondThrow(pins);
                frames[currentRoll / 2].setScore(frames[currentRoll / 2].getScore() + pins);
                if (isSpare(currentRoll)) {
                    frames[currentRoll / 2].setIsSpare(true);
                    if (currentRoll <= Utils.MAX_ROLLS - 2) {
                        currentRoll = currentRoll + 1;
                        frames[9].setBonus(1);
                    }
                }
            }

            if (currentRoll == Utils.MAX_ROLLS - 1) {
                frames[9].setThirdThrow(pins);
                frames[9].setScore(frames[9].getScore() + pins);
            }

            System.out.println("Frame " + (currentRoll / 2 + 1) + ": " + frames[currentRoll / 2].getFirstThrow() + " " + frames[currentRoll / 2].getSecondThrow() + " " + frames[currentRoll / 2].getScore());
            System.out.println("Current roll: " + currentRoll);
            currentRoll = currentRoll + 1;
        } else {
            System.out.println("Invalid roll");
        }
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < Utils.MAX_FRAMES; i++) {
            Frame currentFrame = frames[i];
            totalScore += currentFrame.getScore();

            if (currentFrame.isStrike() && i < Utils.MAX_FRAMES - 1) {
                Frame nextFrame = frames[i + 1];
                totalScore += nextFrame.getFirstThrow();
                if (nextFrame.isStrike() && i < Utils.MAX_FRAMES - 2) {
                    totalScore += frames[i + 2].getFirstThrow();
                }

                else {
                    totalScore += nextFrame.getSecondThrow();
                }
            }

            else if (currentFrame.isSpare() && i < Utils.MAX_FRAMES - 1) {
                totalScore += frames[i + 1].getFirstThrow();
            }

            if (i == Utils.MAX_FRAMES - 1) {
                if (currentFrame.isStrike()) {
                    totalScore += currentFrame.getSecondThrow();
                    totalScore += currentFrame.getThirdThrow();
                }
                if (currentFrame.isSpare()) {
                    totalScore += currentFrame.getThirdThrow();
                }
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
