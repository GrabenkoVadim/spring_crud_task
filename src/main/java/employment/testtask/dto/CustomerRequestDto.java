package employment.testtask.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequestDto {
    @Size(min = 2, max = 50)
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{6,14}$")
    private String phone;

    public @Size(min = 2, max = 50) String getFullName() {
        return fullName;
    }

    public void setFullName(@Size(min = 2, max = 50) String fullName) {
        this.fullName = fullName;
    }

    public @NotNull @Email @Size(max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email @Size(max = 100) String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^\\+?[0-9]{6,14}$") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(regexp = "^\\+?[0-9]{6,14}$") String phone) {
        this.phone = phone;
    }
}
