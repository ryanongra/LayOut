package com.example.orbital_layoutfrontend;

public class Game {
    private final int catches;
    private final int failedCatches;
    private final int totalPasses;
    private final int successfulPasses;
    private final int totalCuts;
    private final int successfulCuts;
    private final String score;

    public Game(int catches, int failedCatches, int totalPasses, int successfulPasses,
                int totalCuts, int successfulCuts, String score) {
        this.catches = catches;
        this.failedCatches = failedCatches;
        this.totalPasses = totalPasses;
        this.successfulPasses = successfulPasses;
        this.totalCuts = totalCuts;
        this.successfulCuts = successfulCuts;
        this.score = score;
    }

    public int getCatches() {
        return catches;
    }

    public int getFailedCatches() {
        return failedCatches;
    }

    public int getTotalPasses() {
        return totalPasses;
    }

    public int getSuccessfulPasses() {
        return successfulPasses;
    }

    public int getTotalCuts() {
        return totalCuts;
    }

    public int getSuccessfulCuts() {
        return successfulCuts;
    }

    public String getScore() {
        return score;
    }
}
