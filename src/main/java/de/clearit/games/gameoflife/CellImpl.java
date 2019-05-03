package de.clearit.games.gameoflife;

public class CellImpl implements Cell {

    boolean alive = false;
    boolean oracle;

    CellImpl(boolean alive) {
        this.alive = alive;
    }
    CellImpl() {

    }

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
