package ru.sberbank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TesterServiceTest {

    TesterService underTest;

    @BeforeEach
    void setUp() {
        underTest = new TesterService();
        underTest.create(1, "Joe", "Doe");
        underTest.create(2, "Maria", "Smith");


    }

    @Test
    void itShouldCreateTest_Fail() {
        //given
        IllegalStateException eFistName = assertThrows(
                IllegalStateException.class,
                () -> underTest.create(1, null,""));

        IllegalStateException eSecName = assertThrows(
                IllegalStateException.class,
                () -> underTest.create(1, "Joe",null));


        //when
        //then
        assertEquals(eFistName.getMessage(), "Входные данные не валидны");
        assertEquals(eSecName.getMessage(), "Входные данные не валидны");

    }

    @Test
    void itShouldCreateTest_Success() {
        Tester expTester = new Tester(1, "Joe", "Doer");

        Tester actTester = underTest.create(1, "Joe", "Doer");

        assertEquals(expTester, actTester);



    }


    @Test
    void itShouldGetTest_Fail() {
        //given
        //when
        IllegalStateException e = assertThrows(
                IllegalStateException.class,
                () -> underTest.get("Bill","Jeans"));

        //then
        assertEquals(e.getMessage(), "Тестировщики не найдены");


    }

    @Test
    void itShouldGetTest_Success() {
        //given
        Tester expTester = new Tester(1, "Joe", "Doe");
        //when
        Tester actualTester = underTest.get("Joe", "Doe");
        //then

        assertEquals(expTester, actualTester);

    }

    @Test
    void itShouldGetListOfFree() {
        //given
        //when
        //then

    }
}