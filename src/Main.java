import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        // creamos un semaphore con un permiso de 1 para controlar el acceso al recurso compartido
        Semaphore semaforo = new Semaphore(1);

        //creamos 3 objetos comensales con diferentes prioridades
        Thread comensal1 = new Thread(new Comensal("Comensal 1", 1, semaforo));
        Thread comensal2 = new Thread(new Comensal("Comensal 2", 5, semaforo));
        Thread comensal3 = new Thread(new Comensal("Comensal 3", 10, semaforo));

        //establecemos la prioridad de los hilos
        comensal1.setPriority(Thread.MIN_PRIORITY);
        comensal2.setPriority(Thread.NORM_PRIORITY);
        comensal3.setPriority(Thread.MAX_PRIORITY);

        //iniciamos los hilos
        comensal1.start();
        comensal2.start();
        comensal3.start();
    }
}