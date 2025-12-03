package aoc;

import java.util.Arrays;
import java.util.List;

public class Day03 implements Day {

  private final String input;
  private final List<String> lines;

  public Day03(String input) {
    this.input = input;
    this.lines = input.lines().toList();
  }

  @Override
  public String part1() {
    long sum = lines.parallelStream()
        .mapToLong(line -> findMaxJoltage(line, 2))
        .sum();

    return String.valueOf(sum);
  }

  private long findMaxJoltage(String bank, int numberOfBatteries) {
    int[] indices = new int[numberOfBatteries];
    for (int i = 0; i < indices.length; i++) {
      int startIndex = i == 0 ? 0 : indices[i - 1] + 1;
      int endIndex = bank.length() - numberOfBatteries + 1 + i;
      indices[i] = findIndexOfMaxJoltage(bank, startIndex, endIndex);
    }
    String maxJoltage = Arrays.stream(indices)
        .map(i -> bank.charAt(i) - '0')
        .mapToObj(String::valueOf)
        .reduce("", (a, b) -> a + b);
    System.out.println("Max from bank " + bank + " is " + maxJoltage);
    return Long.valueOf(maxJoltage);
  }

  private int findIndexOfMaxJoltage(String bank, int startIndex, int endIndex) {
    int maxIndex = startIndex;
    int max = bank.charAt(startIndex);
    for (int i = startIndex; i < endIndex; i++) {
      if (bank.charAt(i) > max) {
        maxIndex = i;
        max = bank.charAt(i);
      }
    }
    // System.out.println("Max index in " + bank + " is " + maxIndex + " with start " + startIndex + " and end " + endIndex);
    return maxIndex;
  }

  @Override
  public String part2() {
    long sum = lines.parallelStream()
        .mapToLong(line -> findMaxJoltage(line, 12))
        .sum();

    return String.valueOf(sum);
  }
}
