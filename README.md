# HazelCast-Mongo MapStore example
Simple project to demonstrate the use of MapStore of Hazelcast. MapLoader provides 2-way communication with the datasource to both update and retrieve data. 

## Steps to Set-up 
1. Install mongo  
    `brew install mongodb`
    
2. Create dir data/db in root folder(/) where mongodb stores its data  
    `mkdir data`
    `cd data`  
    `mkdir db`
    
3. Give permission for mongo to write to the folder  
    `sudo chmod -R go+w /data/db`
    
4. Compile code  
    `mvn clean package`    

## Steps to Run         
1. Run the mongoDb  
    `mongod`
    
2. Open the mongoDb command line
    `mongo --host 127.0.0.1:27017`

3. Run the Runner          