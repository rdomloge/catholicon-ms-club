docker buildx build --no-cache --platform linux/amd64 --build-arg ARCH=amd64 -t rdomloge/graalvm-21.1.0-java11:amd64 . --push
docker buildx build --no-cache --platform linux/arm64 --build-arg ARCH=aarch64 -t rdomloge/graalvm-21.1.0-java11:arm64 . --push

docker manifest rm rdomloge/graalvm-21.1.0-java11:multiarch
docker manifest create rdomloge/graalvm-21.1.0-java11:multiarch rdomloge/graalvm-21.1.0-java11:arm64 rdomloge/graalvm-21.1.0-java11:amd64
docker manifest push rdomloge/graalvm-21.1.0-java11:multiarch