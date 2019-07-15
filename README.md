# Android Unity Bridge

Unity Bridge is a bridge between FMDriver and Unity. Unity has a listener which gets all the ACTION_RESPONSE from FMDriver.


#### FMDriver - 
A Driver that connects between Fitmat and Game
 
#### UnityBridge - 
A Driver that connects between Fitmat and Game
 


## Usage
```java

import com.fitmat.fitmatdriver.DriverControl;
import com.fitmat.fitmatdriver.Connection.BluetoothConnection;

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
```

Please make sure to update tests as appropriate.

## License
[FITMAT SMART SOLUTIONS](http://www.fundaysports.in)