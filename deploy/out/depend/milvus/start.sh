#! /bin/bash

if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/milvus/etcd" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/milvus/etcd
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/milvus/etcd
fi

if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/milvus/minio" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/milvus/minio
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/milvus/minio
fi

if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/milvus/milvus" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/milvus/milvus
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/milvus/milvus
fi

docker-compose down
docker-compose up -d