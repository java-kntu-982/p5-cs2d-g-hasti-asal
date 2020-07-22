package ir.ac.kntu.cs2d.map;

import ir.ac.kntu.cs2d.map.item.Brown;
import ir.ac.kntu.cs2d.map.item.Cream;
import ir.ac.kntu.cs2d.map.item.Gray;
import ir.ac.kntu.cs2d.map.item.Orange;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    private List<Cream> creamWalls;
    private List<Orange> orangeWalls;
    private List<Gray> grayBoxes;
    private List<Brown> brownBoxes;

    public Map(int width, int height) {
        creamWalls = new ArrayList<>();
        orangeWalls = new ArrayList<>();
        grayBoxes = new ArrayList<>();
        brownBoxes = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/maps/empty.txt"));
            scanner.nextLine();
            while (scanner.hasNext()) {
                switch (scanner.nextLine()) {
                    case "cream":
                        creamWalls.add(new Cream(readShape(scanner.nextLine(), width, height)));
                        break;
//                    case "orange":
//                        orangeWalls.add(new Orange(readShape(scanner.nextLine(), width, height)));
//                        break;
//                    case "gray":
//                        grayBoxes.add(new Gray(readShape(scanner.nextLine(), width, height)));
//                        break;
//                    case "brown":
//                        brownBoxes.add(new Brown(readShape(scanner.nextLine(), width, height)));
//                        break;
                    default:
//                        System.out.println("map file got problem");
//                        System.out.println(scanner.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Rectangle readShape(String line, int width, int height) {
        String[] strings = line.split(" ");
        double[] doubles = new double[8];
        for (int i = 0; i < 8; i++) {
            doubles[i] = Double.parseDouble(strings[i]);
        }
        return new Rectangle(doubles[0]*width + doubles[1]*height,
                             doubles[2]*width + doubles[3]*height,
                             doubles[4]*width + doubles[5]*height,
                             doubles[6]*width + doubles[7]*height);
    }

    public List<Cream> getCreamWalls() {
        return creamWalls;
    }

    public void setCreamWalls(List<Cream> creamWalls) {
        this.creamWalls = creamWalls;
    }

    public List<Orange> getOrangeWalls() {
        return orangeWalls;
    }

    public void setOrangeWalls(List<Orange> orangeWalls) {
        this.orangeWalls = orangeWalls;
    }

    public List<Gray> getGrayBoxes() {
        return grayBoxes;
    }

    public void setGrayBoxes(List<Gray> grayBoxes) {
        this.grayBoxes = grayBoxes;
    }

    public List<Brown> getBrownBoxes() {
        return brownBoxes;
    }

    public void setBrownBoxes(List<Brown> brownBoxes) {
        this.brownBoxes = brownBoxes;
    }
}
