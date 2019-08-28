// 
// Decompiled by Procyon v0.5.36
// 

public class Coordinates
{
    static int mapY;
    static int cameraY;
    public int plane;
    public int worldX;
    public int worldY;
    
    public Coordinates(final Coordinates coordinates_1) {
        this.plane = coordinates_1.plane;
        this.worldX = coordinates_1.worldX;
        this.worldY = coordinates_1.worldY;
    }
    
    public Coordinates(final int int_0, final int int_1, final int int_2) {
        this.plane = int_0;
        this.worldX = int_1;
        this.worldY = int_2;
    }
    
    public Coordinates() {
        this.plane = -1;
    }
    
    public Coordinates(final int int_0) {
        if (int_0 == -1) {
            this.plane = -1;
        }
        else {
            this.plane = (int_0 >> 28 & 0x3);
            this.worldX = (int_0 >> 14 & 0x3FFF);
            this.worldY = (int_0 & 0x3FFF);
        }
    }
    
    public void set(final int int_0, final int int_1, final int int_2) {
        this.plane = int_0;
        this.worldX = int_1;
        this.worldY = int_2;
    }
    
    public int bitpack() {
    	System.out.println("<bitpack> Coordinates: <"+this.worldX+","+this.worldY+","+this.plane+">");
        return this.plane << 28 | this.worldX << 14 | this.worldY;
    }
    
    boolean method4439(final Coordinates coordinates_1) {
        return this.plane == coordinates_1.plane && this.worldX == coordinates_1.worldX && this.worldY == coordinates_1.worldY;
    }
    
    String method4441(final String string_0) {
    	System.out.println("<method4441> Args: "+string_0);
        return this.plane + string_0 + (this.worldX >> 6) + string_0 + (this.worldY >> 6) + string_0 + (this.worldX & 0x3F) + string_0 + (this.worldY & 0x3F);
    }
    
    @Override
    public int hashCode() {
        return this.bitpack();
    }
    
    @Override
    public String toString() {
        return this.method4441(",");
    }
    
    @Override
    public boolean equals(final Object object_0) {
        return this == object_0 || (object_0 instanceof Coordinates && this.method4439((Coordinates)object_0));
    }
}
