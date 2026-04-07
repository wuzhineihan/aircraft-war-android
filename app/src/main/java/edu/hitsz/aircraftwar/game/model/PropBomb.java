package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameEngine;
import edu.hitsz.aircraftwar.game.SpriteType;

public class PropBomb extends AbstractProp {

    public PropBomb(float locationX, float locationY, float speedX, float speedY, int width, int height) {
        super(locationX, locationY, speedX, speedY, width, height, SpriteType.PROP_BOMB);
    }

    @Override
    public void apply(GameEngine engine) {
        engine.triggerBomb();
    }
}
