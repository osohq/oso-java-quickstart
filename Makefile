CURL_API := $(shell curl -s https://api.github.com/repos/osohq/oso/releases/latest | jq -r '.assets[] | select(.name| match("oso-java-*")) | .url')

install:
	mvn install

run:
	mvn clean package exec:java -Dexec.mainClass="quickstart.Server"
