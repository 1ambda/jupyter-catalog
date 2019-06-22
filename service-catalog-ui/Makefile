TAG = "Makefile"

MODULE = service-catalog-ui
NODE_VERSION = v10.16.0

ENV_FILE = .env
ENDPOINT_GATEWAY := $(or ${ENDPOINT_CATALOG_API},${ENDPOINT_CATALOG_API},http://localhost:9091)

GIT_COMMIT	= $(shell git rev-parse HEAD)
GIT_DIRTY	= $(shell test -n "`git status --porcelain`" && echo "DIRTY" || true)
VERSION		= $(shell cat ./VERSION)

SWAGGER_CLIENT_DIR	= "./src/generated/swagger"
SWAGGER_FILE		= "../schema/swagger/catalog-entrypoint.yaml"
SWAGGER_CONFIG		= "../schema/swagger/config.catalog-client-typescript.json"

SWAGGER_CODEGEN_JAR=../script/swagger-codegen/swagger-codegen-cli.jar


.PHONY: tools.install
tools.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing tools"
	@ echo "-----------------------------------------\n"

	@ npm install -g @vue/cli-service-global
	@ npm install -g @vue/cli
	@ npm install -g npm-check-updates

.PHONY: dependency.install
dependency.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing dependencies"
	@ echo "-----------------------------------------\n"

	@ npm install

.PHONY: dependency.update
dependency.update:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing dependencies"
	@ echo "-----------------------------------------\n"

	@ rm -rf node_modules/
	@ rm -rf package-lock.json
	@ ncu -u
	@ npm install

##
## Swagger
##

.PHONY: swagger-client
swagger-client:
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Generating swagger client files"

	@ rm -rf $(SWAGGER_CLIENT_DIR)		|| true
	@ mkdir -p $(SWAGGER_CLIENT_DIR)	|| true
	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l typescript-fetch \
		-i $(SWAGGER_FILE) -c $(SWAGGER_CONFIG) -o $(SWAGGER_CLIENT_DIR)

.PHONY: swagger
swagger: swagger-client

##
## Development
##

.PHONY: run
run:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ npm run serve

.PHONY: build
build:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Building frontend distribution"
	@ $(NPM) run build
