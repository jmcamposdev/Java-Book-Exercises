package unit08.Actividad19_20_Ampliacion;

public class Punto3D extends Punto{
    private int z;

    public Punto3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }

    public int getZ(){
        return this.z;
    }
    public void setZ(int z){
        this.z = z;
    }

    @Override
    public double distancia(Punto p){
        if (p instanceof Punto3D){
            Punto3D p3d = (Punto3D) p;
            return Math.sqrt(Math.pow(this.getX() - p3d.getX(),2) + Math.pow(this.getY() - p3d.getY(),2) + Math.pow(this.getZ() - p3d.getZ(),2));
        } else {
            return super.distancia(p);
        }
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = false;
        if (obj instanceof Punto3D){
            Punto3D p = (Punto3D) obj;
            if (this.getX() == p.getX() && this.getY() == p.getY() && this.getZ() == p.getZ()){
                equals = true;
            }
        }
        return equals;
    }
}
