package edu.hitsz.aircraftwar.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;
import edu.hitsz.aircraftwar.game.strategy.DirectFireStrategy;
import edu.hitsz.aircraftwar.game.strategy.ShootStrategy;
import edu.hitsz.aircraftwar.game.strategy.ShootStrategyContext;

public class HeroAircraft extends AbstractAircraft {

    private final DirectFireStrategy defaultStrategy = new DirectFireStrategy();
    private final ShootStrategyContext shootStrategyContext = new ShootStrategyContext(defaultStrategy);
    private int shootNum = 1;
    private int power = 30;

    public HeroAircraft(float locationX, float locationY, int hp, int width, int height) {
        super(locationX, locationY, 0f, 0f, hp, width, height, SpriteType.HERO);
    }

    @Override
    public void forward(GameConfig config) {
        // Hero movement is fully controlled by touch input.
    }

    public void moveTo(float locationX, float locationY, GameConfig config) {
        float clampedX = clamp(locationX, width * 0.5f, config.getScreenWidth() - width * 0.5f);
        float clampedY = clamp(locationY, height * 0.5f, config.getScreenHeight() - height * 0.5f);
        setLocation(clampedX, clampedY);
    }

    public void setShootStrategy(ShootStrategy shootStrategy) {
        shootStrategyContext.setShootStrategy(shootStrategy);
    }

    public void resetShootStrategy() {
        shootStrategyContext.setShootStrategy(defaultStrategy);
    }

    @Override
    public List<BaseBullet> shoot(GameConfig config) {
        return shootStrategyContext.execute(locationX, locationY, power, shootNum, config);
    }

    @Override
    public List<AbstractProp> dropProps(GameConfig config, Random random) {
        return new ArrayList<>();
    }

    @Override
    public int getScoreValue(GameConfig config) {
        return 0;
    }

    private float clamp(float value, float minValue, float maxValue) {
        if (value < minValue) {
            return minValue;
        }
        return Math.min(value, maxValue);
    }
}
