test:
	./gradlew test

build:
	./gradlew app:shadowJar

app = ""

run:
	java -jar ./app/build/libs/app-all.jar ${app}
