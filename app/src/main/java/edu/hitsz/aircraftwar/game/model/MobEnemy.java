package edu.hitsz.aircraftwar.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;

public class MobEnemy extends AbstractAircraft {

    public MobEnemy(float locationX, float locationY, float speedX, float speedY, int hp, int width, int height) {
        super(locationX, locationY, speedX, speedY, hp, width, height, SpriteType.MOB_ENEMY);
    }

    @Override
    public void forward(GameConfig config) {
        super.forward(config);
        if (locationY >= config.getScreenHeight() + height) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot(GameConfig config) {
        return new ArrayList<>();
    }

    @Override
    public List<AbstractProp> dropProps(GameConfig config, Random random) {
        return new ArrayList<>();
    }

    @Override
    public int getScoreValue(GameConfig config) {
        return config.getBaseEnemyScore();
    }
}
