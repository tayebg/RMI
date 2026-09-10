/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author prasad
 */
public interface CalcIntf extends Remote {
    public float add(float x, float y) throws RemoteException;
    public float sub(float x, float y) throws RemoteException;
    public float mul(float x, float y) throws RemoteException;
    public float div(float x, float y) throws RemoteException;
}