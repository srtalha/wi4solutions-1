# WI4SOLUTIONS

Project to finnish calls throw goip devices.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing


Mariadb Install
-------------------
```
apt install  default-mysql-server/kali-rolling
apt install default-mysql-client/kali-rolling
#Start mysql
# /etc/init.d/mysql start
mysql_secure_installation
```

Clone project source code

```
#apt install git
#apt-get install apache2
#mkdir /var/www/projects
#mkdir -p /var/www/projects
#cd /var/www/projects
```
Clone repository with your custom git access: (After that you will have project source code in server to install it)

```
#git clone https://github.com/nesmor/wi4solutions.git
Username for 'https://github.com/nesmor/wi4solutions.git':[github Username]
Password for [github [github Username]] 'https://github.com/nesmor/wi4solutions.git':[github password]
```

Asterisk Install
-------------------
```
#apt update && sudo apt upgrade
#apt install wget build-essential subversion
#cd /usr/src/
#wget http://downloads.asterisk.org/pub/telephony/asterisk/asterisk-16-current.tar.gz
#tar -zxf asterisk-16-current.tar.gz
#mv asterisk-16.1.0/ asterisk
#cd asterisk/
#contrib/scripts/get_mp3_source.sh
#contrib/scripts/install_prereq install
#./configure
#make
#make menuselect
#make install
#make samples
#apt-get install asterisk
#/etc/init.d/asterisk start
#systemctl enable asterisk
#cp /var/www/projects/wi4solutions/springboot/wi4solutions/asterisk/*conf /etc/asterisk
#cp /var/www/projects/wi4solutions/springboot/wi4solutions/asterisk/odbc.ini /etc/.
#cp /var/www/projects/wi4solutions/springboot/wi4solutions/asterisk/odbcinst.ini /etc/.
#cp /var/www/projects/wi4solutions/springboot/wi4solutions/libs/libmyodbc* /usr/lib/x86_64-linux-gnu/odbc/.
```
Change config files base on custom server ip and database settings if it is necesary.
Validate odbc connection

```
echo "select 1" | isql -v asterisk-connector
```

Out will be something like:
```
+---------------------------------------+
| Connected!                            |
|                                       |
| sql-statement                         |
| help [tablename]                      |
| quit                                  |
|                                       |
+---------------------------------------+
SQL> select 1
+---------------------+
| 1                   |
+---------------------+
| 1                   |
+---------------------+
SQLRowCount returns 1
1 rows fetched
```
Install g729 and  g2723 asterisk code:

