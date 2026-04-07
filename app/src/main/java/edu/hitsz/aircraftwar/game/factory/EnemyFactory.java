package edu.hitsz.aircraftwar.game.factory;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.model.AbstractAircraft;

public interface EnemyFactory {
    AbstractAircraft create(float locationX, float locationY, GameConfig config);
}
