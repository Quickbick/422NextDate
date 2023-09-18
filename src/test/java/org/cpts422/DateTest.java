package org.cpts422;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    private static class DateTestCase {
        Date input;
        Date expectedDate;

        public DateTestCase(Date input, Date expectedDate) {
            this.input = input;
            this.expectedDate = expectedDate;
        }

        public DateTestCase(Date input) {
            this.input = input;
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Simple_Date_Tests{
        static List<DateTestCase> simpleDateTestCaseList = new ArrayList<>();

        @BeforeAll
        static void beforeAll() {
            // I'll read CSVs and populate the list
            Date input = new Date(1,1,2023);
            Date expectedOutput = new Date(2,1,2023);
            DateTestCase dateTestCase = new DateTestCase(input, expectedOutput);
            simpleDateTestCaseList.add(dateTestCase);
        }

        @Test
        void simple_date_tests() {
            for (DateTestCase testCase: simpleDateTestCaseList) {
                assertEquals(testCase.input.nextDate(),testCase.expectedDate);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Test_For_Illegal_Input{
        static List<DateTestCase> failDateTestCaseList = new ArrayList<>();

        @BeforeAll
        static void beforeAll() {
            // I'll read CSVs and populate the list
            Date input = new Date(29,2,2023);
            DateTestCase dateTestCase = new DateTestCase(input);
            failDateTestCaseList.add(dateTestCase);
        }

        @Test
        void testForIllegalValues() {
            for (DateTestCase testCase: failDateTestCaseList) {
                Exception exception = assertThrows(RuntimeException.class, () ->
                        testCase.input.nextDate());
                assertEquals(" Wrong input, this year does not have Feb 29th", exception.getMessage());

            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Test_Leap_Year_Class{

        @ParameterizedTest
        @ValueSource(ints = {2020, 2024, 2001})
        void testLeapYear(int year) {
            Date date = new Date(1,1,year);
            assertTrue(Date.isLeapYear(date), "for year: "+year);
        }
    }

}