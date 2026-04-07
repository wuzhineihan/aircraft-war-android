package edu.hitsz.aircraftwar.game.strategy;

import java.util.ArrayList;
import java.util.List;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.BaseBullet;
import edu.hitsz.aircraftwar.game.model.HeroBullet;

public class ScatterFireStrategy implements ShootStrategy {

    @Override
    public List<BaseBullet> shoot(float locationX, float locationY, int power, int shootNum, GameConfig config) {
        List<BaseBullet> bullets = new ArrayList<>();
        float spawnY = locationY - config.getHeroHeight() * 0.45f;
        for (int direction = -1; direction <= 1; direction++) {
            float speedX = direction * config.getScatterBulletSpeedX();
            for (int i = 0; i < shootNum; i++) {
                float offsetX = (i * 2 - shootNum + 1) * config.getHeroBulletWidth() * 0.6f;
                bullets.add(new HeroBullet(
                        locationX + offsetX,
                        spawnY,
                        speedX,
                        -config.getHeroBulletSpeedY(),
                        power,
                        config.getHeroBulletWidth(),
                        config.getHeroBulletHeight()));
            }
        }
        return bullets;
    }
}
