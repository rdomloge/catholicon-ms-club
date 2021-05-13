docker buildx build --no-cache --platform=linux/amd64,linux/arm64 -t rdomloge/catholicon-ms-club-multiarch -f Dockerfile-non-native . --push
