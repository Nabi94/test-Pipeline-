FROM ubuntu:latest

# Repo fayllarını container-ə köçür
COPY . /app

# İş qovluğu
WORKDIR /app

# Salam mesajı
RUN echo "Hello from inside container!"
