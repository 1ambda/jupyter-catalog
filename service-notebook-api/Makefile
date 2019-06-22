TAG = "Makefile"

MODULE = service-notebook-api
PYTHON_VERSION = 3.7.2

SWAGGER_DIR = ../schema/swagger
SWAGGER_SCHEMA = "$(SWAGGER_DIR)/notebook-entrypoint.yaml"
SWAGGER_SERVER_CONFIG = "$(SWAGGER_DIR)/config.notebook-server-python.json"
SWAGGER_SERVER_PACKAGE = "generated_swagger"
SWAGGER_SERVER_OUTPUT_DIR = "src/$(SWAGGER_SERVER_PACKAGE)"
SWAGGER_SERVER_OUTPUT_TEMP_DIR = ".swagger-codegen"

SWAGGER_CODEGEN_JAR=../script/swagger-codegen/swagger-codegen-cli.jar

##
## Swagger
##

.PHONY: swagger.clean
swagger.clean:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: cleaning generated swagger files"
	@ echo "-----------------------------------------\n"

	rm -rf $(SWAGGER_SERVER_OUTPUT_DIR)
	mkdir -p src/generated_swagger/spec || true

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Finished: cleaning generated swagger files"
	@ echo ""
	@ echo ""

.PHONY: swagger.server
swagger.server:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Started: generating swagger server files"
	@ echo "-----------------------------------------\n"

	@ java -jar $(SWAGGER_CODEGEN_JAR) generate -l python-flask -i $(SWAGGER_SCHEMA) -c $(SWAGGER_SERVER_CONFIG) -o $(SWAGGER_SERVER_OUTPUT_TEMP_DIR)
	mv $(SWAGGER_SERVER_OUTPUT_TEMP_DIR)/$(SWAGGER_SERVER_PACKAGE)/models $(SWAGGER_SERVER_OUTPUT_DIR)/models
	mv $(SWAGGER_SERVER_OUTPUT_TEMP_DIR)/$(SWAGGER_SERVER_PACKAGE)/encoder.py $(SWAGGER_SERVER_OUTPUT_DIR)/
	mv $(SWAGGER_SERVER_OUTPUT_TEMP_DIR)/$(SWAGGER_SERVER_PACKAGE)/util.py $(SWAGGER_SERVER_OUTPUT_DIR)/

	# replace swagger.yaml controller directory using 'sed 's/abc/XYZ/g' <infile >outfile'
	sed 's/generated_swagger.controllers/controller_swagger/g' <$(SWAGGER_SERVER_OUTPUT_TEMP_DIR)/$(SWAGGER_SERVER_PACKAGE)/swagger/swagger.yaml >$(SWAGGER_SERVER_OUTPUT_DIR)/spec/swagger.yaml

	@ echo "\n-----------------------------------------"
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Finished: generating swagger server files"
	@ echo ""
	@ echo ""

.PHONY: swagger
swagger: swagger.clean swagger.server

##
## Tool
##

.PHONY: tools.install
tools.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing tools"
	@ echo "-----------------------------------------\n"

	@ brew install pyenv
	@ brew install pyenv-virtualenv
	@ brew install direnv

.PHONY: tools.virtualenv-create
tools.pyenv-create:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Creating virtualenv 'jupyter-catalog' ($(PYTHON_VERSION))"
	@ echo "-----------------------------------------\n"

	@ pyenv virtualenv $(PYTHON_VERSION) jupyter-catalog

.PHONY: tools.virtualenv-activate
tools.pyenv-create:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Activating virtualenv 'jupyter-catalog' ($(PYTHON_VERSION))"
	@ echo "-----------------------------------------\n"

	@ pyenv activate jupyter-catalog

.PHONY: tools.virtualenv-deactivate
tools.pyenv-create:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Deactivating virtualenv 'jupyter-catalog' ($(PYTHON_VERSION))"
	@ echo "-----------------------------------------\n"

	@ pyenv activate jupyter-catalog

##
## Dependency
##

.PHONY: dependency.install
dependency.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing pip dependencies"
	@ echo "-----------------------------------------\n"

	@ pip install -r requirements.txt

.PHONY: dependency.list
dependency.list:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Listing pip dependencies"
	@ echo "-----------------------------------------\n"

	@ pip freeze

##
## Development
##

.PHONY: run
run:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ FLASK_RUN_PORT=9092 FLASK_ENV=development FLASK_APP=main.py flask run

.PHONY: test
test:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Testing application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ py.test

