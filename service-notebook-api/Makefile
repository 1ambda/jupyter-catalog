TAG = "Makefile"

MODULE = service-notebook-api

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

