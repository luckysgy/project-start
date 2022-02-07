FROM ubuntu:20.04
WORKDIR /root

RUN set -ex; cd /root				\
&& mkdir /root/config  \
&& echo "Asia/Shanghai" > /etc/timezone \
&& apt-get update && apt-get upgrade -y && apt-get install build-essential -y && apt-get install libasound2-dev -y && apt-get install libxcb* -y  \
&& rm -rf /var/lib/apt/lists/*

