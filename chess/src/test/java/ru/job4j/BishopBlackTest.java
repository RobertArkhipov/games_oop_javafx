package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;


/**
 * Test.
 */
public class BishopBlackTest {

    /**
     * Тест-метод проверяет метод position. Создаём объект и вызываем у него метод position.
     * Проверяем, что он занимает ту же ячейку, что и при создании объекта.
     */
    @Test
    public void checkingThePositionMethod() {
        BishopBlack bishopBlack = new BishopBlack(D2);
        assertThat(bishopBlack.position(), is(D2));
    }

    /**
     * Тест-метод проверяет метод copy. Создаём объект и вызываем у него метод copy.
     * Убеждаемся, что возвращаемый объект имеет правильную позицию.
     */
    @Test
    public void checkingTheCopyMethod() {
        BishopBlack bishopBlack = new BishopBlack(D2);
        assertThat(bishopBlack.copy(D2).position(), is(D2));
    }

    /**
     * Тест-метод сравнивает ответ метода way и ожидаемый результат.
     */
    @Test
    public void checkingTheWayMethod() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(bishopBlack.way(C1,G5), is(new Cell []{D2, E3, F4, G5}));
    }

    /**
     * Тест-метод проверяет ответ метода isDiagonal о том,
     * можно ли построить диагональ через начальную и конечную ячейки.
     */
    @Test
    public void whenThereIsNoDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        assertThat(bishopBlack.isDiagonal(C1,A2), is(false));
    }
}
