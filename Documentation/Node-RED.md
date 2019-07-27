# Node-RED

## Installation

Node-RED is built on Node.js. Download Node.js from [nodejs.org] according to your operating system. NPM modules will be installed globally.

Install Node-RED
```
npm install node-red -g
```
From the cli run, 
```
> node-red
```
![nr-cli]

Open the link  _http://127.0.0.1:1880/_ since that's the default port link for Node-RED portal.

![nr-1]

On the left side we have menu kind of structure which is called Node palletes. We can drag and configure them according to the requirement.

### The current architecture flow
![nr-6]

Node-RED console also provides an option to import/export the flows in JSON format so that it can be shared with everyone else in the development team.
Click on the _hamburger_ icon on the top right corner and you can see the options to export/import the flow.

The current flow can be found  [here](/node-red-flows/flows.json)

## Node pallette 

### Inject Node
![nr-3]
Inject node helps to input a certain value which can be number, string, object. 
For eg - In the below figure _Payload_ is a string and its publishing the payload via _sensorX_ topic through the MQTT broker.

![nr-2]

### MQTT Node
![nr-4] 
MQTT node, confgure thr broker according to the broker parameters which will be running on your system.

![nr-5]

### Join Node
![nr-7]
Join node helps to join all the data coming from various MQTT subscribers.

Combine all all the sensor reading as key/value object so that we can insert the data directly to InfluxDB. The beauty of the InfluxDB is that it will automatically create columns according to the keys from the join node.
![nr-8]




----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [downloads]: <https://nodejs.org/en/>
   [nr-cli]: <https://user-images.githubusercontent.com/10976047/61995488-8d59ee00-b089-11e9-8b20-ece55d770dec.PNG>
   [nr-1]: <https://user-images.githubusercontent.com/10976047/61995591-d3fc1800-b08a-11e9-94bc-eb71dd49ff68.png>
   [nr-2]: <https://user-images.githubusercontent.com/10976047/61995649-669cb700-b08b-11e9-902f-0f300da49fa5.PNG>
   [nr-3]: <https://user-images.githubusercontent.com/10976047/61995665-9d72cd00-b08b-11e9-8374-269a814816e4.PNG>
   [nr-4]: <https://user-images.githubusercontent.com/10976047/61995777-24747500-b08d-11e9-8aa2-79abf55a9642.PNG>
   [nr-5]: <https://user-images.githubusercontent.com/10976047/61995783-335b2780-b08d-11e9-8cad-8c1987b8dab6.PNG>
   [nr-6]: <https://user-images.githubusercontent.com/10976047/61995818-803efe00-b08d-11e9-8565-57f9e57ded0e.PNG>
   [nr-7]: <https://user-images.githubusercontent.com/10976047/61995874-3276c580-b08e-11e9-99a5-8e84b7d61cd2.PNG>
   [nr-8]: <https://user-images.githubusercontent.com/10976047/61995884-3e628780-b08e-11e9-8792-5335720c817b.PNG>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
