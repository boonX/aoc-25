package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day04Test {

  @Test
  void testPart1Example() throws Exception {
    String input =
        """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
            """;

    Day04 day = new Day04(input);
    assertEquals("13", day.part1());
  }

  @Test
  void testPart2Example() throws Exception {
    String input =
        """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
            """;

    Day04 day = new Day04(input);
    assertEquals("43", day.part2());
  }

  @Test
  void testWithRealInput() throws Exception {
    String realInput = new String(
        Day04Test.class.getClassLoader()
            .getResourceAsStream("day04.txt")
            .readAllBytes()
    );

    Day04 day = new Day04(realInput);

    assertEquals("17427", day.part1());
    assertEquals("174161749617495", day.part2());
  }
}
