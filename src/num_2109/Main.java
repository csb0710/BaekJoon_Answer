package num_2109;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int price;
    int day;

    public Node(int price, int day) {
        this.price = price;
        this.day = day;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if(o1.price == o2.price)
                    return o1.day - o2.day;
                return o2.price - o1.price;
            }
        });
        boolean[] visit = new boolean[10001];

        Arrays.fill(visit, false);

        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int temp_price = Integer.parseInt(st.nextToken());
            int temp_day = Integer.parseInt(st.nextToken());
            Node temp = new Node(temp_price, temp_day);

            pq.add(temp);
        }

        int salary = 0;

        while(!pq.isEmpty()) {
            Node temp = pq.poll();

            for(int i = temp.day; i > 0; i--) {
                if(!visit[i]) {
                    visit[i] = true;
                    salary += temp.price;
                    break;
                }
            }


        }

        System.out.println(salary);

    }
}
