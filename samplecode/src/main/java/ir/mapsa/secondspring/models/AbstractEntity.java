package ir.mapsa.secondspring.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass
@Data
@ToString
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @CreatedDate
    private Date insertTimestamp;
    @LastModifiedDate
    private Date lastUpdateTimeStamp;
}
