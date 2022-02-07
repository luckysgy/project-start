#! /bin/bash
cur_dir=$(pwd)

docker stop nginxweb
docker rm nginxweb
docker run -d  \
  -p 60000:60000 \
  -p ${port.proxy.web}:${port.proxy.web}  \
  -p ${ed.nginx.grpcServer.videoStructured.listenPort}:${ed.nginx.grpcServer.videoStructured.nodePort}  \
  -p ${ed.nginx.play.rtmpPort}:${ed.nginx.play.rtmpPort} \
  -p ${ed.nginx.play.flvPort}:${ed.nginx.play.flvPort} \
 --name nginxweb \
 -v ${cur_dir}/nginx.conf:/usr/local/nginx/conf/nginx.conf \
 -v ${cur_dir}/tcpConf/tcp.conf:/usr/local/nginx/conf/tcpConf/tcp.conf \
 nginx_base
