package AdvanceDSA.Arrayproblems;

import java.net.Inet4Address;
import java.util.ArrayList;
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
 */

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class P4_MergeInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> inseredIntervals=new ArrayList<>();
        int i=0;
        for(;i<intervals.size();i++) {
            Interval current_interval = intervals.get(i);
            if (newInterval.start >= current_interval.start && newInterval.start <= current_interval.end
                    || newInterval.end >= current_interval.start && newInterval.end <= current_interval.end
            ||newInterval.start<=current_interval.start&&newInterval.end>= current_interval.end) {
                newInterval.start = Math.min(newInterval.start, current_interval.start);
                newInterval.end = Math.max(newInterval.end, current_interval.end);
               // System.out.println(newInterval.start+" "+newInterval.end);

            } else {
                if (newInterval.end < current_interval.start) {
                    //add the new interval
                    //System.out.println(i);
                    break;
                } else {
                    inseredIntervals.add(current_interval);
                }
            }
        }


        //System.out.println("index "+i);
        inseredIntervals.add(newInterval);
        for(;i<intervals.size();i++){
            Interval current_interval=intervals.get(i);
            inseredIntervals.add(current_interval);
        }
        //System.out.println(inseredIntervals.size());
       // for(int j=0;j<inseredIntervals.size();j++){
        //    System.out.println(inseredIntervals.get(j).start+" "+inseredIntervals.get(j).end);
       // }
        return inseredIntervals;

    }
    public static void main(String[] args) {
        Interval I1=new Interval(3,10);
        Interval I2=new Interval(16,19);
        Interval I3=new Interval(20,25);
        Interval I4=new Interval(37,39);
        Interval I5=new Interval(45,50);

        Interval I6=new Interval(51,54);
        Interval item=new Interval(21,48);
        ArrayList<Interval> intervals=new ArrayList<>();
        intervals.add(I1);
        intervals.add(I2);
        intervals.add(I3);
        intervals.add(I4);
        intervals.add(I5);
        intervals.add(I6);
        //intervals.add(I7);
        ArrayList<Interval> mergedIntervals=insert(intervals,item);
        //System.out.println(mergedIntervals.size());
        for (Interval mergedInterval : mergedIntervals) {
            System.out.println(mergedInterval.start+" "+mergedInterval.end);
        }


    }
}
