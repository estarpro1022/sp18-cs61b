public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        in.readDouble();

        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please enter arguments.");
            System.exit(0);
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int num = planets.length;

        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for (Planet planet: planets) {
            planet.draw();
        }

        double time = 0;
        while (time < T) {
            StdDraw.clear();
            StdDraw.picture(0, 0, "./images/starfield.jpg");

            // 计算每个行星的受力情况
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for (int i = 0; i < num; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // draw planet
            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
