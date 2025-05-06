// A newspaper delivery boy every day drops news paper in a society with many lanes and houses. 
// Design a program to provide different paths that he could follow. 
// Solve the problem by suggesting appropriate data structures. Design necessary class.

// 1. A simple Java program using graph data structures (adjacency list).

// 2. The ability to add houses (nodes) and lanes (edges).

// 3. A function to display all possible paths between two houses.

package DS;

import java.util.*;

class Society {
    private Map<String, List<String>> adjList;

    public Society() {
        adjList = new HashMap<>();
    }

    // Add a house (node)
    public void addHouse(String house) {
        adjList.putIfAbsent(house, new ArrayList<>());
    }

    // Add a lane (edge)
    public void addLane(String from, String to) {
        adjList.get(from).add(to);
        adjList.get(to).add(from); // Assuming roads are bidirectional
    }

    // Display all paths from start to end
    public void displayAllPaths(String start, String end) {
        List<List<String>> allPaths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfs(start, end, visited, currentPath, allPaths);

        if (allPaths.isEmpty()) {
            System.out.println("No path found from " + start + " to " + end);
        } else {
            System.out.println("All possible paths from " + start + " to " + end + ":");
            for (List<String> path : allPaths) {
                System.out.println(path);
            }
        }
    }

    // Depth-First Search to find all paths
    private void dfs(String current, String end, Set<String> visited, List<String> currentPath, List<List<String>> allPaths) {
        visited.add(current);
        currentPath.add(current);

        if (current.equals(end)) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, end, visited, currentPath, allPaths);
                }
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited.remove(current);
    }
}

public class DeliveryPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Society society = new Society();

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter house names:");
        for (int i = 0; i < n; i++) {
            String house = sc.nextLine();
            society.addHouse(house);
        }

        System.out.print("Enter number of lanes: ");
        int m = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter lanes (format: HouseA HouseB):");
        // A B
        // A C
        for (int i = 0; i < m; i++) {
            String[] lane = sc.nextLine().split(" ");
            society.addLane(lane[0], lane[1]);
        }

        System.out.print("Enter starting house: ");
        String start = sc.nextLine();

        System.out.print("Enter destination house: ");
        String end = sc.nextLine();

        society.displayAllPaths(start, end);
        sc.close();
    }
}

