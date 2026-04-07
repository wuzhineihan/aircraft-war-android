package edu.hitsz.aircraftwar.game.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractProp;
import edu.hitsz.aircraftwar.game.model.PropBlood;
import edu.hitsz.aircraftwar.game.model.PropBomb;
import edu.hitsz.aircraftwar.game.model.PropBullet;
import edu.hitsz.aircraftwar.game.model.PropBulletPlus;

public final class PropFactory {

    private PropFactory() {
    }

    public static AbstractProp createRandomProp(
            float locationX,
            float locationY,
            float speedY,
            GameConfig config,
            Random random) {
        double value = random.nextDouble();
        float propSpeedY = Math.max(speedY, config.getPropSpeedY());
        if (value < 0.3) {
            return new PropBlood(locationX, locationY, 0f, propSpeedY, config.getPropWidth(), config.getPropHeight());
        }
        if (value < 0.6) {
            return new PropBomb(locationX, locationY, 0f, propSpeedY, config.getPropWidth(), config.getPropHeight());
        }
        if (value < 0.9) {
            return new PropBullet(locationX, locationY, 0f, propSpeedY, config.getPropWidth(), config.getPropHeight());
        }
        return new PropBulletPlus(
                locationX,
                locationY,
                0f,
                propSpeedY,
                config.getPropWidth(),
                config.getPropHeight());
    }

    public static List<AbstractProp> createRandomProps(
            float locationX,
            float locationY,
            float speedY,
            int count,
            GameConfig config,
            Random random) {
        List<AbstractProp> props = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float offsetX = (i * 2 - count + 1) * config.getPropWidth() * 0.35f;
            props.add(createRandomProp(locationX + offsetX, locationY, speedY, config, random));
        }
        return props;
    }
}
