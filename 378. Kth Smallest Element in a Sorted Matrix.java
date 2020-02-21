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

Better Solution 2: binary search (using value, not index)
O(1) space

class Solution {
  public static int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int start = matrix[0][0], end = matrix[n - 1][n - 1];
    
    while (start < end) {
      int mid = start + (end - start) / 2;
      // first number is the smallest and the second number is the largest
      // after countLessEqual function, 
      // the first ele is the largest num <= mid
      // the second ele is the smallest num > mid
      int[] smallLargePair = { matrix[0][0], matrix[n - 1][n - 1] };

      int count = countLessEqual(matrix, mid, smallLargePair);

      if (count == k)
        return smallLargePair[0];

      if (count < k)
        start = smallLargePair[1]; // search higher
      else
        end = smallLargePair[0]; // search lower
    }

    return start;
  }

  private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
    int count = 0;
    int n = matrix.length, row = n - 1, col = 0;
    while (row >= 0 && col < n) {
      if (matrix[row][col] > mid) {
        // as matrix[row][col] is bigger than the mid, let's keep track of the
        // smallest number greater than the mid
        smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
        row--;
      } else {
        // as matrix[row][col] is less than or equal to the mid, let's keep track of the
        // biggest number less than or equal to the mid
        smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
        count += row + 1;
        col++;
      }
    }
    return count;
  }
}
