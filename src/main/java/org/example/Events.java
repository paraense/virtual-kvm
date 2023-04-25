package org.example;

public enum Events {
    MOUSE_BUTTON_PRESS(new MouseKeyPressReceived()),
    MOUSE_MOVED(new MouseCoordinateReceived()),
    KEY_PRESS(new KeyBoardKeyPressReceived());

    private final EventReceived eventReceived;

    Events(EventReceived eventReceived) {
        this.eventReceived = eventReceived;
    }
}
