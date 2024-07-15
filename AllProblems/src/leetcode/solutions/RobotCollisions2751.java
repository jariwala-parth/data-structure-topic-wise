package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class RobotCollisions2751 {
    public static void main(String[] args) {
        RobotCollisions2751 robotCollisions2751 = new RobotCollisions2751();
        System.out.println(robotCollisions2751.survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR"));
        System.out.println(robotCollisions2751.survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL"));
        System.out.println(robotCollisions2751.survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL"));
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        {
            int n = positions.length;
            Integer[] indices = new Integer[n];
            List<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int index = 0; index < n; ++index) {
                indices[index] = index;
            }

            Arrays.sort(
                    indices,
                    Comparator.comparingInt(lhs -> positions[lhs])
            );

            for (int currentIndex : indices) {
                // Add right-moving robots to the stack
                if (directions.charAt(currentIndex) == 'R') {
                    stack.push(currentIndex);
                } else {
                    while (!stack.isEmpty() && healths[currentIndex] > 0) {
                        // Pop the top robot from the stack for collision check
                        int topIndex = stack.pop();

                        // Top robot survives, current robot is destroyed
                        if (healths[topIndex] > healths[currentIndex]) {
                            healths[topIndex] -= 1;
                            healths[currentIndex] = 0;
                            stack.push(topIndex);
                        } else if (healths[topIndex] < healths[currentIndex]) {
                            // Current robot survives, top robot is destroyed
                            healths[currentIndex] -= 1;
                            healths[topIndex] = 0;
                        } else {
                            // Both robots are destroyed
                            healths[currentIndex] = 0;
                            healths[topIndex] = 0;
                        }
                    }
                }
            }

            // Collect surviving robots
            for (int index = 0; index < n; ++index) {
                if (healths[index] > 0) {
                    result.add(healths[index]);
                }
            }
            return result;
        }
//        List<Integer> ans = new ArrayList<>();
//        List<Robot> robots = new ArrayList<>();
//        List<Robot> robotsInOrder = new ArrayList<>();
//        Queue<Robot> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.position));
//        int n = positions.length, l = 0, r = 0;
//        for (int i = 0; i < n; i++) {
//            char d = directions.charAt(i);
//            Robot robot = new Robot(healths[i], positions[i], d);
//            priorityQueue.add(robot);
//            if (d == 'L') {
//                l++;
//            } else {
//                r++;
//            }
//            robotsInOrder.add(robot);
//        }
//
//        while (!priorityQueue.isEmpty()) {
//            Robot robot = priorityQueue.poll();
//            robots.add(robot);
//        }
//
//        Integer collisionIndex = findCollision(robots);
//        while (collisionIndex != null) {
//            if (robots.get(collisionIndex).health > robots.get(collisionIndex + 1).health) {
//                robots.get(collisionIndex).health = robots.get(collisionIndex).health - 1;
//                robots.remove(collisionIndex + 1);
//            } else if (robots.get(collisionIndex).health < robots.get(collisionIndex + 1).health) {
//                robots.get(collisionIndex + 1).health = robots.get(collisionIndex + 1).health - 1;
//                robots.remove((int) collisionIndex);
//            } else {
//                robots.remove((int) collisionIndex);
//                robots.remove((int) collisionIndex);
//            }
//            collisionIndex = findCollision(robots);
//        }
////        System.out.println("robots ANS:");
////        System.out.println(robots);
////        System.out.println(robotsInOrder);
//        Set<Integer> remainingPositions = robots.stream().map(Robot::getPosition).collect(Collectors.toSet());
//        for (Robot robot : robotsInOrder) {
//            if (remainingPositions.contains(robot.position)) {
//                ans.add(robot.health);
//            }
//        }
//        return ans;
    }

    private Integer findCollision(List<Robot> robots) {

        for (int i = 0; i < robots.size() - 1; i++) {
            if (robots.get(i).direction == 'R' && robots.get(i + 1).direction == 'L') {
                return i;
            }
        }
        return null;
    }

    static class Robot {
        private final int position;
        private final Character direction;
        private final int health;

        public Robot(int health, int position, Character direction) {
            this.health = health;
            this.position = position;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "health=" + health +
                    ", position=" + position +
                    ", direction=" + direction +
                    '}';
        }

        public int getPosition() {
            return position;
        }
    }
}
