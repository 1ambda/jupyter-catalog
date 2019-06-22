TAG = "Makefile"

GIT_COMMIT		= $(shell git rev-parse HEAD)
GIT_DIRTY		= $(shell test -n "`git status --porcelain`" && echo "DIRTY" || true)
VERSION			= $(shell cat ./VERSION)

VCS = github.com
REPOSITORY = 1ambda/jupyter-catalog
MODULE = service-catalog-api
PACKAGE = "jupyter/catalog/generated"

SWAGGER_DIR = ../schema/swagger
SWAGGER_TEMPLATE_DIR = "${SWAGGER_DIR}/template-model-java"
SWAGGER_SCHEMA = "$(SWAGGER_DIR)/catalog-entrypoint.yaml"
SWAGGER_SERVER_CONFIG = "$(SWAGGER_DIR)/config.catalog-server-java.json"
SWAGGER_SERVER_OUTPUT_DIR = "src/main/java/$(PACKAGE)/swagger"
SWAGGER_SERVER_OUTPUT_TEMP_DIR = ".swagger-codegen"

SWAGGER_CODEGEN_JAR=../script/swagger-codegen/swagger-codegen-cli.jar

.PHONY: swagger.clean
swagger.clean:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: cleaning generated swagger files (CATALOG)"
	@ echo "-----------------------------------------\n"

	rm -rf $(SWAGGER_SERVER_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Finished: cleaning generated swagger files (CATALOG)"
	@ echo ""
	@ echo ""

.PHONY: swagger.server
swagger.server:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: generating swagger server files (CATALOG)"
	@ echo "-----------------------------------------\n"

	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l spring -i $(SWAGGER_SCHEMA) -c $(SWAGGER_SERVER_CONFIG) -t $(SWAGGER_TEMPLATE_DIR) -o .
	rm -rf $(SWAGGER_SERVER_OUTPUT_DIR)/model
	rm -rf $(SWAGGER_SERVER_OUTPUT_TEMP_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Finished: generating swagger server files (CATALOG)"
	@ echo ""
	@ echo ""

.PHONY: swagger
swagger: swagger.clean swagger.server
