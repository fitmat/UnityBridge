package com.example.yj.bluetoothapplication;
import android.os.Bundle;
import android.util.Log;
import com.unity3d.player.UnityPlayerActivity;
import com.fitmat.fitmatdriver.DriverControl;
import com.fitmat.fitmatdriver.Connection.BluetoothConnection;
public class StartActivity extends UnityPlayerActivity {
    private static final String TAG = "bluetooth2";

    //STEP 0- Setting MAC-address of Bluetooth module (you must edit this line)
    private static String address = "00:18:91:D6:A8:C8";//"00:18:E4:35:B0:88";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //STEP 1- Setting cluster ID
    DriverControl.setGameID(2);

    //STEP 2- Setting up Bluetooth address
    BluetoothConnection object = new BluetoothConnection(address);

    //STEP 3- Setup the listener for this object
    object.setCustomObjectListener(new BluetoothConnection.CustomObjectListenerInterface() {
        @Override
        public void onObjectReady(String title) {
            Log.e("FMDRIVER","in onObjectReady");
        }

        //STEP 4- Response of FMDriver
        @Override
        public void onDataLoaded(String DriverResponse) {
            if(DriverResponse.trim().equals("Null")){
                Log.i("INSIDE IF", DriverResponse);
            }
            else {
                TestClassPlugin.movingvalue = DriverResponse;
            }
        }
    });
    }
}