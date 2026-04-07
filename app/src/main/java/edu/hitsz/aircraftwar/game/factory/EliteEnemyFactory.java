package edu.hitsz.aircraftwar.game.factory;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractAircraft;
import edu.hitsz.aircraftwar.game.model.EliteEnemy;

public class EliteEnemyFactory implements EnemyFactory {

    @Override
    public AbstractAircraft create(float locationX, float locationY, GameConfig config) {
        return new EliteEnemy(
                locationX,
                locationY,
                0f,
                config.getEliteEnemySpeedY(),
                config.getEliteEnemyHp(),
                config.getEliteEnemyWidth(),
                config.getEliteEnemyHeight());
    }
}
