CREATE TABLE `customers`
(
    `id`               BIGINT       NOT NULL AUTO_INCREMENT,
    `first_name`       VARCHAR(255) NOT NULL,
    `last_name`        VARCHAR(255) NOT NULL,
    `created_by`       VARCHAR(255) NULL,
    `created_at`       TIMESTAMP    NULL,
    `last_modified_by` VARCHAR(255) NULL,
    `last_modified_at` TIMESTAMP    NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `customers_history`
(
    `id`               BIGINT       NOT NULL AUTO_INCREMENT,
    `first_name`       VARCHAR(255) NOT NULL,
    `last_name`        VARCHAR(255) NOT NULL,
    `created_by`       VARCHAR(255) NULL,
    `created_at`       TIMESTAMP    NULL,
    `last_modified_by` VARCHAR(255) NULL,
    `last_modified_at` TIMESTAMP    NULL,
    `revision`         integer      NOT NULL,
    `revision_type`    smallint,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE `revision_infos`
(
    `revision_number`    INT    NOT NULL,
    `revision_timestamp` BIGINT NULL,
    PRIMARY KEY (`revision_number`)
);
