package org.example;

import java.awt.*;

public class MouseCoordinateReceived implements EventReceived {


    @Override
    public void apply(String event, Robot robot) {
        String[] coordinates = event.split(";");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        robot.mouseMove(x, y);
    }
}
