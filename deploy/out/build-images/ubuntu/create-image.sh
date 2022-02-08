#! /bin/bash

docker build -t ubuntu:20.04 .
docker save ubuntu:20.04 -o ubuntu.tar
/bin/cp -r  ubuntu.tar ../../../data/
echo "image --- ubuntu.tar save to /code/my/project-start/deploy/data"
rm -rf ubuntu.tar

