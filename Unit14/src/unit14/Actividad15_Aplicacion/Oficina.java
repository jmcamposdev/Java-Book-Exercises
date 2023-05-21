package unit14.Actividad15_Aplicacion;

public class Oficina {
    private int oficina;
    private String ciudad;
    private int superficie;
    private int ventas;

    public Oficina(int ofician, String ciudad, int superficie, int ventas) {
        if (superficie <= 0) throw new IllegalArgumentException("La superficie no puede ser negativa");
        if (ventas <= 0) throw new IllegalArgumentException("Las ventas no pueden ser negativas");

        this.oficina = ofician;
        this.ciudad = ciudad;
        this.superficie = superficie;
        this.ventas = ventas;
    }

    public Oficina (Oficina oficina) {
        this.oficina = oficina.oficina;
        this.ciudad = oficina.ciudad;
        this.superficie = oficina.superficie;
        this.ventas = oficina.ventas;
    }

    public int getOficina() {
        return oficina;
    }
    public String getCiudad() {
        return ciudad;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getVentas() {
        return ventas;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setSuperficie(int superficie) {
        if (superficie > 0) this.superficie = superficie;

    }

    public void setVentas(int ventas) {
        if (ventas > 0) this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Oficia: " + ciudad + ", superficie: " + superficie + ", ventas: " + ventas;
    }


}
