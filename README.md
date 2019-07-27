# Intrusuion Detection with MQTT and Grafana monitoring
MPU6050 MQTT based intrusion detection system


This Github page contains the documentation and codebase of the project "Intrusion detection with MQTT and Grafana Monitoring". The project is an effort of the students Abhilash Malleshappa Bhajantri (26119) and Vineeth Vijaykumar Chitragi (26213) in the study course Real Time Embedded System 2018-19 at Hochschule Rhein-Waal. The application involves

  - Develop a prototype sensor system with [ESP32] and [MPU6050] which can publish/send the acceleration and gyroscope 6 axial data.
  - Subscribe for the data the store it in [InfluxDB]
  - Post the data to [ThingSpeak] Portal 
  - Monitor the 6 axial (3-axis gyroscope and a 3-axis accelerometer) data on [Grafana]
  
 ___


- [1. Introduction](#1-introduction)
- [2. Architecture overview](#2-architecture-overview)
- [3. Technology review](#3-technology-review)
  * [3.1 ESP32](#31-esp32)
  * [3.2 Accelerometer and Gyroscope sensors](#32-accelerometer-and-gyroscope-sensors)
  * [3.3 Node-RED](#33-node-red) 
  * [3.4 MQTT](#34-mqtt)
    - [3.4.1 Installation](#341-installation)
  * [3.5 InfluxDB](#35-influxdb)
  * [3.6 Grafana](#36-grafana)
- [4. Methodology](#4-methodology)
- [5. Conclusion](#5-conclusion)

### 1. Introduction

The Compact I2C devices like Gyroscope Sensor can easily help you out in the axial monitoring system which detects the parameters and shares it to the user through MQTT and can monitored on [Grafana] or can be controlled via mobile devices. This motion tracking system can also help to detect intrusions at a personal house or any commercial building with proper implementaion. This project is prototype of such system where the data is visualised on [Grafana]. In addition the project also has an Andorid application which notifies the user in case of any intrusion.

#### 2. Architecture overview
![Arc1]
The current application has two parts implementation
  1. Publish the sensor readings and subscribe for the values via [MQTT] broker on [Node-RED]. Join all the sensor data and insert it         into [InfluxDB] which is a time series database and finally we query the data on [Grafana] for monitoring and visualising.
  2. Post the sensor data to [ThingSpeak] portal which in turn will give an REST api. This api can be configured in Android. Based on        the 3-Axis accelerometer the user will recceive the notification in case of any intrusion detection.

The first approach via MQTT broker has been the primary focus of this project.

### 3. Technology Review


#### 3.1 ESP32


#### 3.2 Accelerometer and Gyroscope sensors


#### 3.3 Node-RED

Node-RED in light-weight programming tool built on Node.js for wiring the hardware components together as nodes, APIs and online service in a new and interesting way. It provides a browser-based flow editor that makes it easy to wire together flows using the wide range of nodes in the palette. This makes it ideal to run at the edge of the network on low-cost hardware such as the Raspberry Pi as well as in the cloud.The flows created in Node-RED are stored using JSON which can be easily imported and exported for sharing with others. An online flow library allows you to share your best flows with the world.

The complete installation guide, instruction sets, different types of nodes used and the wiring mechanism can be found [here](/Documentation/Node-RED.md) in detail.

#### 3.4 MQTT

MQTT is a machine-to-machine (M2M)/"Internet of Things" connectivity protocol [MQTT]. It stands for MQ Telemetry Transport but previously was known as Message Queuing Telemetry Transport. It's a lightweight publish/subscribe messaging protocol designed for M2M (machine to machine) telemetry in low bandwidth environments.MQTT is fast becoming one of the main protocols for IOT (internet of things) deployments. See [MQTT vs HTTP] for the comparison of performances.

#### 3.4.1 Installaion

Download the suitable MQTT broker from [MOSQUITTO] and install it on your PC/Laptop.

Once installation is done navigate to _C:\Program Files\mosquitto_(_on windows_) or wherever the broker is installed and run _mosquitto.exe_

By default the mosquitto broker runs on port **1883**, but it can be modified inside _C:\Program Files\mosquitto\mosquitto.conf_

You can now connect to the broker using your machine's IP along with post number , 
```
#include <WiFi.h>
#include <PubSubClient.h>
WiFiClient espClient;
PubSubClient client(espClient);

//Ip address of your machine
const char* mqtt_server = "192.168.0.38";

void setup() {
 .
 .
    setup_wifi();
    client.setServer(mqtt_server, 1883);
 .
 .
}

void loop() {
 .
 .  
    client.publish("esp32/XAcc", String(ax).c_str(), true);
    client.publish("esp32/YAcc", String(ax).c_str(), true);
    client.publish("esp32/XGyr", String(ax).c_str(), true);
 .
 .
```
Complete code can be found [here](/Code/ESP32-MPU6050/MQTTClient.ino). Once you run the program on your board you will be able to subscribe to above mentioned sensor readings in the code snippet.


#### 3.5 InfluxDB
InfluxDB is an open source time series database platform. This includes APIs for storing and querying data, processing it in the background for ETL or monitoring and alerting purposes, user dashboards, and visualizing and exploring the data and more. InfluxDB is very easy to start and scale time series data gives deep insights for unified metrics and events. It has diverted the industry focus from Relational database like SQL and has become vital for IoT based businesses to capture and analyze untapped data from virtual and physical assets to seize new opportunities. 

The complete installation guide, instruction sets and set up can be found [here](/Documentation/InfluxDB.md) in detail.



----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [ThingSpeak]: <https://thingspeak.com/>
   [Grafana]: https://grafana.com/
   [InfluxDB]: <https://www.influxdata.com/>
   [MPU6050]: <https://www.invensense.com/products/motion-tracking/6-axis/mpu-6050/>
   [ESP32]: <http://esp32.net/>
   [MQTT]: <http://mqtt.org/>
   [Node-RED]: <https://nodered.org/>
   [MQTT vs HTTP]: <https://medium.com/mqtt-buddy/mqtt-vs-http-which-one-is-the-best-for-iot-c868169b3105>
   [MOSQUITTO]: <https://mosquitto.org/download/>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   
   [Arc1]: <https://user-images.githubusercontent.com/10976047/61985260-b4bca680-b008-11e9-9504-4bce37d6da4f.PNG>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
