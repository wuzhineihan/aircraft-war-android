package edu.hitsz.aircraftwar.game.strategy;

import java.util.List;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.BaseBullet;

public class ShootStrategyContext {

    private ShootStrategy shootStrategy;

    public ShootStrategyContext(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    public void setShootStrategy(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    public List<BaseBullet> execute(float locationX, float locationY, int power, int shootNum, GameConfig config) {
        return shootStrategy.shoot(locationX, locationY, power, shootNum, config);
    }
}
