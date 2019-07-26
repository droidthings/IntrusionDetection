# Intrusuion Detection with MQTT and Grafana monitoring
MPU6050 MQTT based intrusion detection system


This Github page contains the documentation and codebase of the project "Intrusion detection with MQTT and Grafana Monitoring". The project is an effort of the students Abhilash Malleshappa Bhajantri (26119) and Vineeth Vijaykumar Chitragi (26213) in the study course Real Time Embedded System 2018-19 at Hochschule Rhein-Waal. The application involves

  - Develop a prototype sensor system which can publish/send the acceleration and gyroscope 3 axial data.
  - Subscribe for the data the store it in InfluxDB
  - Post the data to [ThingSpeak] Network 
  - Monitor the 3 axial data on [Grafana]
  
 ___


- [1. Introduction](#1-introduction)
  * [1.1 Problem Statement](#11-problem-statement)
  * [1.2 Overview](#12-overview)
- [2. Technology Review](#2-technology-review)
  * [2.1 LPWAN](#21-lpwan)
  * [2.2 LoRa](#22-lora)
  * [2.3 LoRaWan](#23-lorawan)
  * [2.4 Time-of-Flight Sensors](#24-time-of-flight-sensors)
- [3. Requirements Gathering](#3-requirements-gathering)
- [4. Methodology](#4-methodology)
- [5. Conclusion](#6-conclusion)

### 1. Introduction

Waste is one of the burden issues throughout the world which consequently impacts the environment and to some extent also poses an adverse effect on human health. Waste management is a challenging task to carry out which consists of collection, transport, treatment, and proper disposal and these tasks are followed one after the other in a structural manner for the proper waste management.

  

In the near future, concept of the smart cities will integrate with technology, that will have connectivity and communication to transmit data. Consequently which helps in the process of waste management such as optimising the routes that waste collector vehicles follow for waste collection and removal, together with automating operations with sensors on waste bins signalling that collection is needed when the bins are full. The data from the sensor can transmit information in real-time to a control information system which facilite with Internet of things. Then that redirect route for the collection to the driver and bins to empty. And along with traffic situations and estimated time for collection. After the bins are collected, then information of the waste types can be analysed to determine for the identification of the waste, for example, which bins need to redirect to recycling centres or to disposal centres. So, that will automate the overall process of waste management[1].

  

With the integration with [ ENNI ](https://www.enni.de/), who takes responsibility for the waste management of the Moers city. For the concern on a collection of waste around 11000 waste bins are situated through the Moers city. As from their information, there is a lot of effort and time consuming to identify and collect the waste.

  
  
#### 1.1 Problem Statement

  

On regarding of collection of waste, quite difficult to identify the waste bins are full or not. All the waste bin is not possible to full at the same time and there is the possibility of a single waste bin is full in a wide area where multiple waste bins are located. Along with that some area waste bin full in a shorter period of time while some area waste bin full in a longer period of time. So that requires more time and effort for the waste collector to empty the waste bin.

  
  
  

#### 1.2 Overview

  

Waste Bin integrated with a sensor which measures the height of the waste bin that helps to identify whether the waste is full or not. And along with that find the shortest path for the waste collector to empty the waste bin. So, that reduces time and effort for waster collector to drive through and collect the waste.

  

Initiation of the project with a selection of the appropriate sensor. Among the different sensor, on the basis of portability and accuracy, we select VL53L0X sensor. Consequently, needs a microcontroller board, on that behalf, ESP32 with Lora board is selected and so that makes possible wireless transmission of data from the sensor to the Internet. For receiving the data from Lora WLAN, The Things Network (TTN) is configured in such that established connection with the microcontroller. And the with integration with MQTT, that helps to extract the data from TTN to Database. So that subsequently Postgres Database is configured in such a way that able to store data from sensors. For the case of visualization, GeoServer helps to display with location a waste bins along with latitude and longitude, And having the capability of indication of waste present in the waste bin.

----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [ThingSpeak]: <https://thingspeak.com/>
   [Grafana]: https://grafana.com/
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
