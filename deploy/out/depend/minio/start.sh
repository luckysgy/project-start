#! /bin/bash
if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/minio" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/minio
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/minio
fi

docker stop minio-server
docker rm minio-server
docker run -d --name minio-server -p ${port.appDepend.minio}:${port.appDepend.minio} --restart=always \
-e MINIO_ACCESS_KEY=minioadmin   \
-e MINIO_SECRET_KEY=minioadmin   \
-v /mnt/data_disk/docker-volume/project/project-name/minio:/data \
{pull=minio/minio:RELEASE.2021-06-14T01-29-23Z, tag=minio-amd64} \
server /data --address 0.0.0.0:${port.appDepend.minio}

docker ps | grep minio-server
echo "start success"