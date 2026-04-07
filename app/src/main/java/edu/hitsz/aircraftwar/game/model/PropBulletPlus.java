package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameEngine;
import edu.hitsz.aircraftwar.game.SpriteType;
import edu.hitsz.aircraftwar.game.strategy.CircleFireStrategy;

public class PropBulletPlus extends AbstractProp {

    public PropBulletPlus(float locationX, float locationY, float speedX, float speedY, int width, int height) {
        super(locationX, locationY, speedX, speedY, width, height, SpriteType.PROP_BULLET_PLUS);
    }

    @Override
    public void apply(GameEngine engine) {
        engine.applyHeroStrategy(new CircleFireStrategy(), engine.getConfig().getPropEffectDurationMs());
    }
}
