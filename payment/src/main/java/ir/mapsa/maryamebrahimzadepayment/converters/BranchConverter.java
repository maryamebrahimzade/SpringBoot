package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BranchDto;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface BranchConverter extends BaseConverter<BranchDto, Branch> {

}
