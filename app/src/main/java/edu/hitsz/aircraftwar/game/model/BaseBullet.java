package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;

public abstract class BaseBullet extends AbstractFlyingObject {

    private final int power;

    protected BaseBullet(
            float locationX,
            float locationY,
            float speedX,
            float speedY,
            int power,
            int width,
            int height,
            SpriteType spriteType) {
        super(locationX, locationY, speedX, speedY, width, height, spriteType);
        this.power = power;
    }

    @Override
    public void forward(GameConfig config) {
        locationX += speedX;
        locationY += speedY;
        if (locationX <= 0
                || locationX >= config.getScreenWidth()
                || locationY <= 0
                || locationY >= config.getScreenHeight()) {
            vanish();
        }
    }

    public int getPower() {
        return power;
    }
}
