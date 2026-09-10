/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author prasad
 */
public class CalcImpl extends UnicastRemoteObject implements CalcIntf {

    public CalcImpl() throws RemoteException {
        
    }

    @Override
    public float add(float a, float b) throws RemoteException {
        return a + b;
    }

    @Override
    public float sub(float a, float b) throws RemoteException {
        return a - b;
    }

    @Override
    public float mul(float a, float b) throws RemoteException {
        return a * b;
    }

    @Override
    public float div(float a, float b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}