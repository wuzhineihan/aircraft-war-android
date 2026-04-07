package edu.hitsz.aircraftwar.game.factory;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractAircraft;
import edu.hitsz.aircraftwar.game.model.MobEnemy;

public class MobEnemyFactory implements EnemyFactory {

    @Override
    public AbstractAircraft create(float locationX, float locationY, GameConfig config) {
        return new MobEnemy(
                locationX,
                locationY,
                0f,
                config.getMobEnemySpeedY(),
                config.getMobEnemyHp(),
                config.getMobEnemyWidth(),
                config.getMobEnemyHeight());
    }
}
