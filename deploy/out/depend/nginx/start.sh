#! /bin/bash

docker stop nginx-http-flv-server
docker rm nginx-http-flv-server
cur_dir=$(pwd)
docker run -d  \
  -p 18009:18009 \
  -p 10001:10001  \
  -p 10002:10002 \
  -p 10004:10004 \
  --name nginx-http-flv-server \
  -v ${cur_dir}/nginx.conf:/usr/local/nginx/conf/nginx.conf \
  -v ${cur_dir}/conf-stream:/usr/local/nginx/conf/conf-stream \
  -v ${cur_dir}/conf-http:/usr/local/nginx/conf/conf-http \
  nginx-http-flv:v2