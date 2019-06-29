CREATE TABLE `User`
(
    -- primary key
    `id`          BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns

    -- common
    `version`     BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`  datetime,
    `locked`      VARCHAR(4)                                NOT NULL,
    INDEX `idx_User_createdAt` (`created_at`),
    INDEX `idx_User_deletedAt` (`deleted_at`),
    INDEX `idx_User_locked` (`locked`),

    -- audit
    `created_by`  VARCHAR(255)                              NULL,
    `modified_by` VARCHAR(255)                              NULL,

    -- columns
    `name`        VARCHAR(255)                              NULL,
    `email`       VARCHAR(255)                              NULL,
    `image_url`   VARCHAR(255)                              NULL,
    `address`     VARCHAR(255)                              NULL,
    `department`  VARCHAR(255)                              NULL

    -- CONSTRAINT `uniq_User_email` UNIQUE (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `AuthIdentity`
(
    -- primary key
    `id`          BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns
    `user_id`     BIGINT UNSIGNED                           NOT NULL,

    INDEX `idx_AuthIdentity_userId` (`user_id`),

    CONSTRAINT `fk_AuthIdentity_userId`
        FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    -- common
    `version`     BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`  datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`  datetime,
    `locked`      VARCHAR(4)                                NOT NULL,
    INDEX `idx_AuthIdentity_createdAt` (`created_at`),
    INDEX `idx_AuthIdentity_deletedAt` (`deleted_at`),
    INDEX `idx_AuthIdentity_locked` (`locked`),

    -- audit
    `created_by`  VARCHAR(255)                              NULL,
    `modified_by` VARCHAR(255)                              NULL,

    -- columns
    `provider`    VARCHAR(255)                              NOT NULL,
    `username`    VARCHAR(255)                              NOT NULL,
    `password`    VARCHAR(255)                              NULL, -- could be null in case of OAuth Provider
    CONSTRAINT uniq_AuthIdentity_username UNIQUE (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;