package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) < 0 ? -1 : 1;
        int deltaY = (dest.y - source.y) < 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[source.ordinal() + (deltaX * ((index + 1) * 8) + deltaY * (index + 1))];
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int a = Math.abs(source.x - dest.x);
        int b = Math.abs(source.y - dest.y);
        int c = source.x + source.y;
        int d = dest.x + dest.y;
        return a == b || c == d;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
