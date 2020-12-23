import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;

public class Task019 {
    public static void main(String[] args) {
        List<StraightLine> listLines = new ArrayList<>();
        listLines.add(new StraightLine(2, -1, -3));
        listLines.add(new StraightLine(-3, -1, 2));
        listLines.add(new StraightLine(-3, -1, 2));
        listLines.add(new StraightLine(-3, -1, 2));
        listLines.add(new StraightLine(-3, -1, 4));
        listLines.add(new StraightLine(-3, -1, 5));
        listLines.add(new StraightLine(-1, -1, 4));
        listLines.add(new StraightLine(-1, -1, 5));


        for (Object line : listLines) {
            System.out.printf("Прямая: %s;%s", line, System.lineSeparator());
            System.out.printf("Точки пересечения с осями: %s, %s;%s",
                    line.getPointIntersectionWithX(), line.getPointIntersectionWithY(), System.lineSeparator());
            System.out.println();
        }

        System.out.println("Точки пересечения 2-х прямых:");
        System.out.printf("%s;%s%s;%s", listLines.get(0), System.lineSeparator(), listLines.get(1), System.lineSeparator());
        System.out.printf("%s%s", listLines.get(0).getPointIntersectionLines(listLines.get(1)), System.lineSeparator());
        System.out.println();

        Map<StraightLine, List<StraightLine»HashMap groups = getGroupsParallel(listLines);

        for (Map.Entry<StraightLine, List<StraightLine) group : groups.entrySet()) {
            if (group.getValue().size() > 0) {
                System.out.printf("Прямая %s параллельна с:%s", group.getKey(), System.lineSeparator());
                for (StraightLine line : group.getValue()) {
                    System.out.printf(" %s;%s", line, System.lineSeparator());
                }
                System.out.println();
            }
        }
    }

    public static Map<StraightLine, List<StraightLine» static HashMap getGroupsParallel(List<StraightLine> list) {
        Map<StraightLine, List<StraightLine»HashMap<Object, Object> map = new HashMap<>();
        if (list != null && !list.isEmpty()) {
            boolean flag;
            while (!list.isEmpty()) {
                flag = false;
                StraightLine line = (StraightLine) list.remove(0);
                for (StraightLine lineMap : map.keySet()) {
                    if (lineMap.isParallel(line)) {
                        map.get(lineMap).add(line);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    map.put(line, new ArrayList<>());
                }
            }
        }
        return map;
    }
}

class StraightLine {
    private int a;
    private int b;
    private int c;

    public StraightLine(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getPointIntersectionWithX() {
        return String.format("{%.2f, 0}", (double) -this.c / (double) this.a);
    }

    public String getPointIntersectionWithY() {
        return String.format("{0, %.2f}", (double) -this.c / (double) this.b);
    }

    public boolean isParallel(StraightLine line) {
        double coeffOne = (double) this.a / (double) line.a;
        double coeffTwo = (double) this.b / (double) line.b;
        double coeffThree = (double) this.c / (double) line.c;
        return coeffOne == coeffTwo && coeffOne != coeffThree;
    }

    public boolean isEquals(StraightLine line) {
        double coeffOne = (double) this.a / (double) line.a;
        double coeffTwo = (double) this.b / (double) line.b;
        double coeffThree = (double) this.c / (double) line.c;
        return coeffOne == coeffTwo && coeffOne == coeffThree;
    }

    public String getPointIntersectionLines(StraightLine line) {
        String result = null;
        if (line != null) {
            if (isEquals(line)) {
                result = "Прямые равны. Имеют бесконечное множество точек пересечения.";
            } else if (isParallel(line)) {
                result = "Прямые параллельны. Точек пересечения нет.";
            } else {
                double y = (double) (line.a * this.c - this.a * line.c) / (double) (this.a * line.b - line.a * this.b);
                double x = (this.b * y + this.c) / (double) -this.a;
                result = String.format("Точка пересечения: {%.2f, %.2f};", x, y);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = getBlock(this.a, "x", true);
        result = result.concat(getBlock(this.b, "y", this.a == 0));
        result =

                result.concat(getBlock(this.c, "", this.a == 0 && this.b == 0));
        return result.concat(" = 0");
    }

    private String getBlock(int number, String prefix, boolean first) {
        String result = "";
        if (number != 0) {
            if (first) {
                result = String.format("%d%s", number, prefix);
            } else {
                String sign = number < 0 ? "-" : "+";
                result = String.format("%s %d%s", sign, Math.abs(number), prefix);
            }
        }
        return result;