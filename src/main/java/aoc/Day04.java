package aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04 implements Day {

  private final String input;
  private final List<String> lines;

  public Day04(String input) {
    this.input = input;
    this.lines = input.lines().toList();
  }

  @Override
  public String part1() {
    int sum = 0;
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        boolean isRoll = line.charAt(x) == '@';
        if (!isRoll) {
          continue;
        }

        List<Row> rowsToCheck = new ArrayList<>();
        int[] topBotIndices = x == 0 ? new int[] { x + 1, x }
            : x == line.length() - 1 ? new int[] { x - 1, x }
                : new int[] { x - 1, x, x
                    + 1 };
        if (y != 0) {
          rowsToCheck.add(new Row(lines.get(y - 1), topBotIndices));
        }

        int[] middleIndices = x == 0 ? new int[] { x + 1 }
            : x == line.length() - 1 ? new int[] { x - 1 } : new int[] { x - 1, x + 1 };
        rowsToCheck.add(new Row(lines.get(y), middleIndices));

        if (y != lines.size() - 1) {
          rowsToCheck.add(new Row(lines.get(y + 1), topBotIndices));
        }
        long numberOfAdjacentRolls = rowsToCheck.stream().mapToLong(Row::getNumberOfRolls).sum();
        if (numberOfAdjacentRolls < 4) {
          sum++;
        }
      }
    }
    return String.valueOf(sum);
  }

  @Override
  public String part2() {
    Result result = new Result(0, lines);
    long lastSum = 0;
    do {
      lastSum = result.sum;
      result = getSum(result.newLines);
    } while (result.sum > lastSum);

    return String.valueOf(result.sum);
  }

  record Result(long sum, List<String> newLines) {
  }

  private Result getSum(List<String> lines) {
    int sum = 0;
    List<String> newLines = new ArrayList<>();
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      String newLine = "";
      for (int x = 0; x < line.length(); x++) {
        boolean isRoll = line.charAt(x) == '@';
        if (!isRoll) {
          newLine += ".";
          continue;
        }

        List<Row> rowsToCheck = new ArrayList<>();
        int[] topBotIndices = x == 0 ? new int[] { x + 1, x }
            : x == line.length() - 1 ? new int[] { x - 1, x }
                : new int[] { x - 1, x, x
                    + 1 };
        if (y != 0) {
          rowsToCheck.add(new Row(lines.get(y - 1), topBotIndices));
        }

        int[] middleIndices = x == 0 ? new int[] { x + 1 }
            : x == line.length() - 1 ? new int[] { x - 1 } : new int[] { x - 1, x + 1 };
        rowsToCheck.add(new Row(lines.get(y), middleIndices));

        if (y != lines.size() - 1) {
          rowsToCheck.add(new Row(lines.get(y + 1), topBotIndices));
        }
        long numberOfAdjacentRolls = rowsToCheck.stream().mapToLong(Row::getNumberOfRolls).sum();
        if (numberOfAdjacentRolls < 4) {
          sum++;
          newLine += ".";
        } else {
          newLine += line.charAt(x);
        }
        if (x == line.length() - 1) {
          newLines.add(newLine);
        }
      }
    }
    return new Result(sum, newLines);
  }

  record Row(String row, int... indices) {

    long getNumberOfRolls() {
      return Arrays.stream(indices)
          .map(row::charAt)
          .filter(c -> c == '@')
          .count();
    }
  }
}
