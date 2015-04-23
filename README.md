# Multi-database-metastore-Server
Multi-database metastore Server

Description

The goal of this project is to keep information (source description in terms of virtual data integration approach) about the available data stores.
 
The information should include all useful aspects, e.g. url, port, username, password, database name, what protocol to use to connect, what connection format is, any other information about the datastore. The information should be collected in two ways:

1. Ask user to input whatever they can/need to input.

2. User info that user input (e.g. connection info), you need to connect to the data store and collect more metadata. E.g. table names, their schemas, some data statistics, e.g. how much data there is, etc.

REST service instruction

1) To show all datasources ids with dbNames, the API is:
Method: GET
/datasources/ids
 
and the result should be the JSON array:  [{id:..., dbName:""},...]
 
2) To get all tables names for a given datasource API is as:
Method: GET
/datasources/{id}/tables
 
the {id} is the parameter
that is for given id of the datasource, you return the list of table names ["", "", ...]
 
3) Get list of columns for given datasource id and table name, the API is:
Method: GET
/datasources/{id}/{tableName}/columns
 
the {id} and {tableName} are the parameters
the result should be JSON array of column names ["", "", ...]
 
4) Get just one datasource info by datasource id. The API is as:
Method: GET
/datasources/{id}
 
{id} is the parameter
 
JSON:
{ "id": 1, "IPAddress": "ip1", "port": 123, "DBname": "dbName1", "username": "username1", "password": "password1", "DBtype": "MySQL", "tables": [ { "tableName" : "test",   "columns": [ { "columnName": "field" } ] } ] }
 

5) To register a new datasource the API is:
Method: PUT
/datasources/add
 
JSON:
{ "IPAddress": "ip1", "port": 123, "DBname": "dbName1", "username": "username1", "password": "password1", "DBtype": "MySQL"}
 
 
6) Get all datasources info. The API is as:
Method: GET
/datasources

