FROM gcc:5.5.0 as builder

RUN mkdir /root/build-data
WORKDIR /root/build-data
ADD nginx-1.20.1.tar.gz   .
ADD nginx-http-flv-module.tar.gz  /usr/local/src
ADD openssl-1.1.1i.tar.gz  /usr/local/src

# 编译openssl
RUN rm -rf /usr/local/lib64/libstdc++.so.6.0.21-gdb.py && apt-get install libssl-dev &&  cd /usr/local/src/openssl-1.1.1i && \
  rm -rf /usr/local/openssl/* && ./config --prefix=/usr/local/openssl --openssldir=/usr/local/openssl --shared && make -j60 && make install

RUN  rm -rf /usr/bin/openssl  && \
ln -s /usr/local/openssl/bin/openssl /usr/bin/openssl && \
echo "/usr/local/openssl/lib" >> /etc/ld.so.conf && \
ldconfig && \
rm -rf /usr/include/openssl && \
ln -s /usr/local/openssl/include /usr/include/openssl

RUN cd ./nginx-1.20.1 && ./configure --prefix=/usr/local/nginx  \
    --with-http_gzip_static_module \
    --with-http_stub_status_module \
    --with-stream  \
    --with-file-aio \
    --with-http_realip_module \
    --with-http_ssl_module \
    --with-http_mp4_module \
    --with-http_flv_module \
    --with-openssl=/usr/local/src/openssl-1.1.1i \
    --add-module=/usr/local/src/nginx-http-flv-module && \
  make -j60 && make install

FROM ubuntu:20.04
RUN mkdir -p /usr/local/nginx /usr/local/include/c++/5.5.0 /usr/local/gcc/bin  /usr/local/libexec/gcc/x86_64-linux-gnu/5.5.0 /usr/local/openssl /usr/local/nginx && \
  apt-get update                       && \
  apt-get install libpcre3 libpcre3-dev -y   && \
  apt-get install zlib1g-dev -y  && \
  apt-get install libpcre3 -y

COPY --from=builder /usr/local/nginx /usr/local/nginx
COPY --from=builder /usr/local/lib/gcc/x86_64-linux-gnu/5.5.0 /usr/local/gcc/lib
COPY --from=builder /usr/local/include/c++/5.5.0 /usr/local/include/c++/5.5.0
COPY --from=builder /usr/local/bin/g++ /usr/local/bin
COPY --from=builder /usr/local/bin/gcc /usr/local/bin
COPY --from=builder /usr/local/libexec/gcc/x86_64-linux-gnu/5.5.0 /usr/local/libexec/gcc/x86_64-linux-gnu/5.5.0

COPY --from=builder /usr/local/openssl /usr/local/openssl
COPY --from=builder /usr/local/src /usr/local/src

RUN cd . && \
ln -s /usr/local/nginx/sbin/nginx /usr/bin/nginx && \
ln -s /usr/local/bin/gcc  /usr/bin/gcc && \
ln -s /usr/local/bin/g++  /usr/bin/g++ && \
ln -s /usr/local/openssl/bin/openssl /usr/bin/openssl   &&  \
ln -s /usr/local/openssl/include/openssl /usr/include/openssl &&  \
echo "/usr/local/openssl/lib" >> /etc/ld.so.conf && \
ldconfig && \
ln -s /usr/local/openssl/include /usr/include/openssl && \
mkdir /usr/local/nginx/conf/tcpConf

ENTRYPOINT ["/bin/bash","-c", "/usr/bin/nginx && tail -f /dev/null"]


