public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        return G * mass * p.mass / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double dx = p.xxPos - xxPos;
        return force * dx / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double force = calcForceExertedBy(p);
        double distance = calcDistance(p);
        double dy = p.yyPos - yyPos;
        return force * dy / distance;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double forceX = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                forceX += calcForceExertedByX(p);
            }
        }
        return forceX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double forceY = 0;
        for (Planet p: planets) {
            if (!p.equals(this)) {
                forceY += calcForceExertedByY(p);
            }
        }
        return forceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + aX * dt;
        yyVel = yyVel + aY * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}
