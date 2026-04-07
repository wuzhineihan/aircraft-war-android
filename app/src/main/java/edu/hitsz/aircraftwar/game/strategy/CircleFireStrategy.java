package edu.hitsz.aircraftwar.game.strategy;

import java.util.ArrayList;
import java.util.List;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.BaseBullet;
import edu.hitsz.aircraftwar.game.model.HeroBullet;

public class CircleFireStrategy implements ShootStrategy {

    private static final int BULLET_COUNT = 12;

    @Override
    public List<BaseBullet> shoot(float locationX, float locationY, int power, int shootNum, GameConfig config) {
        List<BaseBullet> bullets = new ArrayList<>();
        float speed = config.getCircleBulletSpeed();
        float radius = config.getHeroWidth() * 0.7f;
        for (int i = 0; i < BULLET_COUNT; i++) {
            double angle = 2.0 * Math.PI * i / BULLET_COUNT;
            float speedX = (float) Math.cos(angle) * speed;
            float speedY = (float) Math.sin(angle) * speed;
            float spawnX = locationX + (float) Math.cos(angle) * radius;
            float spawnY = locationY + (float) Math.sin(angle) * radius;
            bullets.add(new HeroBullet(
                    spawnX,
                    spawnY,
                    speedX,
                    speedY,
                    power,
                    config.getHeroBulletWidth(),
                    config.getHeroBulletHeight()));
        }
        return bullets;
    }
}
