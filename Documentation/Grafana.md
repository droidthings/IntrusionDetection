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

First-step on the grafana console is to add datasource for the dashboard.
Under _configuration_ on left menu bar goto _Data Sources_, click on _Add data source_ and select _InfluxDB_
![G-2] ![G-3]



----


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Grafana-Get]: <https://grafana.com/get>
   [G-1]: <https://user-images.githubusercontent.com/10976047/62005750-116aaf00-b138-11e9-9b6d-7bc7de31ff94.PNG>
   [G-2]: <https://user-images.githubusercontent.com/10976047/62005798-d6b54680-b138-11e9-97d8-f2b4e915c20e.PNG>
   [G-3]: <https://user-images.githubusercontent.com/10976047/62005799-d917a080-b138-11e9-8412-15b223e3063b.PNG>
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
