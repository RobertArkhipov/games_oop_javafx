package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

/**
 * Test.
 */
public class LogicTest {

    /**
     * Тест - метод проверяет метод move (проверяющий, что на пути фигуры, которую мы двигаем,
     * нет других фигур и конечная ячейка, куда мы хотим прийти этой фигурой, тоже свободна.)
     */
    @Test
    public void whenAllCellsAreFree() {
        Logic logic = new Logic();
        BishopBlack bishopBlackFirst = new BishopBlack(D4);
        BishopBlack bishopBlackSecond = new BishopBlack(F6);
        logic.add(bishopBlackFirst);
        logic.add(bishopBlackSecond);
        assertThat(logic.move(D4,E5), is(true));
    }

    /**
     * Тест - метод проверяет метод move.
     * При этом на пути фигуры, которую мы двигаем, нет других фигур, но конечная ячейка - занята.
     */
    @Test
    public void whenDestCellIsBusy() {
        Logic logic = new Logic();
        BishopBlack bishopBlackFirst = new BishopBlack(D4);
        BishopBlack bishopBlackSecond = new BishopBlack(F6);
        logic.add(bishopBlackFirst);
        logic.add(bishopBlackSecond);
        assertThat(logic.move(D4,F6), is(false));
    }

    /**
     * Тест - метод проверяет метод move.
     * При этом на пути фигуры, которую мы двигаем, есть другие фигуры, но конечная ячейка - свободна.
     */
    @Test
    public void whenBusyCellsAreOnTheWay() {
        Logic logic = new Logic();
        BishopBlack bishopBlackFirst = new BishopBlack(D4);
        BishopBlack bishopBlackSecond = new BishopBlack(E5);
        logic.add(bishopBlackFirst);
        logic.add(bishopBlackSecond);
        assertThat(logic.move(D4,F6), is(false));
    }
}
