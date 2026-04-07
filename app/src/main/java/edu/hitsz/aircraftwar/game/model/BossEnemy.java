package edu.hitsz.aircraftwar.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;
import edu.hitsz.aircraftwar.game.factory.PropFactory;

public class BossEnemy extends AbstractAircraft {

    private static final int POWER = 30;
    private static final int BULLET_COUNT = 14;
    private static final int PROP_COUNT = 3;

    public BossEnemy(float locationX, float locationY, float speedX, float speedY, int hp, int width, int height) {
        super(locationX, locationY, speedX, speedY, hp, width, height, SpriteType.BOSS_ENEMY);
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
        float speed = config.getEnemyBulletSpeedY();
        float radius = width * 0.48f;
        for (int i = 0; i < BULLET_COUNT; i++) {
            double angle = 2.0 * Math.PI * i / BULLET_COUNT;
            float speedX = (float) Math.cos(angle) * speed;
            float speedY = (float) Math.sin(angle) * speed;
            bullets.add(new EnemyBullet(
                    locationX + (float) Math.cos(angle) * radius,
                    locationY + (float) Math.sin(angle) * radius,
                    speedX,
                    speedY,
                    POWER,
                    config.getEnemyBulletWidth(),
                    config.getEnemyBulletHeight()));
        }
        return bullets;
    }

    @Override
    public List<AbstractProp> dropProps(GameConfig config, Random random) {
        return PropFactory.createRandomProps(locationX, locationY, speedY, PROP_COUNT, config, random);
    }

    @Override
    public int getScoreValue(GameConfig config) {
        return config.getBossScore();
    }
}
