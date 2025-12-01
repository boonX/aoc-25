package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day01Test {

  @Test
  void testPart1Example() throws Exception {
    String input = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
        """;

    Day01 day = new Day01(input);
    assertEquals("3", day.part1());
  }

  @Test
  void testPart2Example() throws Exception {
    String input = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
                """;

    Day01 day = new Day01(input);
    assertEquals("6", day.part2());
  }

  @Test
  void testPart2Example2() throws Exception {
    String input = """
        L68
        L30
        R448
        L1000
        L5
        R60
        L555
        L1
        L99
        R100
        R14
        L82
        """;

    Day01 day = new Day01(input);
    assertEquals("26", day.part2());
  }

  @Test
  void testWithRealInput() throws Exception {
    String realInput = new String(
        Day01Test.class.getClassLoader()
            .getResourceAsStream("day01.txt")
            .readAllBytes()
    );

    Day01 day = new Day01(realInput);

    assertEquals("1123", day.part1());
    assertEquals("6695", day.part2());
  }
}