```
#cd /var/www/projects/wi4solutions/springboot/wi4solutions/asterisk/codec
#chmod +x codec_g729-ast160-gcc4-glibc-x86_64-pentium4.so
#chmod +x codec_g723-ast160-gcc4-glibc-x86_64-pentium4.so
cp /var/www/projects/wi4solutions/springboot/wi4solutions/asterisk/codec/codec_g72*.so /usr/lib/asterisk/modules/.
mv /usr/lib/asterisk/modules/codec_g723-ast160-gcc4-glibc-x86_64-pentium4.so  /usr/lib/asterisk/modules/codec_g723.so
mv /usr/lib/asterisk/modules/codec_g729-ast160-gcc4-glibc-x86_64-pentium4.so  /usr/lib/asterisk/modules/codec_g729.so
"HERE RESTART ASTERISK"
asterisk -r
core restart now
asterisk -r
core show translation 



"You will see tabkle with codecs"
 000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000 15000 17250   15000
     g726  15000 15000 15000 15000 15000     -    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000 15000 17250   15000
 g726aal2  15000 15000 15000 15000 15000 15000        - 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000 15000 17250   15000
    adpcm  15000 15000 15000 15000 15000 15000    15000     -  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000 15000 17250   15000
    slin8   6000  6000  6000  6000  6000  6000     6000  6000     -   8000   8000   8000   8000   8000   8000   8000    8000  6000  6000   6000   14000   14000  6000  8250    6000
   slin12  14500 14500 14500 14500 14500 14500    14500 14500  8500      -   8000   8000   8000   8000   8000   8000    8000 14500 14500  14500   14000   14000 14500 14000   14500
   slin16  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500      -   8000   8000   8000   8000   8000    8000 14500 14500  14500    6000   14000 14500  6000   14500
   slin24  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500      -   8000   8000   8000   8000    8000 14500 14500  14500   14500   14000 14500 14500   14500
   slin32  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500   8500      -   8000   8000   8000    8000 14500 14500  14500   14500    6000 14500 14500   14500
   slin44  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500   8500   8500      -   8000   8000    8000 14500 14500  14500   14500   14500 14500 14500   14500
   slin48  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500   8500   8500   8500      -   8000    8000 14500 14500  14500   14500   14500 14500 14500   14500
   slin96  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500   8500   8500   8500   8500      -    8000 14500 14500  14500   14500   14500 14500 14500   14500
  slin192  14500 14500 14500 14500 14500 14500    14500 14500  8500   8500   8500   8500   8500   8500   8500   8500       - 14500 14500  14500   14500   14500 14500 14500   14500
    lpc10  15000 15000 15000 15000 15000 15000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000     - 15000  15000   23000   23000 15000 17250   15000
     g729  15000 15000 15000 15000 15000 15000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000     -  15000   23000   23000 15000 17250   15000   ---> Good  , simila line r to 623 
   speex8  15000 15000 15000 15000 15000 15000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000      -   23000   23000 15000 17250   15000
  speex16  23500 23500 23500 23500 23500 23500    23500 23500 17500  17500   9000  17000  17000  17000  17000  17000   17000 23500 23500  23500       -   23000 23500 15000   23500
  speex32  23500 23500 23500 23500 23500 23500    23500 23500 17500  17500  17500  17500   9000  17000  17000  17000   17000 23500 23500  23500   23500       - 23500 23500   23500
     ilbc  15000 15000 15000 15000 15000 15000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000     - 17250   15000
     g722  15600 15600 15600 15600 15600 15600    15600 15600  9600  17500   9000  17000  17000  17000  17000  17000   17000 15600 15600  15600   15000   23000 15600     -   15600
  testlaw  15000 15000 15000 15000 15000 15000    15000 15000  9000  17000  17000  17000  17000  17000  17000  17000   17000 15000 15000  15000   23000   23000 15000 17250

```

Install java and maven
-----------------------------
```
#apt install openjdk-8-jdk/kali-rolling
```
Select number associated to openjdk 1.8 version. By default server has 11 installed.
```
#update-alternatives  --config java
#apt install maven
```

Create user and password for database.
---------------------------------------
Log into mariadb

```
#mysql -u root -h localhost -p
#password XXXX
mariadb> create database wi4solutions;
mariadb> GRANT ALL PRIVILEGES ON .* to 'wi4solutions'@'localhost' IDENTIFIED BY 'w14s0l_1';
mariadb> FLUSH PRIVILEGES;
```

Import database wi4solutions

```
mariadb>source /var/www/projects/wi4solutions/springboot/wi4solutions/database/wi4solutions.sql;
```
Compile and package project with maven and install as service

```
#cd /var/www/projects/wi4solutions/springboot/wi4solutions
#mvn  -Dmaven.test.skip=true -Dspring.profiles.active=prod,webpack,no-liquibase package
#ln -s /var/www/projects/wi4solutions/springboot/wi4solutions/target/wi-4-solutions-0.0.1-SNAPSHOT.war wi4solutions
# cd /var/www/projects/wi4solutions/springboot/wi4solutions/service
#cp  wi4solutions.service  /etc/systemd/system/wi4solutions.service
#systemctl enable wi4solutions.service
#service start wi4solutions

```

If want to see any log status, read file syslog to check any success or error message
```
#tail -200f /var/log/syslog

```
Can see application open port on syslog output:

