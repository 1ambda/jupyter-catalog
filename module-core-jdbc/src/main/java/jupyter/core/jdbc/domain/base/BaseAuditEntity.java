package jupyter.core.jdbc.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "`created_by`", nullable = true, updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "`modified_by`", nullable = true, updatable = true)
    @LastModifiedBy
    private String modifiedBy;
}
