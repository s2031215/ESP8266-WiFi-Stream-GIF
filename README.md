# ESP8266-WiFi-Stream-GIF
This project is Stream the large number image data to ESP8266 and display it like a GIF.<br>
Stream Server I use JAVA to create the Socket to stream the image data.<br>

# What you need<br>
<h3>Hardware:</h3>
<ul>
  <li>A board containg an ESP8266 </li>
  <li>SSD1306 based 128x64 pixel OLED display</li>
</ul>
<br>
**SSD1306:(For Wemos D1 ESP8266)**

    =====  =======================
    Pin    GPIO
    =====  =======================
    SCL    D3/D15
    SDA    D4/D14
    =====  =======================
    
<h3>Software:</h3>
<ul>
   <li>(Arduino library)ESP8266 Arduino Core </li>
   <li>(Arduino library)Adafruit GFX Library </li>
   <li>Java JDK </li>
</ul>

<br>
**Arduino Var Config:**

    =====      =======================
    ssid       WiFi ssid
    password   WiFi password 
    host       StreamServer ip address
    port       StreamServer port(default:5045)
    framedelay image player speed(default:40ms)
    =====      =======================

