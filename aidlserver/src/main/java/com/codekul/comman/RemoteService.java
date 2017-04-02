package com.codekul.comman;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteService extends Service {

    private RemoteImpl impl = new RemoteImpl();

    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return impl;
    }

    private class RemoteImpl extends IComman.Stub {

        @Override
        public String day(int num) throws RemoteException {
            return num == 1 ? "MON" : "SUN";
        }
    }
}
