#include <ESP8266WiFi.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#define REST 0
#define OLED_RESET -1
#define SCREEN_WIDTH 128 // OLED display width, in pixels
#define SCREEN_HEIGHT 64 // OLED display height, in pixels
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);
#define LOGO_HEIGHT   128
#define LOGO_WIDTH    64

const char* ssid     = "wifissid"; //wifi ssid
const char* password = "widipassword"; //wifi password
const char* host = "serveripaddress"; // Server ipaddress
const int port = 5045; //Server poer
const int framedelay = 40; //control draw speed

int socketstate = 0;
unsigned char drawbitmap [1024]={};
WiFiClient client;


void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);
  display.begin(SSD1306_SWITCHCAPVCC, 0x3c);
  display.clearDisplay();
  display.setTextSize(1);           
  display.setTextColor(WHITE);       
  display.setCursor(0,0);    
  display.println(F("WiFi Connting..."));
  display.display();
  while (WiFi.status() != WL_CONNECTED)
    {
        delay(500);
        Serial.println("WiFi Connting");
    }
    
  display.println(F("WiFi connected"));
  display.println(F("IP address:"));
  display.println(WiFi.localIP());
  display.println(F("Server connecting..."));
  display.display();
  
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  
}

void loop() {
  
  if(socketstate!=1 && WiFi.status()==WL_CONNECTED)
  {  
    socketstate = client.connect(host, port);
    
    if(socketstate!=1){
      Serial.println("Client connect false");
    }else{
      Serial.println("Client connect sucess");
      display.println(F("ServerSocket connect Sucess"));
      display.println(F("Stream is ready"));
      display.display();
    }
    
  }
  
  while(client.available()){
    client.readBytes(drawbitmap,1024);
    client.flush();
    display.clearDisplay();
    display.drawBitmap( 0,0,drawbitmap, 128, 64, 1);
    display.display();
    delay(framedelay);
  }
}
