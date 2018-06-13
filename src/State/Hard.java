/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author User
 */
public class Hard implements DifficultyState {

    @Override
    public int getNoOfBars() {
        return 4;
    }

    @Override
    public int getGameSpeed() {
        return 3;
    }

    @Override
    public int getNumberOfColors() {
        return 5;
    }
    
}
