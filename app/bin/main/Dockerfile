FROM postgres
ENV POSTGRES_USER sqldemo
ENV POSTGRES_PASSWORD p4ssw0rd
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432