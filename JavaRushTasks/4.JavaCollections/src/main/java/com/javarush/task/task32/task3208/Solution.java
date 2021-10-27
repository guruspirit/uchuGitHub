package com.javarush.task.task32.task3208;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/* 
RMI-2
*/

public class Solution {
    public static Registry registry;
    public static final String UNIC_BINDING_NAME_CAT = "server.cat";
    public static final String UNIC_BINDING_NAME_DOG = "server.dog";

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            try {

                final Cat cat = new Cat("Barsik");
                final Dog dog = new Dog("Buggy");
                registry = LocateRegistry.createRegistry(2099);
                Remote stub = UnicastRemoteObject.exportObject(cat,0);
                Remote stub_dog = UnicastRemoteObject.exportObject(dog,0);
                registry.bind(UNIC_BINDING_NAME_CAT,stub);
                registry.bind(UNIC_BINDING_NAME_DOG,stub_dog);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }

        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
