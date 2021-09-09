package com.dailycodebuffer.websocket;

import com.pi4j.io.gpio.*;

import java.text.DecimalFormat;

public class DistanceSensor {

    private static GpioPinDigitalOutput sensorTriggerPin ;
    private static GpioPinDigitalInput sensorEchoPin ;
    final static GpioController gpio = GpioFactory.getInstance();
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static double distance;


    public  static double measure()  throws InterruptedException {
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        final GpioPinDigitalOutput sensorTriggerPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23); // Trigger ist am GPIO pin 23
       sensorEchoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_22, PinPullResistance.PULL_DOWN); // Echo pin ist an GPIO pin 22
       //-----------------------------------------------------

            try {
                sensorTriggerPin.high(); // Triger sendet Signal (an)
                Thread.sleep((long) 0.01);// warte für 10 micro Sekunden
                sensorTriggerPin.low(); //Trigger ausschalten
                while(sensorEchoPin.isLow()){ //warte bis Echo Sensor aus geht
                }
                long startTime= System.nanoTime(); // Startzeit von System in Nanosekunden.
                while(sensorEchoPin.isHigh()){ //Warte bis der Echo Sensor an geht(Signal bekommt)
                }
                long endTime= System.nanoTime(); // Zeit stopen wenn einSignal kommt
                //System.out.println(Distance= (endTime-startTime(Nanosekunden)) /1e3(in Sekunden umwandeln) *340(Cs (in Meter)*100(in cm) /2(nur eine Richtung))
                //Nano -> Mikro -> Milli ->Sekunden * Geschwindigkeit in Meter *100 in cm / 2 nur eine Richtung
                distance = ((((((endTime-startTime)/1e3/1e3/1e3 )*340)*100)/2) );//in cm
                System.out.println("Distance : " + df.format(distance)+" Zentimeter");
            } catch (InterruptedException e) {e.printStackTrace();}
        gpio.shutdown();
        gpio.unprovisionPin(sensorTriggerPin);
        gpio.unprovisionPin(sensorEchoPin);
            return (distance);
            //return ("Distance : " + df.format(distance)+" Zentimeter");



        //--------------------------------------------


    }


    }


