package aoc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day02 implements Day {

  private final String input;
  private final List<String> lines;

  public Day02(String input) {
    this.input = input;
    this.lines = input.lines().toList();
  }

  @Override
  public String part1() {
    BigInteger sum = Arrays.asList(input.trim().split(",")).parallelStream()
        .map(Range::fromLine)
        .map(Range::findInvalidIds)
        .flatMap(List::stream)
        .reduce(BigInteger.ZERO, BigInteger::add);

    return String.valueOf(sum);
  }

  @Override
  public String part2() {
    BigInteger sum = Arrays.asList(input.trim().split(",")).parallelStream()
        .map(Range::fromLine)
        .map(Range::findInvalidIdsPart2)
        .flatMap(List::stream)
        .reduce(BigInteger.ZERO, BigInteger::add);

    return String.valueOf(sum);
  }

  record Range(BigInteger start, BigInteger end) {

    static Range fromLine(String line) {
      String[] rangeStrings = line.split("-");
      return new Range(new BigInteger(rangeStrings[0]), new BigInteger(rangeStrings[1]));
    }

    List<BigInteger> findInvalidIds() {
      List<BigInteger> invalidIds = new ArrayList<>();
      BigInteger step = BigInteger.ONE;
      // System.out.println("Finding invalid IDs between " + start + " and " + end);
      for (BigInteger id = start; id.compareTo(end) <= 0; id = id.add(step)) {
        String idString = String.valueOf(id);
        if (idString.length() % 2 != 0) {
          continue;
        }
        // System.out.println(idString);
        String first = idString.substring(0, idString.length() / 2);
        String second = idString.substring(idString.length() / 2);
        if (first.equals(second)) {
          // System.out.println("Found invalid ID: " + id);
          invalidIds.add(id);
        }
      }
      return invalidIds;
    }

    List<BigInteger> findInvalidIdsPart2() {
      List<BigInteger> invalidIds = new ArrayList<>();
      BigInteger step = BigInteger.ONE;
      // System.out.println("Finding invalid IDs between " + start + " and " + end);
      for (BigInteger id = start; id.compareTo(end) <= 0; id = id.add(step)) {
        String idString = String.valueOf(id);
        for (int length = 2; length <= idString.length(); length++) {
          if (idString.length() % length != 0) {
            continue;
          }
          if (idString.length() == length && idString.charAt(0) != idString.charAt(length - 1)) {
            continue;
          }
          // System.out.println(idString + " with part length " + length);
          String[] result = new String[length];
          int partLength = idString.length() / length;
          for (int i = 0; i < length; i++) {
            result[i] = idString.substring(i * partLength, (i + 1) * partLength);
          }
          // System.out.println(Arrays.toString(result));
          if (Stream.of(result).allMatch(s -> s.equals(result[0]))) {
            // System.out.println("Found invalid ID: " + id);
            invalidIds.add(id);
            break;
          }
        }
      }
      return invalidIds;
    }
  }
}
