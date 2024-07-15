package leetcode.solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms726 {

    public static void main(String[] args) {
        NumberOfAtoms726 atoms = new NumberOfAtoms726();
        System.out.println(atoms.countOfAtoms("H2O"));
        System.out.println(atoms.countOfAtoms("Mg(OH)2"));
        System.out.println(atoms.countOfAtoms("K4(ON(SO3)2)2"));
    }

    public String countOfAtoms(String formula) {

        int i = 0;
        char[] f = formula.toCharArray();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        while (i < f.length) {

            if (f[i] == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (f[i] == ')') {
                Map<String, Integer> map = stack.pop();
                i++;
                StringBuilder multiplier = new StringBuilder();
                while (i < f.length && Character.isDigit(f[i])) {
                    multiplier.append(f[i++]);
                }
                if (!multiplier.isEmpty()) {
                    Integer m = Integer.parseInt(multiplier.toString());
                    map.replaceAll((a, v) -> v * m);
                }

                for (String a : map.keySet()) {
                    stack.peek().put(a, stack.peek().getOrDefault(a, 0) + map.get(a));
                }
            } else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(i));
                i++;
                while (
                        i < formula.length() &&
                                Character.isLowerCase(formula.charAt(i))
                ) {
                    currAtom.append(formula.charAt(i));
                    i++;
                }

                StringBuilder currCount = new StringBuilder();
                while (
                        i < formula.length() &&
                                Character.isDigit(formula.charAt(i))
                ) {
                    currCount.append(formula.charAt(i));
                    i++;
                }

                int count = currCount.length() > 0
                        ? Integer.parseInt(currCount.toString())
                        : 1;
                stack
                        .peek()
                        .put(
                                currAtom.toString(),
                                stack.peek().getOrDefault(currAtom.toString(), 0) +
                                        count
                        );
            }
        }

        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());
        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }

    public String countOfAtoms1(String formula) {
        boolean containsBrackets = false;
        List<String> properFormula = new ArrayList<>();
        Queue<Atom> atoms = new PriorityQueue<>(Comparator.comparing(s -> s.name));
        char[] f = formula.toCharArray();
        for (int i = 0; i < f.length; ) {
            if (f[i] == '(') {
                containsBrackets = true;
                properFormula.add("(");
                i++;
            } else if (f[i] == ')') {
                properFormula.add(")");
                i++;
                String count = findCount(f, i);
                properFormula.add(count);
                i += count.length();
            } else {
                String atom = findAtomName(f, i);
                i += atom.length();
                String count = findCount(f, i);
                i += count.length();
                properFormula.add(atom);
                properFormula.add(count.isEmpty() ? "1" : count);
                atoms.add(new Atom(atom, count.isEmpty() ? 1 : Integer.parseInt(count)));
            }
        }
        System.out.println(atoms);

        for (String s : properFormula) {
            System.out.print(s);
        }
        StringBuilder ans = new StringBuilder();
        while (!atoms.isEmpty()) {
            Atom atom = atoms.poll();
            ans.append(atom.name);
            if (atom.count > 1) {
                ans.append(atom.count);
            }
        }
        return ans.toString();
    }

    private String findCount(char[] f, int i) {
        StringBuilder count = new StringBuilder();
        for (; i < f.length; i++) {
            if (f[i] >= '0' && f[i] <= '9') {
                count.append(f[i]);
            } else {
                break;
            }
        }

        return count.toString();
    }

    public String findAtomName(char[] f, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < f.length; i++) {
            if ((sb.isEmpty() && f[i] >= 'A' && f[i] <= 'Z') || (f[i] >= 'a' && f[i] <= 'z')) {
                sb.append(f[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    class Atom {
        String name;
        int count;

        public Atom(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Atom{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
