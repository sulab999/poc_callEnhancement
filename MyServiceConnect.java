package com.example.callenhancement;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class MyServiceConnect implements ServiceConnection {
    public int a = 1;
    public static int b = 1;
    public IBinder myIBinder;
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myIBinder = iBinder;
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    public String transact(int code){
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("org.codeaurora.callenhancement.ICallEnhancement");
        Parcel reply = Parcel.obtain();
        try {
            boolean a = myIBinder.transact(code, data, reply, 0);
            Log.i("Stat_Info", "transact result: " + a);
            reply.readException();
            String s = reply.toString();
            Log.i("Stat_Info", "code: " + code + "\t||\t服务端发来的消息: " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * represent a boolean value
     * isCallRecording
     * canCallRecord
     * @param code
     * @return
     */
    public int transact_int(int code){
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("org.codeaurora.callenhancement.ICallEnhancement");
        Parcel reply = Parcel.obtain();
        try {
            boolean a = myIBinder.transact(code, data, reply, 0);
            Log.i("Stat_Info", "transact result: " + a);
            reply.readException();
            int s = reply.readInt();
            Log.i("Stat_Info", "code: " + code + "\t||\t服务端发来的消息: " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * represent a long value
     * getRecordedCallDuration
     * @param code
     * @return
     */
    protected Long transact_long(int code){
        Parcel data = Parcel.obtain();
        data.writeInterfaceToken("org.codeaurora.callenhancement.ICallEnhancement");
        Parcel reply = Parcel.obtain();
        try {
            boolean a = myIBinder.transact(code, data, reply, 0);
            Log.i("Stat_Info", "transact result: " + a);
            reply.readException();
            Long s = reply.readLong();
            Log.i("Stat_Info", "code: " + code + "\t||\t服务端发来的消息: " + s);
            return s;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return (long)-1;
    }
}
