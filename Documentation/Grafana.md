# Grafana

## Installation

Download the grafana server-client executables from [Grafana-Get]

Unzip the package, navigate to _bin_ folder launch _grafana-server.exe_ to launch grafana server.

By Default Grafana runs on posr **3000**, it can be modified in file _/grafana-6.2.5/conf/defaults.ini_ file. 
```
# The http port to use
http_port = 9000
```
In this project it has been modified to **9000**

User credentials also are by default to login to dashboard.
```
[security]
# default admin user, created on startup
admin_user = admin

# default admin password, can be changed before first start of grafana, or in profile settings
admin_password = admin
```
![G-1]

## Data Source configuration

First-step on the grafana console is to add datasource for the dashboard.
Under _configuration_ on left menu bar goto _Data Sources_, click on _Add data source_ and select _InfluxDB_
![G-2]

## Dashboard pannel

### Choosing the suitable visualisation
Click on _Add_ icon or select _Add new panel_ from the top bar, select _Choose Visualisation_. Wide varieties on graphical representations can be choosen 
![G-3]

### Querying the data from source
From the _Query_ panel select the data source from the dropdown, select the mesurement/table and can start selecting the field values necessary to represent on the chossen graph.  
![G-4]

Grafana also provides an option to inspect the queries where we can see the flow of data from out data source
![G-5]

Grafana comes with most advanced setting for any graphical representations available. It allows to changes the mode of the graph as bars, points and lines. Variour color spectrums are available to mark the values. User can modify the tooltips and many more. 
Threshold setting is one of the settings included, which allows user to set different threshold limits and set the color gradient accordingly.

![G-6]

In this project we have selected Graphs, heatmaps and Gauge visualisation to represent the 3-axis accelerometer and 3-axis
gyroscope data.

![G-7]

The implementation and mechanisms involved in Granfa and influxDB are much more. It can be extended to various other application as related to IoT. Follow the below links for more better understanding via videos of the techilogies used in this project.

[https://www.youtube.com/results?search_query=influxdb-grafana]
[https://www.youtube.com/watch?v=DmIWgkawcw4&list=PLoVvAgF6geYMb029jpxqMuz5dRDtO0ydM]
[https://www.youtube.com/watch?v=5JrT1DPlu0c&t=325s]

----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Grafana-Get]: <https://grafana.com/get>
   [G-1]: <https://user-images.githubusercontent.com/10976047/62005750-116aaf00-b138-11e9-9b6d-7bc7de31ff94.PNG>
   [G-2]: <https://user-images.githubusercontent.com/10976047/62005834-43304580-b139-11e9-8c94-ac3bbb60699e.PNG>
   [G-3]: <https://user-images.githubusercontent.com/10976047/62005882-e719f100-b139-11e9-8812-70d087a76098.PNG>
   [G-4]: <https://user-images.githubusercontent.com/10976047/62005961-be462b80-b13a-11e9-9ba8-947f467e5e29.png>
   [G-5]: <https://user-images.githubusercontent.com/10976047/62005984-0402f400-b13b-11e9-9a6b-d47c1368173a.PNG>
   [G-6]: <https://user-images.githubusercontent.com/10976047/62006070-26494180-b13c-11e9-9442-33cf34b98224.PNG>
   [G-7]: <https://user-images.githubusercontent.com/10976047/62006167-63620380-b13d-11e9-9e10-35bca3e3127f.PNG>
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
