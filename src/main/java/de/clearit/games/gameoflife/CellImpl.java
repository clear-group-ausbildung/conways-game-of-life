package de.clearit.games.gameoflife;

public class CellImpl implements Cell {

    boolean alive = true;
    boolean oracle;

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setOracle(boolean oracle) {
        this.oracle = oracle;
    }

    public boolean getOracle() {
        return oracle;
    }
}
