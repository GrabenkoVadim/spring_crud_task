package employment.testtask.mapper;

import employment.testtask.dto.CustomerDto;
import employment.testtask.dto.CustomerRequestDto;
import employment.testtask.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);

    Customer toModel(CustomerRequestDto customerDto);
}
