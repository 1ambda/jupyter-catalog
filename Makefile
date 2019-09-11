TAG = "Makefile"

DOCKER = docker
DOCKER_HOST_IP := $(shell ipconfig getifaddr en0)

VCS = github.com
REPOSITORY = "1ambda/jupyter-catalog"

# SWAGGER_CODEGEN_VERSION = 2.4.5
SWAGGER_CODEGEN_VERSION = 3.0.11

##
## Tool
##

.PHONY: install.tool
install.tool:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing prerequisites"
	# @ wget http://central.maven.org/maven2/io/swagger/swagger-codegen-cli/$(SWAGGER_CODEGEN_VERSION)/swagger-codegen-cli-$(SWAGGER_CODEGEN_VERSION).jar -O script/swagger-codegen/swagger-codegen-cli.jar
	@ wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/$(SWAGGER_CODEGEN_VERSION)/swagger-codegen-cli-$(SWAGGER_CODEGEN_VERSION).jar -O script/swagger-codegen/swagger-codegen-cli.jar

#	@ pip install mycli
#	@ go get -u -v github.com/holys/redis-cli

##
## Swagger
##

.PHONY: swagger.client-api
swagger.client-api:
	@ cd module-api-swagger && make swagger

.PHONY: swagger.catalog-api
swagger.catalog-api:
	@ cd service-catalog-api && make swagger

.PHONY: swagger.catalog-ui
swagger.catalog-ui:
	@ cd service-catalog-ui && make swagger

.PHONY: swagger
swagger: swagger.client-api swagger.catalog-api swagger.catalog-ui

##
## Compose
##

.PHONY: compose.prepare
compose.prepare:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Preparing docker-compose"
	@ echo "-----------------------------------------\n"
	@ echo "export DOCKER_HOST_IP=$(DOCKER_HOST_IP)"
	@ echo "\n-----------------------------------------"
	@ echo ""

.PHONY: compose
compose: compose.prepare
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running docker-compose"
	@ docker stop $(docker ps -a -q) || true
	@ docker rm -f $(docker ps -a -q) || true
	@ docker volume rm $(docker volume ls -f dangling=true -q) || true
	@ docker-compose -f docker-compose.storage.yml rm -fsv || true
	@ DOCKER_HOST_IP=$(DOCKER_HOST_IP) docker-compose \
		-f docker-compose.storage.yml \
		up

.PHONY: compose.clean
compose.clean:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Starting: Cleaning docker resources"
	@ echo "-----------------------------------------\n"
	@ docker stop `docker ps -a -q` || true
	@ docker rm -f `docker ps -a -q` || true
	@ docker rmi -f `docker images --quiet --filter "dangling=true"` || true
	@ docker volume rm `docker volume ls -f dangling=true -q` || true
	@ rm -rf ./docker-volumes
	@ docker network rm `docker network ls -q` || true
	@ echo ""
	@ rm -rf metastore_db
	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Finished: Cleaning docker resources"

##
## CLI
##

.PHONY: mysql
mysql:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Connecting to mysql"
	@ mycli -u root -h localhost application -p root

.PHONY: redis
redis:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Connecting to redis"
	@ redis-cli -a credential

