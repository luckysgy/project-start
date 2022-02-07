#! /bin/bash

if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/mysql/log" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/mysql/log
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/mysql/log
fi

if [ ! -d "/mnt/data_disk/docker-volume/project/project-name/mysql/data" ]; then
  mkdir -p /mnt/data_disk/docker-volume/project/project-name/mysql/data
  chmod 777 /mnt/data_disk/docker-volume/project/project-name/mysql}/data
fi

docker stop mysql-server
docker rm mysql-server

docker run -d  \
--restart=always \
--name mysql-server \
-p 3306:3306 \
-v /mnt/data_disk/docker-volume/project/project-name/mysql/logs:/var/log/mysql/ \
-v /mnt/data_disk/docker-volume/project/project-name/mysql/data:/var/lib/mysql/ \
-e "TZ=Asia/Shanghai" \
-e "MYSQL_ROOT_PASSWORD=23423423"            \
{pull=mysql:8.0.21, tag=mysql-amd64} \
--default-authentication-plugin=mysql_native_password \
--character-set-server=utf8mb4 \
--collation-server=utf8mb4_general_ci \
--explicit_defaults_for_timestamp=true \
--lower_case_table_names=1 \
--max_allowed_packet=128M
echo "start mysql"
