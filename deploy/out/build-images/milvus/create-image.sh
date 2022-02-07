#! /bin/bash
docker pull quay.io/coreos/etcd:v3.5.0
docker pull minio/minio:RELEASE.2020-12-03T00-03-10Z
docker pull milvusdb/milvus:v2.0.0-pre-ga
docker tag quay.io/coreos/etcd:v3.5.0 milvus-etcd
docker tag minio/minio:RELEASE.2020-12-03T00-03-10Z milvus-minio
docker tag milvusdb/milvus:v2.0.0-pre-ga milvus-server

docker save milvus-etcd -o milvus-etcd.tar
docker save milvus-minio -o milvus-minio.tar
docker save milvus-server -o milvus-server.tar

/bin/cp -r  milvus-etcd.tar ../../../data/
/bin/cp -r  milvus-minio.tar ../../../data/
/bin/cp -r  milvus-server.tar ../../../data/

echo "image --- milvus-etcd.tar save to  /code/my/project-start/deploy/data"
echo "image --- milvus-minio.tar save to  /code/my/project-start/deploy/data"
echo "image --- milvus-server.tar save to  /code/my/project-start/deploy/data"

rm -rf milvus-etcd.tar
rm -rf milvus-minio.tar
rm -rf milvus-server.tar
