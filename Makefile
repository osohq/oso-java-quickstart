CURL_API := $(shell curl -s https://api.github.com/repos/osohq/oso/releases/latest | jq -r '.assets[] | select(.name| match("oso-java-*")) | .url')

build:
	curl -L -H "Accept: application/octet-stream" $(CURL_API) --output oso-jar.zip
	unzip -o oso-jar.zip
	javac -cp ./*:src src/Server.java

run:
	java -cp ./*:src:. Server

clean:
	rm -f oso-*.zip oso-*.jar