TAG = "Makefile"

GIT_COMMIT		= $(shell git rev-parse HEAD)
GIT_DIRTY		= $(shell test -n "`git status --porcelain`" && echo "DIRTY" || true)
VERSION			= $(shell cat ./VERSION)

VCS = github.com
REPOSITORY = 1ambda/jupyter-catalog
MODULE = module-api-swagger

SWAGGER_DIR = ../schema/swagger
SWAGGER_TEMPLATE_DIR = "${SWAGGER_DIR}/template-model-java"

PACKAGE_NOTEBOOK = "jupyter/notebook/generated"
SWAGGER_NOTEBOOK_SCHEMA = "$(SWAGGER_DIR)/notebook-entrypoint.yaml"
SWAGGER_NOTEBOOK_CLIENT_CONFIG = "$(SWAGGER_DIR)/config.notebook-client-java.json"

SWAGGER_NOTEBOOK_OUTPUT_DIR = "src/main/java/$(PACKAGE_NOTEBOOK)/swagger"
SWAGGER_NOTEBOOK_CLIENT_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE_NOTEBOOK)/swagger/client"
SWAGGER_NOTEBOOK_CLIENT_OUTPUT_DIR = "src/main/java/$(PACKAGE_NOTEBOOK)/swagger/client"
SWAGGER_NOTEBOOK_MODEL_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE_NOTEBOOK)/swagger/model"
SWAGGER_NOTEBOOK_MODEL_OUTPUT_DIR = "src/main/java/$(PACKAGE_NOTEBOOK)/swagger/model"

PACKAGE_CATALOG = "jupyter/catalog/generated"
SWAGGER_CATALOG_SCHEMA = "$(SWAGGER_DIR)/catalog-entrypoint.yaml"
SWAGGER_CATALOG_CLIENT_CONFIG = "$(SWAGGER_DIR)/config.catalog-client-java.json"

SWAGGER_CATALOG_OUTPUT_DIR = "src/main/java/$(PACKAGE_CATALOG)/swagger"
SWAGGER_CATALOG_CLIENT_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE_CATALOG)/swagger/client"
SWAGGER_CATALOG_CLIENT_OUTPUT_DIR = "src/main/java/$(PACKAGE_CATALOG)/swagger/client"
SWAGGER_CATALOG_MODEL_OUTPUT_GEN_DIR = "$(SWAGGER_OUTPUT_TEMP_DIR)/src/main/java/$(PACKAGE_CATALOG)/swagger/model"
SWAGGER_CATALOG_MODEL_OUTPUT_DIR = "src/main/java/$(PACKAGE_CATALOG)/swagger/model"

SWAGGER_OUTPUT_TEMP_DIR = ".swagger-codegen"

SWAGGER_CODEGEN_JAR=../script/swagger-codegen/swagger-codegen-cli.jar

.PHONY: swagger.clean-notebook
swagger.clean-notebook:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: cleaning generated swagger files (NOTEBOOK)"
	@ echo "-----------------------------------------\n"

	rm -rf $(SWAGGER_OUTPUT_TEMP_DIR)
	rm -rf $(SWAGGER_NOTEBOOK_OUTPUT_DIR)
	mkdir -p $(SWAGGER_NOTEBOOK_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: cleaning generated swagger files (NOTEBOOK)"
	@ echo ""
	@ echo ""

.PHONY: swagger.client-notebook
swagger.client-notebook:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: generating swagger client files (NOTEBOOK)"
	@ echo "-----------------------------------------\n"

	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l java -i $(SWAGGER_NOTEBOOK_SCHEMA) -c $(SWAGGER_NOTEBOOK_CLIENT_CONFIG) -t $(SWAGGER_TEMPLATE_DIR) -o $(SWAGGER_OUTPUT_TEMP_DIR)
	@ mv $(SWAGGER_NOTEBOOK_CLIENT_OUTPUT_GEN_DIR) $(SWAGGER_NOTEBOOK_CLIENT_OUTPUT_DIR)
	@ mv $(SWAGGER_NOTEBOOK_MODEL_OUTPUT_GEN_DIR) $(SWAGGER_NOTEBOOK_MODEL_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: generating swagger client files (NOTEBOOK)"
	@ echo ""
	@ echo ""

.PHONY: swagger.clean-catalog
swagger.clean-catalog:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: cleaning generated swagger files (CATALOG)"
	@ echo "-----------------------------------------\n"

	rm -rf $(SWAGGER_OUTPUT_TEMP_DIR)
	rm -rf $(SWAGGER_CATALOG_OUTPUT_DIR)
	mkdir -p $(SWAGGER_CATALOG_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: cleaning generated swagger files (CATALOG)"
	@ echo ""
	@ echo ""

.PHONY: swagger.client-catalog
swagger.client-catalog:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: generating swagger client files (CATALOG)"
	@ echo "-----------------------------------------\n"

	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l java -i $(SWAGGER_CATALOG_SCHEMA) -c $(SWAGGER_CATALOG_CLIENT_CONFIG) -t $(SWAGGER_TEMPLATE_DIR) -o $(SWAGGER_OUTPUT_TEMP_DIR)
	@ mv $(SWAGGER_CATALOG_CLIENT_OUTPUT_GEN_DIR) $(SWAGGER_CATALOG_CLIENT_OUTPUT_DIR)
	@ mv $(SWAGGER_CATALOG_MODEL_OUTPUT_GEN_DIR) $(SWAGGER_CATALOG_MODEL_OUTPUT_DIR)

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($$(date -u '+%H:%M:%S')) - Finished: generating swagger client files (CATALOG)"
	@ echo ""
	@ echo ""

.PHONY: swagger
swagger: swagger.clean-notebook swagger.client-notebook \
	 swagger.clean-catalog swagger.client-catalog
