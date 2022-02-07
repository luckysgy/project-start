#! /bin/bash
data_dir="/mnt/data_disk/docker-volume/project/project-name/redis"
cur_dir=$(pwd)
if [ ! -d "${data_dir}/data" ]; then
  mkdir -p ${data_dir}/data
  chmod 777 ${data_dir}/data
fi

if [ ! -d "${data_dir}/conf" ]; then
  mkdir -p ${data_dir}/conf
  chmod 777 ${data_dir}/conf
fi
/bin/cp -r conf/* ${data_dir}/conf
echo "copy conf to ${data_dir}/conf"

docker stop redis-server
docker rm redis-server
docker run -d --name redis-server -p ${port.appDepend.redis}:${port.appDepend.redis} --restart=always \
-v ${data_dir}/conf/redis.conf:/etc/redis/redis.conf \
-v ${data_dir}/data:/data {pull=redis:5.0.14, tag=redis-amd64} \
/etc/redis/redis.conf --port ${port.appDepend.redis}  --requirepass QWER@1234  --appendonly yes

docker ps | grep redis-server
echo "start success"