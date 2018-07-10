package com.mycompany;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Draw extends JComponent {

    ArrayList<Triangle> triangles = new ArrayList<>();
    int iteration = 0;

    @Override
        public void paint(Graphics g) {
            Graphics2D graphics2D = (Graphics2D) g;

            Rectangle r = this.getBounds();
            Polygon polygon;
            Triangle triangle = new Triangle(new Point(r.width/2 - 5, 0), new Point(0, r.height - 5), new Point(r.width, r.height - 5));
            triangles.add(triangle);

            int number = 3*iteration;
            sierpinskiCalculation(triangle, number);


            for (Triangle t : triangles){
                polygon = new Polygon();
                polygon.addPoint(t.p1.x, t.p1.y);
                polygon.addPoint(t.p2.x, t.p2.y);
                polygon.addPoint(t.p3.x, t.p3.y);
                graphics2D.drawPolygon(polygon);
            }
            triangles.clear();

    }

    public void sierpinskiCalculation(Triangle triangle, int n){
         /*Tworze polygon (trojkat)
           obliczam kolejne punkty -> tworze polygon
           obliczam kolejne punkty dla stowrzonych trojkatow (?)
           {przekazuje do funkcji trojkat
           tworze 3 trojkaty **
           inkrementuje statyczny counter}

           **trojkat(punkt1, punkt2, punkt3){
           1-2 nowyPunkt1
           2-3 nP2
           3-1 nP3
           rysuje
           counter++ //zle;
           trojkat (punkt1, np1, np3);
           trojkat (punkt2, np2, np1);
           trojkat (punkt3, np3, np2);
           }**

           // counter = pow(3, counterGiven);
           */

         //Polygon creating
        if (n <= 0) {
            return;
        }

        Point p1, p2, p3;
        p1 = new Point((triangle.p1.x + triangle.p2.x)/2, (triangle.p1.y + triangle.p2.y)/2);
        p2 = new Point((triangle.p2.x + triangle.p3.x)/2, (triangle.p2.y + triangle.p3.y)/2);
        p3 = new Point((triangle.p3.x + triangle.p1.x)/2, (triangle.p3.y + triangle.p1.y)/2);

        Triangle triangle1 = new Triangle(triangle.p1, p1, p3);
        Triangle triangle2 = new Triangle(triangle.p2, p2, p1);
        Triangle triangle3 = new Triangle(triangle.p3, p3, p2);

        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);

        n = n - 3;
        sierpinskiCalculation(triangle1, n);
        sierpinskiCalculation(triangle2, n);
        sierpinskiCalculation(triangle3, n);

    }
}
