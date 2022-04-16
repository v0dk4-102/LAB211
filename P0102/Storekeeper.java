/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab211_j1_s_p0105;

/**
 *
 * @author DELL
 */
public class Storekeeper {
    private int storekeeperId;
    private String storekeeperName;

    public Storekeeper() {
    }

    public Storekeeper(int storekeeperId, String storekeeperName) {
        this.storekeeperId = storekeeperId;
        this.storekeeperName = storekeeperName;
    }

    public int getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(int storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }

    @Override
    public String toString() {
        return storekeeperName;
    }
    
}
