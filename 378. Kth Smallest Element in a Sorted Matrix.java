Solution 1: minHeap by Priority Queue
treat the m*n matrix as m sorted lists
At first, put min(m, k) elements into minHeap
Then, in k times & heap is not empty, do the following actions:
poll an element, count++, if count = k, return
else: if the element is not at the end of its list, add the next ele to minHeap
Finally, return the element

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
           @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        
        int row = matrix.length;
        if (row == 0) return -1;
        
        for (int i = 0; i < row && i < k; i++) {
            minHeap.add(new Node(i, 0, matrix[i][0]));
        }
        
        int count = 0;
        int result = -1;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = node.val;
            if (++count == k) break;
            if (node.y >= matrix[0].length - 1) continue;
            minHeap.add(new Node(node.x, node.y + 1, matrix[node.x][node.y + 1]));
        }
        
        return result;
    }
}

class Node {
    int x;
    int y;
    int val;
    
    Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}