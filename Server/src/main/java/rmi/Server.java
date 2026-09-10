/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
/**
 *
 * @author prasad
 */
public class Server {
    public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1091);
            r.rebind("Calculator", new CalcImpl());
            System.out.println("server is running");
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
}