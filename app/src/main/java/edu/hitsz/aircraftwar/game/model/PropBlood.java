package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameEngine;
import edu.hitsz.aircraftwar.game.SpriteType;

public class PropBlood extends AbstractProp {

    private static final int HEAL_AMOUNT = 120;

    public PropBlood(float locationX, float locationY, float speedX, float speedY, int width, int height) {
        super(locationX, locationY, speedX, speedY, width, height, SpriteType.PROP_BLOOD);
    }

    @Override
    public void apply(GameEngine engine) {
        engine.healHero(HEAL_AMOUNT);
    }
}
