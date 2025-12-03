package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day03Test {

  @Test
  void testPart1Example() throws Exception {
    String input =
        """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
            """;

    Day03 day = new Day03(input);
    assertEquals("357", day.part1());
  }

  @Test
  void testPart2Example() throws Exception {
    String input =
        """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
            """;

    Day03 day = new Day03(input);
    assertEquals("3121910778619", day.part2());
  }

  @Test
  void testWithRealInput() throws Exception {
    String realInput = new String(
        Day03Test.class.getClassLoader()
            .getResourceAsStream("day03.txt")
            .readAllBytes()
    );

    Day03 day = new Day03(realInput);

    assertEquals("17427", day.part1());
    assertEquals("173161749617495", day.part2());
  }
}
