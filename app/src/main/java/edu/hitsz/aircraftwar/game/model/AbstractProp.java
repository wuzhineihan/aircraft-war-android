package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.GameEngine;
import edu.hitsz.aircraftwar.game.SpriteType;

public abstract class AbstractProp extends AbstractFlyingObject {

    protected AbstractProp(
            float locationX,
            float locationY,
            float speedX,
            float speedY,
            int width,
            int height,
            SpriteType spriteType) {
        super(locationX, locationY, speedX, speedY, width, height, spriteType);
    }

    @Override
    public void forward(GameConfig config) {
        super.forward(config);
        if (locationY >= config.getScreenHeight() + height) {
            vanish();
        }
    }

    public abstract void apply(GameEngine engine);
}
