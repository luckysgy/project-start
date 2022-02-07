#! /bin/bash

docker build -t ubuntu .
docker save ubuntu -o ubuntu.tar
/bin/cp -r  ubuntu.tar ../../../data/
echo "image --- ubuntu.tar save to /code/my/project-start/deploy/data"
rm -rf ubuntu.tar

