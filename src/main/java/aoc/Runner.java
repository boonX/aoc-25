package aoc;

import java.lang.reflect.Constructor;

public class Runner {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.err.println("Usage: Runner <dayNumber>");
      System.exit(1);
    }

    int day = Integer.parseInt(args[0]);
    String className = "aoc.Day%02d".formatted(day);
    String input = loadInput(day);

    Class<?> clazz = Class.forName(className);
    Constructor<?> ctor = clazz.getConstructor(String.class);
    Day puzzle = (Day) ctor.newInstance(input);

    System.out.println("Day " + day + " - Part 1: " + puzzle.part1());
    System.out.println("Day " + day + " - Part 2: " + puzzle.part2());
  }

  private static String loadInput(int day) throws Exception {
    String filename = "day%02d.txt".formatted(day);
    var stream = Runner.class.getClassLoader().getResourceAsStream(filename);

    if (stream == null) {
      throw new IllegalArgumentException("Input file not found: " + filename);
    }

    return new String(stream.readAllBytes());
  }
}
