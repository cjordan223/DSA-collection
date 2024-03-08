// Title: Main_Hw2_1
// Abstract: Calculates and displays the time difference between two user-input timestamps.
// Name: Conner Jordan
// Date: 1-16-2024

import java.util.Scanner;

public class Main {

    static class Time {
        int hour, minute, second;

        Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        int toSeconds() {
            return hour * 3600 + minute * 60 + second;
        }

        static Time fromSeconds(int totalSeconds) {
            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            return new Time(hours, minutes, seconds);
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time startTime = readTime(scanner);
        Time endTime = readTime(scanner);

        Time difference = calculateDifference(startTime, endTime);
        System.out.println(difference);
    }

    private static Time readTime(Scanner scanner) {
        String[] parts = scanner.next().split(":");
        return new Time(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

    private static Time calculateDifference(Time start, Time end) {
        int startSeconds = start.toSeconds();
        int endSeconds = end.toSeconds();

        // If the end time is earlier than the start time, add 24 hours to the end time
        if (endSeconds < startSeconds) {
            endSeconds += 24 * 3600;
        }

        int diffInSeconds = endSeconds - startSeconds;

        return Time.fromSeconds(diffInSeconds);
    }
}
