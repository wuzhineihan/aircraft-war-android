package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.SpriteType;

public class EnemyBullet extends BaseBullet {

    public EnemyBullet(float locationX, float locationY, float speedX, float speedY, int power, int width, int height) {
        super(locationX, locationY, speedX, speedY, power, width, height, SpriteType.ENEMY_BULLET);
    }
}
