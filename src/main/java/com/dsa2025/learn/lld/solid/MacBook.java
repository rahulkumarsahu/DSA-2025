package com.dsa2025.learn.lld.solid;

// class should depend on interface rather than concrete class -> Dependency Inversion
public class MacBook {
    private final WiredKeyBoard wiredKeyBoard;
    private final WiredMouse wiredMouse;

    public MacBook(WiredKeyBoard wiredKeyBoard, WiredMouse wiredMouse) {
        this.wiredKeyBoard = wiredKeyBoard;
        this.wiredMouse = wiredMouse;
    }
}

class WiredKeyBoard implements Keyboard {
    // do something
}

class WiredMouse implements Mouse {
    // do something
}

class BluetoothKeyBoard implements Keyboard {

}

class BluetoothMouse implements Mouse {

}

// so here what we are doing is giving concrete class to the Macbook,
// but suppose I want to enhance the functionality to Bluetooth
// how can I do that by giving the keyboard or Mouse interface in macbook class
// which is implemented by wired and bluetooth mouse and keyboard.

class MacbookPC {
    private final Keyboard keyboard;
    private final Mouse mouse;

    public MacbookPC(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

interface Keyboard {

}
interface Mouse {

}



