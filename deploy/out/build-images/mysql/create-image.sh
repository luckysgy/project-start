#! /bin/bash

docker pull mysql:8.0.21
docker tag mysql:8.0.21 mysql-amd64

docker save mysql-amd64 -o mysql.tar

/bin/cp -r  mysql.tar ../../../data/

echo "image --- mysql.tar save to  /code/my/project-start/deploy/data"
rm -rf mysql.tar

