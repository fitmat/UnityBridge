# PLUGIN - OUTDATED
Unity Bridge is outdated. Use on your own risk. Please look at updated plugin called [FMBridge](https://github.com/fitmat/FMBridge)

# Android Unity Bridge

Unity Bridge is a bridge between FMDriver and Unity. Unity has a listener which gets all the ACTION_RESPONSE from FMDriver.


#### FMDriver - 
A Driver that connects between Fitmat and Game
 
#### UnityBridge - 
A Driver that connects between Fitmat and Game
 


## Usage
Importing FMDriver classes
```java
import com.fitmat.fitmatdriver.DriverControl;
import com.fitmat.fitmatdriver.Connection.BluetoothConnection;
```

//STEP 0- Setting MAC-address of Bluetooth module (you must edit this line)
```java
private static String address = "00:18:91:D6:A8:C8";
```
//STEP 1- Setting cluster ID
```java
DriverControl.setGameID(2);
```
//STEP 2- Setting up Bluetooth address
```java
BluetoothConnection object = new BluetoothConnection(address);
```
//STEP 3- Setup the listener for this object
```java
object.setCustomObjectListener(new BluetoothConnection.CustomObjectListenerInterface() {
    @Override
    public void onObjectReady(String title) {
        Log.e("FMDRIVER","in onObjectReady");
    }

    //STEP 4- Response of FMDriver
    @Override
    public void onDataLoaded(String DriverResponse) {
        if(DriverResponse.trim().equals("Null")){
            Log.i("NULL RESPONSE", DriverResponse);
        }
        else {
            Log.i("ACTION", DriverResponse);
            TestClassPlugin.movingvalue = DriverResponse;
        }
    }
});
```

Please make sure to update tests as appropriate.

## License
[FITMAT SMART SOLUTIONS](http://www.fundaysports.in)
