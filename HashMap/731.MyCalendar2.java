class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlap;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlap = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] iv: overlap){
            if(start < iv[1] && end > iv[0]) return false;
        }
        for(int[] iv: calendar){
            if(start < iv[1] && end > iv[0]){
                overlap.add(new int[]{Math.max(iv[0],start),Math.min(iv[1],end)});
            }
        }
        calendar.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */