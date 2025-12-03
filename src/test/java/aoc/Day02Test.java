package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day02Test {

  @Test
  void testPart1Example() throws Exception {
    String input =
        "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";

    Day02 day = new Day02(input);
    assertEquals("1227775554", day.part1());
  }

  @Test
  void testPart2Example() throws Exception {
    String input =
        "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";

    Day02 day = new Day02(input);
    assertEquals("4174379265", day.part2());
  }

  @Test
  void testWithRealInput() throws Exception {
    String realInput = new String(
        Day02Test.class.getClassLoader()
            .getResourceAsStream("day02.txt")
            .readAllBytes()
    );

    Day02 day = new Day02(realInput);

    assertEquals("29940924880", day.part1());
    assertEquals("48631958998", day.part2());
  }
}
