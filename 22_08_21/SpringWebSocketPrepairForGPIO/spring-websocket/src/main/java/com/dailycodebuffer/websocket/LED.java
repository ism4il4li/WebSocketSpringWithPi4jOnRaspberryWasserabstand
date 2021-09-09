package com.dailycodebuffer.websocket;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;

public class LED {
    static GpioPinDigitalOutput gpio_17 = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_17);
    public static void an() {
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));


         gpio_17.high(); }
        //----------------------------------
        public static void aus() {
            GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
            gpio_17.low();}
}