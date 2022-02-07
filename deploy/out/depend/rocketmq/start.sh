#! /bin/bash

cur_dir=$(pwd)
data_dir="/mnt/data_disk/docker-volume/project/project-name/rocketmq"

if [ ! -d "${data_dir}/rmqnamesrv/logs" ]; then
  mkdir -p ${data_dir}/rmqnamesrv/logs
  chmod 777 ${data_dir}/rmqnamesrv/logs
fi

if [ ! -d "${data_dir}/rmqnamesrv/store" ]; then
  mkdir -p ${data_dir}/rmqnamesrv/store
  chmod 777 ${data_dir}/rmqnamesrv/store
fi

if [ ! -d "${data_dir}/rmqbroker/log" ]; then
  mkdir -p ${data_dir}/rmqbroker/log
  chmod 777 ${data_dir}/rmqbroker/log
fi

if [ ! -d "${data_dir}/rmqbroker/store" ]; then
  mkdir -p ${data_dir}/rmqbroker/store
  chmod 777 ${data_dir}/rmqbroker/store
fi

if [ ! -d "${data_dir}/rmqbroker/brokerconf" ]; then
  mkdir -p ${data_dir}/rmqbroker/brokerconf
  chmod 777 ${data_dir}/rmqbroker/brokerconf
fi
/bin/cp -r ${cur_dir}/broker.conf ${data_dir}/rmqbroker/brokerconf
docker stop rmqbroker rmqnamesrv rmqconsole 
docker rm rmqbroker rmqnamesrv rmqconsole


docker run -d \
--restart=always \
--name rmqnamesrv \
-p ${port.appDepend.rocketmq.rmqnamesrv}:9876 \
-v /mnt/data_disk/docker-volume/project/project-name/rocketmq/rmqnamesrv/logs:/opt/logs \
-v /mnt/data_disk/docker-volume/project/project-name/rocketmq/rmqnamesrv/store:/opt/store \
-e "MAX_POSSIBLE_HEAP=100000000" \
foxiswho/rocketmq-${ed.rocketmq.osArchitecture}:server
echo "start rmqnamesrv"
sleep 5

docker run -d  \
--restart=always \
--name rmqbroker \
--link rmqnamesrv:namesrv \
-p 10911:10911 \
-p 10909:10909 \
-v /mnt/data_disk/docker-volume/project/project-name/rocketmq/rmqbroker/log:/opt/logs \
-v /mnt/data_disk/docker-volume/project/project-name/rocketmq/rmqbroker/store:/opt/store \
-v /mnt/data_disk/docker-volume/project/project-name/rocketmq/rmqbroker/brokerconf/broker.conf:/etc/rocketmq/broker.conf \
-e "NAMESRV_ADDR=namesrv:9876" \
-e "JAVA_OPTS=-Duser.home=/opt"            \
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m -Xmn128m"           \
-e "MAX_POSSIBLE_HEAP=200000000" \
foxiswho/rocketmq-${ed.rocketmq.osArchitecture}:broker \
mqbroker -c /etc/rocketmq/broker.conf
echo "start rmqbroker"

sleep 5
docker run -d \
--restart=always \
--link rmqnamesrv:namesrv \
--name rmqconsole \
-e "JAVA_OPTS=-Drocketmq.namesrv.addr=namesrv:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" \
-v /etc/localtime:/etc/localtime  \
-p 8080:${port.appDepend.rocketmq.rmqconsole} \
styletang/rocketmq-console-ng-${ed.rocketmq.osArchitecture}
echo "start rmqconsole"


