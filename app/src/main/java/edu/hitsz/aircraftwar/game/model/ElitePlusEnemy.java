package edu.hitsz.aircraftwar.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;
import edu.hitsz.aircraftwar.game.factory.PropFactory;

public class ElitePlusEnemy extends AbstractAircraft {

    private static final int POWER = 30;

    public ElitePlusEnemy(float locationX, float locationY, float speedX, float speedY, int hp, int width, int height) {
        super(locationX, locationY, speedX, speedY, hp, width, height, SpriteType.ELITE_PLUS_ENEMY);
    }

    @Override
    public void forward(GameConfig config) {
        super.forward(config);
        if (locationY >= config.getScreenHeight() + height) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot(GameConfig config) {
        List<BaseBullet> bullets = new ArrayList<>();
        for (int direction = -1; direction <= 1; direction++) {
            bullets.add(new EnemyBullet(
                    locationX,
                    locationY + height * 0.5f,
                    direction * config.getScatterBulletSpeedX(),
                    config.getEnemyBulletSpeedY(),
                    POWER,
                    config.getEnemyBulletWidth(),
                    config.getEnemyBulletHeight()));
        }
        return bullets;
    }

    @Override
    public List<AbstractProp> dropProps(GameConfig config, Random random) {
        List<AbstractProp> props = new ArrayList<>();
        AbstractProp prop = PropFactory.createRandomProp(locationX, locationY, speedY, config, random);
        if (prop != null) {
            props.add(prop);
        }
        return props;
    }

    @Override
    public int getScoreValue(GameConfig config) {
        return config.getBaseEnemyScore();
    }
}
