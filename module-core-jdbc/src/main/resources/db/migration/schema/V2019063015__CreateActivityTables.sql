CREATE TABLE `Activity`
(
    -- primary key
    `id`         BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns
    `actor_id`   BIGINT UNSIGNED                           NOT NULL,

    INDEX `idx_Activity_actorId` (`actor_id`),

    CONSTRAINT `fk_Activity_actorId`
        FOREIGN KEY (`actor_id`) REFERENCES `User` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    -- common
    `version`    BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at` datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at` datetime,
    `locked`     VARCHAR(4)                                NOT NULL,

    INDEX `idx_Activity_createdAt` (`created_at`),
    INDEX `idx_Activity_deletedAt` (`deleted_at`),
    INDEX `idx_Activity_locked` (`locked`),

    -- columns
    `action`     VARCHAR(255)                              NOT NULL,
    `object_id`  BIGINT UNSIGNED                           NULL, -- polymorphic id (e.g product id, review id, ..)

    INDEX `idx_Activity_action` (`action`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `Notification`
(
    -- primary key
    `id`           BIGINT UNSIGNED                           NOT NULL AUTO_INCREMENT PRIMARY KEY,

    -- FK columns
    `activity_id`  BIGINT UNSIGNED                           NOT NULL,
    `recipient_id` BIGINT UNSIGNED                           NOT NULL,

    CONSTRAINT `fk_Notification_activityId`
        FOREIGN KEY (`activity_id`) REFERENCES `Activity` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    CONSTRAINT `fk_Notification_recipientId`
        FOREIGN KEY (`recipient_id`) REFERENCES `User` (`id`)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

    -- common
    `version`      BIGINT UNSIGNED DEFAULT '0'               NOT NULL,
    `created_at`   datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at`   datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `deleted_at`   datetime,
    `locked`       VARCHAR(4)                                NOT NULL,

    INDEX `idx_Notification_createdAt` (`created_at`),
    INDEX `idx_Notification_deletedAt` (`deleted_at`),
    INDEX `idx_Notification_locked` (`locked`),

    -- columns
    `segment`      VARCHAR(12)                               NOT NULL,
    `platform`     VARCHAR(12)                               NOT NULL,
    `state`        VARCHAR(12)                               NOT NULL,
    `message`      VARCHAR(255)                              NOT NULL,
    `link`         TEXT                                      NULL,

    INDEX `idx_Notification_segment` (`segment`),
    INDEX `idx_Notification_platform` (`platform`),
    INDEX `idx_Notification_state` (`state`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;