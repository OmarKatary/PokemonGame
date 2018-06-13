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
public class Easy implements DifficultyState {

    @Override
    public int getNoOfBars() {
        return 2;
    }

    @Override
    public int getGameSpeed() {
        return 10;
    }

    @Override
    public int getNumberOfColors() {
        return 3;
    }
    
}
