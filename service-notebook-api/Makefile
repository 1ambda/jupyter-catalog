TAG = "Makefile"

MODULE = service-notebook-api
PYTHON_VERSION = 3.7.2

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

.PHONY: run
run:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ FLASK_ENV=development FLASK_APP=main.py flask run

.PHONY: test
test:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Testing application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ py.test