```
Jan 13 13:45:07 vpn-client systemd[1]: Started Wi4solutions System.
Jan 13 13:45:12 vpn-client java[19569]:         ██╗ ██╗   ██╗ ████████╗ ███████╗   ██████╗ ████████╗ ████████╗ ███████╗
Jan 13 13:45:12 vpn-client java[19569]:         ██║ ██║   ██║ ╚══██╔══╝ ██╔═══██╗ ██╔════╝ ╚══██╔══╝ ██╔═════╝ ██╔═══██╗
Jan 13 13:45:12 vpn-client java[19569]:         ██║ ████████║    ██║    ███████╔╝ ╚█████╗     ██║    ██████╗   ███████╔╝
Jan 13 13:45:12 vpn-client java[19569]:   ██╗   ██║ ██╔═══██║    ██║    ██╔════╝   ╚═══██╗    ██║    ██╔═══╝   ██╔══██║
Jan 13 13:45:12 vpn-client java[19569]:   ╚██████╔╝ ██║   ██║ ████████╗ ██║       ██████╔╝    ██║    ████████╗ ██║  ╚██╗
Jan 13 13:45:12 vpn-client java[19569]:    ╚═════╝  ╚═╝   ╚═╝ ╚═══════╝ ╚═╝       ╚═════╝     ╚═╝    ╚═══════╝ ╚═╝   ╚═╝
Jan 13 13:45:12 vpn-client java[19569]: :: JHipster 🤓  :: Running Spring Boot 2.0.6.RELEASE ::
Jan 13 13:45:12 vpn-client java[19569]: :: https://www.jhipster.tech ::
Jan 13 13:45:12 vpn-client java[19569]: 2019-01-13 13:45:12.439  INFO 19569 --- [           main] com.wi4solutions.Wi4SolutionsApp         : Starting Wi4SolutionsApp on vpn-client with PID 19569 (/var/www/projects/wi4solutions/springboot/wi4solutions/target/wi-4-solutions-0.0.1-SNAPSHOT.war started by root in /)
Jan 13 13:45:12 vpn-client java[19569]: 2019-01-13 13:45:12.453  INFO 19569 --- [           main] com.wi4solutions.Wi4SolutionsApp         : The following profiles are active: prod,webpack,no-liquibase
Jan 13 13:45:29 vpn-client java[19569]: 2019-01-13 13:45:29.359  INFO 19569 --- [           main] com.wi4solutions.config.WebConfigurer    : Web application configuration, using profiles: prod
Jan 13 13:45:29 vpn-client java[19569]: 2019-01-13 13:45:29.377  INFO 19569 --- [           main] com.wi4solutions.config.WebConfigurer    : Web application fully configured
Jan 13 13:45:38 vpn-client java[19569]: 2019-01-13 13:45:38.020  INFO 19569 --- [           main] com.wi4solutions.Wi4SolutionsApp         : Started Wi4SolutionsApp in 28.415 seconds (JVM running for 30.155)
Jan 13 13:45:38 vpn-client java[19569]: 2019-01-13 13:45:38.035  INFO 19569 --- [           main] com.wi4solutions.Wi4SolutionsApp         :
Jan 13 13:45:38 vpn-client java[19569]: ----------------------------------------------------------
Jan 13 13:45:38 vpn-client java[19569]: #011Application 'wi4solutions' is running! Access URLs:
Jan 13 13:45:38 vpn-client java[19569]: #011Local: #011#011http://localhost:8080/
Jan 13 13:45:38 vpn-client java[19569]: #011External: #011http://127.0.1.1:8080/
Jan 13 13:45:38 vpn-client java[19569]: #011Profile(s): #011[prod, webpack, no-liquibase]
Jan 13 13:45:38 vpn-client java[19569]: ----------------------------------------------------------

```

Our application will be available on

http://[Server Public Ip]:8080/

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
