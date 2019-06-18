TAG = "Makefile"

MODULE = service-catalog-ui
NODE_VERSION = v10.16.0

.PHONY: tools.install
tools.install:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Installing tools"
	@ echo "-----------------------------------------\n"

	@ npm install -g @vue/cli-service-global
	@ npm install -g @vue/cli

.PHONY: run
run:
	@ echo "[$(TAG)] ($(shell date '+%H:%M:%S')) - Running application $(MODULE)"
	@ echo "-----------------------------------------\n"

	@ npm run serve
