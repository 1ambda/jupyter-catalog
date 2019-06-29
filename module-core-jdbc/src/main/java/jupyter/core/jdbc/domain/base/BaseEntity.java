package jupyter.core.jdbc.domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import jupyter.common.time.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("id")
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    @Column(name = "`version`")
    protected Long version;

    @Column(name = "`created_at`", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "`updated_at`", nullable = false, updatable = true)
    protected LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = Time.getCurrentLocalDateTime();
        this.updatedAt = Time.getCurrentLocalDateTime();
        this.locked = YesNo.N;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Time.getCurrentLocalDateTime();
    }

    protected static final String NOT_DELETED =
            "deleted_at > CURRENT_TIMESTAMP OR deleted_at IS NULL";

    @Column(name = "`deleted_at`")
    protected LocalDateTime deletedAt;

    /**
     * @return true if its deleted
     */
    public boolean isDeleted() {
        if (this.deletedAt == null) {
            return false;
        }

        return Time.getCurrentLocalDateTime().isAfter(this.deletedAt);
    }

    /**
     * @param then
     * @return true if its deleted
     */
    private boolean isDeletedAt(LocalDateTime then) {
        if (this.deletedAt == null) {
            return false;
        }

        return then.isAfter(this.deletedAt);
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "`locked`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected YesNo locked;

    /**
     * @return true if temporarily disabled.
     */
    public boolean isLocked() {
        return YesNo.Y.equals(this.locked);
    }

    /**
     * @return true if not disabled (locked) and not deleted.
     */
    public boolean isAvailable() {
        return !isLocked() && !isDeleted();
    }

    /**
     * @param then
     * @return true if not disabled (locked) and not deleted.
     */
    public boolean isAvailableAt(LocalDateTime then) {
        return !isLocked() && !isDeletedAt(then);
    }

    /**
     * @return timestamp for `createdAt`
     */
    public Long getCreateTimestamp() {
        return Time.convertToEpochMillis(createdAt);
    }

    /**
     * @return timestamp for `updatedAt`
     */
    public Long getUpdateTimestamp() {
        return Time.convertToEpochMillis(updatedAt);
    }

    /**
     * @return timestamp for `deletedAt`
     */
    public Long getDeleteTimestamp() {
        return Time.convertToEpochMillis(deletedAt);
    }
}

