package com.appsparaguay.testlistcontrol.event;

/**
 * Created by Administrador on 9/7/2015.
 */
public class ItemClickEvent {
    private int position;

    public ItemClickEvent(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
