mvn clean package
java -Dvraptor.webappdir=target/am/ \
	-Ddeploy.timestamp=${TIMESTAMP} \
	-cp target/am/WEB-INF/classes/:target/am/WEB-INF/lib/* \
	br.com.fiap.am.boot.Main 