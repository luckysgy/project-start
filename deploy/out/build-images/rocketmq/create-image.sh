#! /bin/bash

docker pull foxiswho/rocketmq:server
docker pull foxiswho/rocketmq:broker
docker pull styletang/rocketmq-console-ng

docker tag foxiswho/rocketmq:server rocketmq-server
docker tag foxiswho/rocketmq:broker rocketmq-broker
docker tag styletang/rocketmq-console-ng rocketmq-console

docker save rocketmq-server -o rocketmq-server.tar
docker save rocketmq-broker -o rocketmq-broker.tar
docker save rocketmq-console -o rocketmq-console.tar

/bin/cp -r  rocketmq-server.tar ../../../data/
/bin/cp -r  rocketmq-broker.tar ../../../data/
/bin/cp -r  rocketmq-console.tar ../../../data/

echo "image --- rocketmq-server.tar save to  /code/my/project-start/deploy/data"
echo "image --- rocketmq-broker.tar save to  /code/my/project-start/deploy/data"
echo "image --- rocketmq-console.tar save to  /code/my/project-start/deploy/data"
rm -rf rocketmq-server.tar
rm -rf rocketmq-broker.tar
rm -rf rocketmq-console.tar

