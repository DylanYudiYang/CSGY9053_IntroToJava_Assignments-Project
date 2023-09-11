//Yudi Yang, Section I, Dean Christakos, 2023.2.15, A3p1
public class SquarePyramid {
    private static int nextId = 1;
    private int id;
    private double side = 1;
    private double height = 1;
    
    public SquarePyramid() {	//default: a = H = 1
        this.id = nextId++;
    }

    public SquarePyramid(double side, double height) {
        this.id = nextId++;
        this.side = side;
        this.height = height;
    }

    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
    	this.side = side;
    }

    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return side * side * height / 3;
    }

    public double getSurfaceArea() {
        return side * side + 2 * side * Math.sqrt(side * side / 4 + height * height);
    }
    
    public int getId() {
        return id;
    }	
    
	public static void main(String[] args) {
		SquarePyramid s1 = new SquarePyramid(2,5);
		System.out.println(s1.getSide());
		System.out.println(s1.getHeight());
		System.out.println(s1.getVolume());
		s1.setHeight(2);
		System.out.println(s1.getHeight());
		System.out.println(s1.getVolume());
	}
}

