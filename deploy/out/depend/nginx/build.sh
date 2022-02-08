#! /bin/bash
/bin/cp -r  ../../../data/nginx-1.20.1.tar.gz   .
/bin/cp -r  ../../../data/nginx-http-flv-module.tar.gz  .
/bin/cp -r  ../../../data/openssl-1.1.1i.tar.gz  .
/bin/cp -r  ../../../data/pcre-8.45.tar.gz  .

docker build -t nginx-http-flv:v2 .

rm -rf  nginx-1.20.1.tar.gz 
rm -rf  nginx-http-flv-module.tar.gz
rm -rf  openssl-1.1.1i.tar.gz  
rm -rf  pcre-8.45.tar.gz  
