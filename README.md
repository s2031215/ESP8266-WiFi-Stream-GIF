# ESP8266-WiFi-Stream-GIF
This project is Stream the large number image data to ESP8266 and display it like a GIF.<br>
Stream Server I use JAVA to create the Socket to stream the image data.<br>

#What you need<br>
Hardware:<br>
*A board containg an ESP8266 chip<br>
*SSD1306 based 128x64 pixel OLED display<br>

**SSD1306:(For Wemos D1 ESP8266)**

    =====  =======================
    Pin    GPIO
    =====  =======================
    SCL    D3/D15
    SDA    D4/D14
    =====  =======================
    
Software:<br>
*(Arduino library)ESP8266 Arduino Core<br>
*(Arduino library)Adafruit GFX Library<br>
Java JDK<br>

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

