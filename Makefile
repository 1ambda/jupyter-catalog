TAG = "Makefile"

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
