import java.util.concurrent.Semaphore;

public class Comensal implements Runnable {
    private String nombre;
    private int prioridad;
    private Semaphore semaforo;
    private static int MAGDALENAS = 15;

    public Comensal(String nombre, int prioridad, Semaphore semaforo) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.semaforo = semaforo;
    }

    public void run() {
        while (MAGDALENAS > 0) { //tiene acceso
            try {
                semaforo.acquire(); //el conteo interno del semáforo se reduce en 1
                if (MAGDALENAS > 0) {
                    MAGDALENAS--;
                    System.out.println(nombre + " ha cogido una magdalena de la mesa. Quedan " + MAGDALENAS + " magdalenas");
                    Thread.sleep(10000);
                    System.out.println(nombre + " se ha terminado de comer una magdalena");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //se libera y el semaforo vuelve a 1
                semaforo.release();
            }
        }
    }
}

