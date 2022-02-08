FROM ${baseImage.ubuntu.tag}

WORKDIR /opt
ADD nginx-1.20.1.tar.gz   .
ADD nginx-http-flv-module.tar.gz  .
ADD openssl-1.1.1i.tar.gz  .

RUN set -ex; apt-get update && \
apt-get install wget gcc g++ make libffi-dev libssl-dev libtool libpcre3 libpcre3-dev \
zlib1g-dev libpcre3 -y && \
mkdir -p /usr/local/nginx/confpt/conf-stream && mkdir -p /usr/local/nginx/conf/conf-http

RUN set -ex; cd /opt/openssl-1.1.1i && \
./config --prefix=/usr/local/openssl --openssldir=/usr/local/openssl --shared && \
make -j20 && make install 

RUN set -ex;cd /opt/nginx-1.20.1 && \
./configure --prefix=/usr/local/nginx  \
--with-http_gzip_static_module \
--with-http_stub_status_module \
--without-http_gzip_module \
--with-stream  \
--with-file-aio \
--with-http_realip_module \
--with-http_ssl_module \
--with-http_mp4_module \
--with-http_flv_module \
--add-module=/opt/nginx-http-flv-module && \
make -j20 && make install && \
ln -s /usr/local/nginx/sbin/nginx /usr/bin/nginx && \
echo "/usr/local/openssl/lib" >> /etc/ld.so.conf && \
ldconfig 

ENTRYPOINT ["/bin/bash","-c", "/usr/bin/nginx && tail -f /dev/null"]


