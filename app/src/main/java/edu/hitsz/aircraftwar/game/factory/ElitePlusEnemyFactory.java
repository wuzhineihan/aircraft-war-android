package edu.hitsz.aircraftwar.game.factory;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractAircraft;
import edu.hitsz.aircraftwar.game.model.ElitePlusEnemy;

public class ElitePlusEnemyFactory implements EnemyFactory {

    @Override
    public AbstractAircraft create(float locationX, float locationY, GameConfig config) {
        return new ElitePlusEnemy(
                locationX,
                locationY,
                config.getElitePlusEnemySpeedX(),
                config.getElitePlusEnemySpeedY(),
                config.getElitePlusEnemyHp(),
                config.getElitePlusEnemyWidth(),
                config.getElitePlusEnemyHeight());
    }
}
