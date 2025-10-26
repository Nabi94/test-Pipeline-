FROM maven:3.9.0-eclipse-temurin-17

# Install Chrome və dependency-lər
RUN apt-get update && \
    apt-get install -y wget gnupg2 unzip curl xvfb libxi6 libgconf-2-4 && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Chrome versiyasını yoxla
RUN google-chrome --version

WORKDIR /app

# Əvvəlcə pom.xml kopyala və dependency-ləri yüklə (cache üçün)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Sonra source faylları kopyala
COPY src ./src

# Display variable
ENV DISPLAY=:99

# Test çalıştır
CMD ["mvn", "clean", "test"]