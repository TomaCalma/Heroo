import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element{
    public Monster(int x, int y) {
        super(x, y);
    }

    public Position move() {
        return switch (new Random().nextInt(4)) {
            case 0 -> new Position(position.getX(), position.getY() - 1);
            case 1 -> new Position(position.getX() + 1, position.getY());
            case 2 -> new Position(position.getX(), position.getY() + 1);
            case 3 -> new Position(position.getX() - 1, position.getY());
            default -> new Position(position.getX(), position.getY());
        };
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#f20f0f"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#F3F3F3"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}
