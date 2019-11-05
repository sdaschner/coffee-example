FROM open-liberty:javaee8-java12

ADD --chown=1001:0 http://central.maven.org/maven2/org/postgresql/postgresql/9.4.1212/postgresql-9.4.1212.jar /liberty/lib/

COPY --chown=1001:0 src/main/liberty/config/configDropins/defaults/* /config/configDropins/defaults/
COPY --chown=1001:0 src/main/liberty/config/server.xml /config/

COPY --chown=1001:0 target/coffee-shop.war /config/dropins/
