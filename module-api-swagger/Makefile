TAG = "Makefile"

GIT_COMMIT		= $(shell git rev-parse HEAD)
GIT_DIRTY		= $(shell test -n "`git status --porcelain`" && echo "DIRTY" || true)
VERSION			= $(shell cat ./VERSION)

VCS = github.com
REPOSITORY = 1ambda/jupyter-catalog
MODULE = module-api-swagger
PACKAGE = "jupyter/notebook/generated"

SWAGGER_DIR = ../schema/swagger
SWAGGER_TEMPLATE_DIR = "${SWAGGER_DIR}/template-model-java"
SWAGGER_SCHEMA = "$(SWAGGER_DIR)/notebook-entrypoint.yaml"
SWAGGER_CLIENT_CONFIG = "$(SWAGGER_DIR)/config.notebook-client-java.json"
SWAGGER_OUTPUT_TEMP_DIR = ".swagger-codegen"
SWAGGER_OUTPUT_DIR = "src/main/java/$(PACKAGE)/swagger"
SWAGGER_CLIENT_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE)/swagger/client"
SWAGGER_CLIENT_OUTPUT_DIR = "src/main/java/$(PACKAGE)/swagger/client"
SWAGGER_MODEL_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE)/swagger/model"
SWAGGER_MODEL_OUTPUT_DIR = "src/main/java/$(PACKAGE)/swagger/model"

SWAGGER_CODEGEN_JAR=../script/swagger-codegen/swagger-codegen-cli.jar

.PHONY: swagger.clean
swagger.clean:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: cleaning generated swagger files"
	@ echo "-----------------------------------------\n"

	rm -rf $(SWAGGER_OUTPUT_TEMP_DIR)
	rm -rf $(SWAGGER_OUTPUT_DIR)
	mkdir -p $(SWAGGER_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: cleaning generated swagger files"
	@ echo ""
	@ echo ""

.PHONY: swagger.client
swagger.client:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: generating swagger client files"
	@ echo "-----------------------------------------\n"

	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l java -i $(SWAGGER_SCHEMA) -c $(SWAGGER_CLIENT_CONFIG) -t $(SWAGGER_TEMPLATE_DIR) -o $(SWAGGER_OUTPUT_TEMP_DIR)
	@ mv $(SWAGGER_CLIENT_OUTPUT_GEN_DIR) $(SWAGGER_CLIENT_OUTPUT_DIR)
	@ mv $(SWAGGER_MODEL_OUTPUT_GEN_DIR) $(SWAGGER_MODEL_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: generating swagger client files"
	@ echo ""
	@ echo ""


.PHONY: swagger
swagger: swagger.clean swagger.client
