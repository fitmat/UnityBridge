package com.example.yj.bluetoothapplication;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Field;


public class TestClassPlugin {


    protected Class<?> _unityPlayerClass;
    protected Field _unityPlayerActivityField;
   // private Method _unitySendMessageMethod;
    public static Activity _activity;

   public static String movingvalue="Begin";

    public static TestClassPlugin instance;


    public void ReturnFromPlugin11(){

        System.out.println("inside intent fitmat 11");
        Log.e("inside intent fitmat","fitmat 11");
       // return  "fitmat is here";

    }


    public static String ReturnData(){


      return movingvalue;

    }


    public static void  ReturnFromPlugin22(){

        instance =  new TestClassPlugin();

        System.out.println("instance created");
        instance.ReturnFromPlugin();



    }

    public  void ReturnFromPlugin(){

        System.out.println("inside intent fitmat");
        try
        {
            _unityPlayerClass = Class.forName("com.unity3d.player.UnityPlayer");
            _unityPlayerActivityField = _unityPlayerClass.getField("currentActivity");
          //  _unitySendMessageMethod = _unityPlayerClass.getMethod("UnitySendMessage", new Class[] { String.class, String.class, String.class });




            Intent intent = new Intent(getActivity(), StartActivity.class);

            System.out.println("inside intent fitmat");


             getActivity().startActivity(intent);

            //TestClassPlugin1.getInstance().showToast();

        }
        catch (ClassNotFoundException e)
        {

            System.out.println("inside class not fitmat");

            // Log.i(TAG, "could not find UnityPlayer class: " + e.getMessage());
        }
        catch (NoSuchFieldException e)
        {
            System.out.println("no field fitmat");

            // Log.i(TAG, "could not find currentActivity field: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("exceptoinp showtoast fitmat"+e.getMessage()+"--"+e.toString());

            // Log.i(TAG, "unknown exception occurred locating getActivity(): " + e.getMessage());
        }


        System.out.println("inside showtoast fitmat");




    }


    protected Activity getActivity()
    {
        if (_unityPlayerActivityField != null)
        {
            try
            {
                Activity activity = (Activity)_unityPlayerActivityField.get(_unityPlayerClass);
                if (activity == null) {
                   // Log.i(TAG, "Something has gone terribly wrong (or not if this is from a notification invocation while the app is shutdown). The Unity Activity does not exist. This could be due to a low memory situation");
                }
                return activity;
            }
            catch (Exception e)
            {
               // Log.i(TAG, "error getting currentActivity: " + e.getMessage());
            }
        }

        return _activity;
    }

    protected void runSafelyOnUiThread(Runnable r)
    {
        runSafelyOnUiThread(r, null);
    }


    protected void runSafelyOnUiThread(final Runnable r, final String methodName)
    {
        getActivity().runOnUiThread(new Runnable()
        {

            public void run()
            {
                try
                {
                    r.run();

                }
                catch (Exception e)
                {
                                    }
            }
        });
    }


}
