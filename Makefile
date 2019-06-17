TAG = "Makefile"

DOCKER = docker
DOCKER_HOST_IP := $(shell ipconfig getifaddr en0)

VCS = github.com
REPOSITORY = "1ambda/jupyter-catalog"

##
## Compose
##

.PHONY: compose.prepare
compose.prepare:
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Preparing docker-compose"
	@ echo "-----------------------------------------\n"
	@ echo "export DOCKER_HOST_IP=$(DOCKER_HOST_IP)"
	@ echo "\n-----------------------------------------"
	@ echo ""

.PHONY: compose
compose: compose.prepare
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Running docker-compose"
	@ docker stop $(docker ps -a -q) || true
	@ docker rm -f $(docker ps -a -q) || true
	@ docker volume rm $(docker volume ls -f dangling=true -q) || true
	@ docker-compose -f docker-compose.storage.yml rm -fsv || true
	@ DOCKER_HOST_IP=$(DOCKER_HOST_IP) docker-compose \
		-f docker-compose.storage.yml \
		up

.PHONY: compose.clean
compose.clean:
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Starting: Cleaning docker resources"
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
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Connecting to mysql"
	@ $(MYSQLCLIENT) -u root -h localhost application -p root

.PHONY: redis
redis:
	@ echo "[$(TAG)] ($(shell TZ=UTC date -u '+%H:%M:%S')) - Connecting to redis"
	@ redis-cli -a credential

