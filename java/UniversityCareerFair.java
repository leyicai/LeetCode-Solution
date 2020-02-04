import java.util.Arrays;

class Event implements Comparable<Event> {
    public int arrival;
    public int finish;

    public Event(int arrival, int finish) {
        this.arrival = arrival;
        this.finish = finish;
    }

    @Override
    public int compareTo(Event event) {
        return this.finish - event.finish;
    }
}

class UniversityCareerFair {
    public static int maxEvents(int[] arrival, int[] duration) {
        Event[] events = new Event[arrival.length];
        for (int i = 0; i < arrival.length; i++) {
            events[i] = new Event(arrival[i], arrival[i] + duration[i]);
        }
        Arrays.sort(events);
        int res = 1, currEnd = events[0].finish;
        for (int i = 1; i < events.length; i++) {
            if (events[i].arrival > currEnd) {
                res++;
                currEnd = events[i].finish;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arrival = new int[] { 1, 3, 3, 5, 7 };
        int[] duration = new int[] { 2, 2, 1, 2, 1 };
        System.out.println(maxEvents(arrival, duration));
    }
}