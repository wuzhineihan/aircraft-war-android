package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameEngine;
import edu.hitsz.aircraftwar.game.SpriteType;
import edu.hitsz.aircraftwar.game.strategy.ScatterFireStrategy;

public class PropBullet extends AbstractProp {

    public PropBullet(float locationX, float locationY, float speedX, float speedY, int width, int height) {
        super(locationX, locationY, speedX, speedY, width, height, SpriteType.PROP_BULLET);
    }

    @Override
    public void apply(GameEngine engine) {
        engine.applyHeroStrategy(new ScatterFireStrategy(), engine.getConfig().getPropEffectDurationMs());
    }
}
