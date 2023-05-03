package unit07.Hora;

/*
    7.6
    Escribir un programa que lea por teclado una hora cualquiera y un número n que 
    represente una cantidad en segundos. El programa mostrará la hora introducida y las n 
    siguientes, que se diferencian en un segundo. Para ello hemos de diseñar previamente la clase hora
    que dispone de los atributos hora, minutos y segundos. Los valores de los atributos se controlan
    mediante métodos set/get
 */

public class Hora {
    private int hora,minutos,segundos;
    
    public int getHora() {
        return hora;
    } 
    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23)
            this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        if (minutos >= 0 && minutos <= 59)
            this.minutos = minutos;

    }

    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        if (segundos >= 0 && segundos <= 59)
            this.segundos = segundos;
    }
    
    public void incrementarSegundo(){
        segundos++;
        if (segundos == 60){
            segundos = 0;
            if (++minutos == 60){
                minutos = 0;
                if (++hora == 24){
                    hora = 0;
                }
            }
        }
    }






}
