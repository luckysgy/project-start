#! /bin/bash
echo "copy tar to current..."
/bin/cp -r ../data/ubuntu_base_amd64.tar .
/bin/cp -r ../data/redis-amd64.tar .
/bin/cp -r ../data/minio-amd64.tar .
/bin/cp -r ../data/mysql-amd64.tar .
/bin/cp -r ../data/rocketmq-server-amd64.tar .
/bin/cp -r ../data/rocketmq-broker-amd64.tar .
/bin/cp -r ../data/rocketmq-console-ng-amd64.tar .
/bin/cp -r ../data/milvus-etcd-amd64.tar .
/bin/cp -r ../data/milvus-minio-amd64.tar .
/bin/cp -r ../data/milvus-amd64.tar .

echo "load images..."
docker load -i ubuntu_base_amd64.tar
docker load -i redis-amd64.tar
docker load -i minio-amd64.tar
docker load -i mysql-amd64.tar
docker load -i rocketmq-server-amd64.tar
docker load -i rocketmq-broker-amd64.tar
docker load -i rocketmq-console-ng-amd64.tar

docker load -i milvus-etcd-amd64.tar
docker load -i milvus-minio-amd64.tar
docker load -i milvus-amd64.tar

echo "rm current tar..."
rm -rf redis-amd64.tar
rm -rf ubuntu_base_amd64.tar
rm -rf minio-amd64.tar
rm -rf mysql-amd64.tar
rm -rf rocketmq-server-amd64.tar
rm -rf rocketmq-broker-amd64.tar
rm -rf rocketmq-console-ng-amd64.tar

echo "install docker-compose"
/bin/cp ../data/docker-compose docker-compose
# sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
/bin/cp docker-compose /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
docker-compose --version


echo "image load success"
