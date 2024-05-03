import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class SimpleLinkedListTest {

    @Test
    public void aNewListIsEmpty() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int expected = 0;

        int actual = list.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canCreateFromArray() {
        Character[] values = new Character[]{'1', '2', '3'};
        SimpleLinkedList<Character> list = new SimpleLinkedList<>(values);
        int expected = 3;

        int actual = list.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void popOnEmptyListWillThrow() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        Class<NoSuchElementException> expectedExceptionType = NoSuchElementException.class;

        ThrowableAssert.ThrowingCallable actualPopException = list::pop;

        assertThatExceptionOfType(expectedExceptionType).isThrownBy(actualPopException);
    }

    @Test
    public void popReturnsLastAddedElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        int value = 9;
        list.push(value);
        value = 8;
        list.push(value);

        int expected = 2;
        int actual = list.size();
        assertThat(actual).isEqualTo(expected);

        expected = 8;
        actual = list.pop();
        assertThat(actual).isEqualTo(expected);

        expected = 9;
        actual = list.pop();
        assertThat(actual).isEqualTo(expected);

        expected = 0;
        actual = list.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void reverseReversesList() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        String[] numbers = {"9", "8", "7", "6", "5"};

        for (String number : numbers) {
            list.push(number);
        }

        list.reverse();

        String expectedNumber = "9";
        String actual = list.pop();
        assertThat(actual).isEqualTo(expectedNumber);

        expectedNumber = "8";
        actual = list.pop();
        assertThat(actual).isEqualTo(expectedNumber);

        expectedNumber = "7";
        actual = list.pop();
        assertThat(actual).isEqualTo(expectedNumber);

        expectedNumber = "6";
        actual = list.pop();
        assertThat(actual).isEqualTo(expectedNumber);

        expectedNumber = "5";
        actual = list.pop();
        assertThat(actual).isEqualTo(expectedNumber);
    }

    @Test
    public void canReturnListAsArray() {
        SimpleLinkedList<Character> list = new SimpleLinkedList<>();
        Character[] numbers = {'9', '8', '7', '6', '5'};
        for (Character number : numbers) {
            list.push(number);
        }

        Character[] expected = {'5', '6', '7', '8', '9'};

        Character[] actual = list.asArray(Character.class);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList<Object> list = new SimpleLinkedList<>();
        Object[] expected = {};

        Object[] actual = list.asArray(Object.class);

        assertThat(actual).isEqualTo(expected);
    }
}

