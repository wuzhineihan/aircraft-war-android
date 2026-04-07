package edu.hitsz.aircraftwar.game.strategy;

import java.util.List;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.BaseBullet;

public interface ShootStrategy {
    List<BaseBullet> shoot(float locationX, float locationY, int power, int shootNum, GameConfig config);
}
