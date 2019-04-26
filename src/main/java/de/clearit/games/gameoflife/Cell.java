package de.clearit.games.gameoflife;

import java.util.List;

public interface Cell {
    public boolean isAlive();
    public void setAlive(boolean alive);
    public void setOracle(boolean oracle);
    public boolean getOracle();
}
