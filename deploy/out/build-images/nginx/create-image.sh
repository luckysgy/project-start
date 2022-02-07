#! /bin/bash

/bin/cp -r  ../../../data/nginx-1.20.1.tar.gz   .
/bin/cp -r  ../../../data/nginx-http-flv-module.tar.gz  .
/bin/cp -r  ../../../data/openssl-1.1.1i.tar.gz  .

docker build -t nginx_base .
docker save nginx_base -o nginx_base_amd64.tar
/bin/cp -r  nginx_base_amd64.tar ../../../data/
echo "image --- nginx_base_amd64.tar save to /code/my/project-start/deploy/data"
rm -rf nginx_base.tar
rm -rf nginx-1.20.1.tar.gz
rm -rf nginx-http-flv-module.tar.gz
rm -rf openssl-1.1.1i.tar.gz

