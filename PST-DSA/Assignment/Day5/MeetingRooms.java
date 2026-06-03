package Assignment.Day5;

/*
Problem Statement: Meeting Rooms You are given an array of meeting time intervals, where each interval is represented as [start, end]. A person can only attend one meeting at a time. Write a function canAttendMeetings(int[][] intervals) that determines if a person can attend all meetings without any overlaps.
Example 1 Input: intervals = [[0,30],[5,10],[15,20]] Output: false Explanation:
Meeting [0,30] overlaps with [5,10] and [15,20]. The person cannot attend all meetings.
 */
import java.util.Arrays;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};

        System.out.println(canAttendMeetings(intervals1)); // false
        System.out.println(canAttendMeetings(intervals2)); // true
    }
}