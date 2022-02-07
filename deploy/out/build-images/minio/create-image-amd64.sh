#! /bin/bash
docker pull minio/minio:RELEASE.2021-06-14T01-29-23Z
docker tag minio/minio:RELEASE.2021-06-14T01-29-23Z minio-amd64

docker save minio-amd64 -o minio.tar
/bin/cp -r  minio.tar ../../../data/
echo "image --- minio.tar save to  /code/my/project-start/deploy/data"
rm -rf minio.tar
