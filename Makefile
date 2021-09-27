install:
	mvn install

run:
	mvn clean package exec:java -Dexec.mainClass="quickstart.Server"
