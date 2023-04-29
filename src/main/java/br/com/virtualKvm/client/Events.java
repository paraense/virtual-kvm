package br.com.virtualKvm.client;


import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public enum Events {

    MOUSE_MOVE("MOUSE_MOVE") {
        @Override
        public void apply(String message, Robot robot) {
            String command = Events.getCommand(message);

            String[] coordinates = command.split(";");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            robot.mouseMove(x, y);
        }
    },
    MOUSE_CLICK("MOUSE_CLICK") {
        @Override
        public void apply(String message, Robot robot) {
            String command = Events.getCommand(message);
            System.out.println("MOUSE CLICK: "+ command);
            robot.mouseRelease(buttonValues.get(command));
        }
    },
    KEY_PRESS("KEY_PRESS") {
        @Override
        public void apply(String message, Robot robot) {
            robot.keyPress(Integer.parseInt(message));
        }
    },
    UNKNOWN("UNKNOWN") {
        @Override
        public void apply(String message, Robot robot) {
            System.out.println("UNKNOWN");
        }
    };

    private final String name;
    private static final Map<String, Integer> buttonValues = new HashMap()
    {{
      put("1", InputEvent.BUTTON1_MASK);
      put("2", InputEvent.BUTTON2_MASK);
      put("3", InputEvent.BUTTON3_MASK);
    }};

    Events(String name){
        this.name = name;
    }


    public static synchronized Events findByStringMessage(String message) {
        if (message == null || message.isEmpty()) {
            return UNKNOWN;
        }
        return valueOf(getEventNameByMessage(message));
    }

    private static synchronized String getEventNameByMessage(String message) {
        return message.substring(0, message.indexOf(":")).trim();
    }

    private static synchronized String getCommand(String message) {
        return message.substring(message.indexOf(":") + 1).trim();
    }

    public abstract void apply(String message, Robot robot);

}
