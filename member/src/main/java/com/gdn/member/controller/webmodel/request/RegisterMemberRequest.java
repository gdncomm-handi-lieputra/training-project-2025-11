package com.gdn.member.controller.webmodel.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMemberRequest {
  @NotBlank
  private String username;
  @NotBlank
  private String password;
  @NotBlank
  private String name;
  @NotBlank
  private String address;

}
