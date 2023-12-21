package com.example.validator.transactionconfig;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@MappedSuperclass
public abstract class EntityBase implements Serializable {

  @CreatedBy
  private Integer createdBy;
  @CreatedDate
  private LocalDateTime createdAt;
  @LastModifiedBy
  private Integer updatedBy;
  @LastModifiedDate
  private LocalDateTime updatedAt;
  private boolean isDeleted = false;
}
