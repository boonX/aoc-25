package aoc;

import java.util.List;

import aoc.Day01.Rotation.Direction;

public class Day01 implements Day {

  private final String input;
  private final List<String> lines;

  public Day01(String input) {
    this.input = input;
    this.lines = input.lines().toList();
  }

  @Override
  public String part1() {
    List<Rotation> rotations = lines.stream().map(Rotation::fromLine).toList();
    int dial = 50;
    int nbrOfZeros = 0;
    for (Rotation rotation : rotations) {
      dial = rotateDial(dial, rotation.direction, rotation.value);
      dial = (dial + 100) % 100;
      if (dial == 0) {
        nbrOfZeros++;
      }
    }
    return String.valueOf(nbrOfZeros);
  }

  @Override
  public String part2() {
    List<Rotation> rotations = lines.stream().map(Rotation::fromLine).toList();
    int dial = 50;
    int nbrOfZeros = 0;
    for (Rotation rotation : rotations) {
      nbrOfZeros += getWholeRotations(rotation.value);
      int rotationValue = calculatRotationValueWithoutWholeRotations(rotation.value);
      if (rotationValue == 0) {
        continue;
      }

      int prevDial = dial;
      dial = rotateDial(dial, rotation.direction, rotationValue);
      if (isZeroOrHasPassedZero(dial, prevDial)) {
        nbrOfZeros++;
      }
      dial = (dial + 100) % 100;
    }
    return String.valueOf(nbrOfZeros);
  }

  private int calculatRotationValueWithoutWholeRotations(int value) {
    return value % 100;
  }

  private int getWholeRotations(int updatedValue) {
    return updatedValue / 100;
  }

  private boolean isZeroOrHasPassedZero(int dial, int prevDial) {
    if (Math.abs(dial) % 100 == 0) {
      return true;
    }
    if (dial < 0) {
      return prevDial != 0;
    }
    return dial > 100;
  }

  private int rotateDial(int dial, Direction direction, int value) {
    return switch (direction) {
      case LEFT -> dial - value;
      case RIGHT -> dial + value;
    };
  }

  record Rotation(Direction direction, int value) {

    enum Direction {
      LEFT, RIGHT
    }

    static Rotation fromLine(String line) {
      char dirChar = line.charAt(0);
      Direction direction = switch (dirChar) {
        case 'L' -> Direction.LEFT;
        case 'R' -> Direction.RIGHT;
        default -> throw new IllegalArgumentException("Invalid direction: " + dirChar);
      };
      int value = Integer.parseInt(line.substring(1));
      return new Rotation(direction, value);
    }
  }
}
