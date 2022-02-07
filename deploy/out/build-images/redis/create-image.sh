#! /bin/bash

docker build -t redis-amd64 .
docker save redis-amd64 -o redis.tar
/bin/cp -r  redis ../../../data/
echo "image --- redis.tar save to /code/my/project-start/deploy/data"
rm -rf redis.tar