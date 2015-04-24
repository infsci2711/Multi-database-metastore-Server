FROM ubuntu:14.04
MAINTAINER Evgeny Karataev <Karataev.Evgeny@gmail.com>

RUN echo hi there

RUN echo mysql-server mysql-server/root_password password ${MYSQL_PASSWORD} | debconf-set-selections
RUN echo mysql-server mysql-server/root_password_again password ${MYSQL_PASSWORD} | debconf-set-selections

RUN apt-get update && apt-get install -y \
    openssh-server \
    openjdk-7-jdk \
    curl \
    git \
    mysql-server

RUN echo ${MYSQL_PASSWORD}
RUN echo $MYSQL_PASSWORD


RUN mkdir -p /var/run/sshd

ENV MAVEN_VERSION 3.2.5

RUN curl -sSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

ENV MAVEN_HOME /usr/share/maven
ENV M2_HOME /usr/share/maven
ENV M2 $M2_HOME/bin

ENV PATH $M2:$PATH

RUN useradd -d /home/metastore metastore
RUN mkdir -p /home/metastore
RUN chown metastore /home/metastore

RUN echo "metastore:metastore" | chpasswd

COPY docker-entrypoint.sh /home/metastore/entrypoint.sh
COPY metastoredb.sql /home/metastore/metastoredb.sql

RUN chmod -R 777 /home/metastore

ENTRYPOINT ["/home/metastore/entrypoint.sh"]

EXPOSE 22

CMD ["/usr/sbin/sshd", "-D"]
