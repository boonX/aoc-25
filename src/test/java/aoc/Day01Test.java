package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day01Test {

  @Test
  void testPart1Example() throws Exception {
    String input = """
        1
        2
        3
        """;

    Day01 day = new Day01(input);
    assertEquals("Not implemented", day.part1());
  }

  @Test
  void testPart2Example() throws Exception {
    String input = """
        1
        2
        3
        """;

    Day01 day = new Day01(input);
    assertEquals("Not implemented", day.part2());
  }

  @Test
  void testWithRealInput() throws Exception {
    String realInput = new String(
        Day01Test.class.getClassLoader()
            .getResourceAsStream("day01.txt")
            .readAllBytes()
    );

    Day01 day = new Day01(realInput);

    // Replace these with actual expected answers once solved
    assertEquals("Not implemented", day.part1());
    assertEquals("Not implemented", day.part2());
  }
}
