# ESP8266-WiFi-Stream-GIF
This project is Stream the large number image data to ESP8266 and display it like a GIF.
Stream Server I use JAVA to create the Socket to stream the image data.

#What you need
Hardware:
*A board containg an ESP8266 chip
*SSD1306 based 128x64 pixel OLED display

**SSD1306:(For Wemos D1 ESP8266)**

    =====  =======================
    Pin    GPIO
    =====  =======================
    SCL    D3/D15
    SDA    D4/D14
    =====  =======================
    
Software:
*(Arduino library)ESP8266 Arduino Core
*(Arduino library)Adafruit GFX Library
Java JDK

**Arduino Code Config:**

    =====      =======================
    Var        GPIO
    =====      =======================
    ssid       WiFi ssid
    password   WiFi password 
    host       StreamServer ip address
    port       StreamServer port(default:5045)
    framedelay image player speed(default:40ms)
    =====      =======================

