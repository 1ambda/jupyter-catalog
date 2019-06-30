CREATE TABLE `Role`
(
    -- primary key
    `id`          BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- common
    `version`     BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`  datetime,
    `locked`      VARCHAR(4)                                NOT NULL,
    INDEX `idx_Role_createdAt` (`created_at`),
    INDEX `idx_Role_deletedAt` (`deleted_at`),
    INDEX `idx_Role_locked` (`locked`),

    -- audit
    `created_by`  VARCHAR(255)                              NULL,
    `modified_by` VARCHAR(255)                              NULL,

    -- columns
    `code`        VARCHAR(255)                              NOT NULL,
    `description` VARCHAR(255)                              NOT NULL,
    CONSTRAINT `uniq_Role_code` UNIQUE (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `RoleToUser`
(
    -- primary key
    `id`         BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns
    `role_id`    BIGINT UNSIGNED                           NOT NULL,
    `user_id`    BIGINT UNSIGNED                           NOT NULL,

    INDEX `idx_RoleToUser_roleId` (`role_id`),
    INDEX `idx_RoleToUser_userId` (`user_id`),

#   CONSTRAINT `uniq_RoleToUser_roleAndUserId`
#   UNIQUE (`role_id`, `user_id`),

    CONSTRAINT `fk_RoleToUser_role_id`
        FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT `fk_RoleToUser_user_id`
        FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    -- common
    `version`    BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at` datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at` datetime,
    `locked`     VARCHAR(4)                                NOT NULL,
    INDEX `idx_RoleToUser_createdAt` (`created_at`),
    INDEX `idx_RoleToUser_deletedAt` (`deleted_at`),
    INDEX `idx_RoleToUser_locked` (`locked`)

    -- columns
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `Permission`
(
    -- primary key
    `id`          BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- common
    `version`     BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`  datetime,
    `locked`      VARCHAR(4)                                NOT NULL,
    INDEX `idx_Permission_createdAt` (`created_at`),
    INDEX `idx_Permission_deletedAt` (`deleted_at`),

    -- audit
    `created_by`  VARCHAR(255)                              NULL,
    `modified_by` VARCHAR(255)                              NULL,

    -- columns
    `code`        VARCHAR(255)                              NOT NULL,
    `description` VARCHAR(255)                              NOT NULL,
    CONSTRAINT uniq_Permission_code UNIQUE (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `PermissionToRole`
(
    -- primary key
    `id`            BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns
    `permission_id` BIGINT UNSIGNED                           NOT NULL,
    `role_id`       BIGINT UNSIGNED                           NOT NULL,

    INDEX `idx_PermissionToRole_permissionId` (`permission_id`),
    INDEX `idx_PermissionToRole_roleId` (`role_id`),

    CONSTRAINT `uniq_PermissionToRole_permissionAndRoleId`
        UNIQUE (`permission_id`, `role_id`),

    CONSTRAINT `fk_PermissionToRole_permissionId`
        FOREIGN KEY (`permission_id`) REFERENCES `Permission` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_PermissionToRole_roleId`
        FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    -- common
    `version`       BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`    datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`    datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`    datetime,
    `locked`        VARCHAR(4)                                NOT NULL,
    INDEX `idx_PermissionToRole_createdAt` (`created_at`),
    INDEX `idx_PermissionToRole_deletedAt` (`deleted_at`),
    INDEX `idx_PermissionToRole_locked` (`locked`)

    -- columns
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;