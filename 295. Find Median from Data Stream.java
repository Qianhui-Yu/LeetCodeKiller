295. Find Median from Data Stream

class MedianFinder {
    Queue<Integer> rmin;
    Queue<Integer> lmax;
    boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        rmin = new PriorityQueue<>();
        lmax = new PriorityQueue<>(Collections.reverseOrder());
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            lmax.offer(num);
            rmin.offer(lmax.poll());
        }
        else {
            rmin.offer(num);
            lmax.offer(rmin.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) 
            return (lmax.peek() + rmin.peek()) / 2.0;
        else
            return (double)rmin.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */