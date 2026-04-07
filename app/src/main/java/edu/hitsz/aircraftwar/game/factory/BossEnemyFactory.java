package edu.hitsz.aircraftwar.game.factory;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractAircraft;
import edu.hitsz.aircraftwar.game.model.BossEnemy;

public class BossEnemyFactory implements EnemyFactory {

    @Override
    public AbstractAircraft create(float locationX, float locationY, GameConfig config) {
        return new BossEnemy(
                locationX,
                locationY,
                config.getBossEnemySpeedX(),
                0f,
                config.getBossEnemyHp(),
                config.getBossEnemyWidth(),
                config.getBossEnemyHeight());
    }
}
